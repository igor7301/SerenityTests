import com.SearchRequest;
import com.pages.YandexMarketPageFactory;
import com.steps.YandexHomePageSteps;
import com.steps.YandexMarketPageSteps;
import com.steps.YandexResultsPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Arrays;


/**
 * Created by Igor on 12/27/2017.
 */
@RunWith(SerenityRunner.class)
public class MySerenityTest {

    @Managed(driver = "chrome")
    public WebDriver webdriver;

//    @ManagedPages(defaultUrl = "http://www.yandex.com")
//    Pages pages;


    @Steps
    YandexHomePageSteps yandexHomePageSteps;

    @Steps
    YandexMarketPageSteps yandexMarketPageSteps;

    @Steps
    YandexResultsPageSteps yandexResultsPageSteps;


    @Test
    public void firstTest() {

       // webdriver.navigate().to("http://www.yandex.com");

        //2. Зайти на yandex.ru.
        yandexHomePageSteps.open();

        //3. Перейти в яндекс маркет
        yandexHomePageSteps.openYandexMarket();

        //4. Выбрать раздел Компьютеры
        yandexMarketPageSteps.openMainCategory("Компьютеры");

        //5. Выбрать раздел Ноутбуки
        yandexMarketPageSteps.openSubCategory("Ноутбуки");

        //6. Зайти в расширенный поиск
        //7. Задать параметр поиска до 30000 рублей.
        //8. Выбрать производителя HP и Lenovo
        //9. Нажать кнопку Применить.
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setEndPrice(BigDecimal.valueOf(30000));
        searchRequest.setManufacturer(Arrays.asList("Lenovo", "HP"));
        yandexMarketPageSteps.applyFilter(searchRequest);

        //11. Запомнить первый элемент в списке.
        searchRequest = new SearchRequest();
        String productName = YandexMarketPageFactory.getPage().getResults().get(0).getProductName();
        searchRequest.setProductName(productName);

        //12. В поисковую строку ввести запомненное значение.
        yandexMarketPageSteps.makeSearch(searchRequest.getProductName());

        //13. Найти и проверить, что наименование товара соответствует запомненному значению.
        yandexResultsPageSteps.verifyResults(searchRequest);

    }


}

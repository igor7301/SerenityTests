package com.steps;

import com.SearchRequest;
import com.pages.YandexHeader;
import com.pages.YandexResultsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexResultsPageSteps extends ScenarioSteps {

    YandexHeader yandexHeader;
    YandexResultsPage yandexResultsPage;

    /**
     * Производит яндекс поиск по тексту
     * @param searchText текст для поиска в строке яндекса
     */
    @Step("I make search with \"{searchText}\" text")
    public void makeSearch(String searchText) {
        yandexHeader.makeSearch(searchText);
    }

    /**
     * Проверяет что товар на странице результатов соответсвует ожидаемому
     * @param searchRequest ожидаемый результат поиска
     */
    @Step("I verify product item on result page ...")
    public void verifyResults(SearchRequest searchRequest) {



        if (searchRequest.getStartPrice() != null) {
            //добавьте проверку startPrice здесь
        }

        if (searchRequest.getEndPrice() != null) {
            //добавьте проверку endPrice здесь

        }

        if (searchRequest.getManufacturer() != null) {
            for (String manufacture : searchRequest.getManufacturer()) {
                //добавьте проверку всех фирм производителей здесь
            }
        }

        //проверка наименования товара
        if (searchRequest.getProductName() != null) {
            assertThat("Product title on results page should be : " + searchRequest.getProductName(),
                    yandexResultsPage.getTitleOfProduct(), Matchers.equalToIgnoringCase(searchRequest.getProductName()));
        }




    }

}

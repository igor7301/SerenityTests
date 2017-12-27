package com.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

/**
 * Created by Igor on 12/27/2017.
 */
@DefaultUrl("http://www.yandex.com")
public class YandexHomePage  extends PageObject {


    private static final String SEARCH_BOX = ".home-arrow .input__box";
    private static final String MARKET_LINK = "a[data-statlog='sites.market.title']";

//    public YandexHomePage(WebDriver driver) {
//        super(driver);
//    }


    @WhenPageOpens
    public void waitUntilVisible() {
        $(SEARCH_BOX).waitUntilVisible();
    }

    /**
     * Открывает яндекс маркет
     */
    public YandexMarketPage openMarket() {
        find(By.cssSelector(MARKET_LINK)).click();
        return getPages().getPage(YandexMarketPage.class);
    }


}

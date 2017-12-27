package com.pages;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getPages;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexMarketPageFactory extends PageObject {

    //маркер (кнопка Все Категории) которая присутствует только на одной из версии  яндекс маркет страницы
    private static final String MARKER_ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";

    private YandexMarketPageFactory() {
    }

    /**
     *
     * @return активную версию страницы яндекс маркета
     */
    public static YandexMarketAbstractPage getPage() {

        try {
            ThucydidesWebDriverSupport.getDriver().findElement(By.cssSelector(".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button")).isDisplayed();

            return getPages().getPage(YandexMarketPage.class);

        }
        catch (Exception e) {
            return getPages().getPage(YandexMarketPage2.class);
        }

    }

}

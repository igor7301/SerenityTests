package com.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexHeader extends PageObject {

    private static final String SEARCH_FIELD = "#header-search";

    /**
     * Делает поиск через заголовок яндекса
     * @param searchText строка для поиска
     */
    public void makeSearch(String searchText) {

        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).sendKeys(searchText);
        $(SEARCH_FIELD).sendKeys(Keys.ENTER);
    }

}

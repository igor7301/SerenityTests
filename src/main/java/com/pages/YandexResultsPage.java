package com.pages;

import net.thucydides.core.pages.PageObject;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexResultsPage extends PageObject {

    private static final String TITLE_OF_PRODUCT = ".n-title__text";

    /**
     * Возвращает название первого и единственного товара со страницы результатов
     * @return название товара
     */
    public String getTitleOfProduct() {
        return $(TITLE_OF_PRODUCT).getText();
    }



}

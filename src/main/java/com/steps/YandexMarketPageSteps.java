package com.steps;

import com.SearchRequest;
import com.pages.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexMarketPageSteps extends ScenarioSteps {

    YandexFilter yandexFilter;
    YandexHeader yandexHeader;

    @Step("Open category with name {categoryName}")
    public void openMainCategory(String categoryName) {
        YandexMarketAbstractPage yandexMarketPage = YandexMarketPageFactory.getPage();
        yandexMarketPage.openNavPanel();
        yandexMarketPage.openMainDepartment(categoryName);
    }

    @Step("Open sub-category with name {subCategoryName}")
    public void openSubCategory(String subCategoryName) {
        YandexMarketAbstractPage yandexMarketPage = YandexMarketPageFactory.getPage();
        yandexMarketPage.openSubDepartment(subCategoryName);
    }

    @Step("I apply filter ... ")
    public void applyFilter(SearchRequest searchRequest) {

        if (searchRequest.getStartPrice() != null) {
            yandexFilter.setStartPrice(searchRequest.getStartPrice());
        }

        if (searchRequest.getEndPrice() != null) {
            yandexFilter.setEndPrice(searchRequest.getEndPrice());

        }

        if (searchRequest.getManufacturer() != null) {
            for (String manufacture : searchRequest.getManufacturer()) {

                yandexFilter.setManufacture(manufacture);
            }
        }
        yandexFilter.apply();

    }

    /**
     * Производит яндекс поиск по тексту
     * @param searchText текст для поиска в строке яндекса
     */
    @Step("I make search with \"{searchText}\" text")
    public void makeSearch(String searchText) {
        yandexHeader.makeSearch(searchText);
    }
}

package com.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

import java.math.BigDecimal;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexFilter extends PageObject {



    private static final String START_PRICE = ".n-filter-panel-aside .input_price_from .input__control";
    private static final String END_PRICE =  ".n-filter-panel-aside .input_price_to .input__control"; //".search-layout #glpriceto";
    private static final String MANUFACTURE_LIST = ".n-filter-panel-aside__content .n-filter-block:nth-child(4) .checkbox";
    private static final String MANUFACTURE_CHECK_BOX = ".checkbox__label";
    private static final String APPLY_FILTER_BTN = ".n-filter-panel-aside__apply button";
    private static final String SPINNER = ".preloadable__preloader";


    /**
     * Устанавливает начальную цену в параметры фильтра
     * @param startPrice
     */
    @Step("I set start price {0}")
    public void setStartPrice(BigDecimal startPrice) {
        $(START_PRICE).sendKeys(startPrice.toString());
    }


    /**
     * Устанавливает конечную цену в парамерты фильтра
     * @param endPrice
     */
    @Step("I set end price {0}")
    public void setEndPrice(BigDecimal endPrice) {
        $(END_PRICE).sendKeys(endPrice.toString());
    }


    /**
     * Устанавливает в параметры фильтра фирму производителя товара
     * @param manufacture фирма производитель
     */
    @Step("I set manufacture {0}")
    public void setManufacture(String manufacture) {

        for (WebElementFacade manufactureElement : findAll(MANUFACTURE_LIST)) {
            if (manufactureElement.getText().equalsIgnoreCase(manufacture)) {
                manufactureElement.findBy(MANUFACTURE_CHECK_BOX).click();
            }
        }
    }

    /**
     * Применяет фильтр и ожидает завершения обновления результатов
     */
    public void apply() {
        $(APPLY_FILTER_BTN).click();
        waitUntilResultsUpdated();
    }

    /**
     * Ожидает завершения обновления результатов
     */
    private void waitUntilResultsUpdated() {
        try {

//            $(SPINNER).waitUntil(Condition.visible, TIMEOUT_IN_MILLISECONDS_10000);
            $(SPINNER).waitUntilVisible();
            $(SPINNER).waitUntilNotVisible();

        } catch (Error e) {

            e.printStackTrace();
        }
    }

}

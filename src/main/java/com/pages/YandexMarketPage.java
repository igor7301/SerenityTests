package com.pages;

import com.ProductItem;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 12/27/2017.
 */
public class YandexMarketPage extends YandexMarketAbstractPage {

    private static final String HEADER_MAIN = ".header2__main";
    private static final String ALL_DEPARTMENTS_BTN = ".n-topmenu-new-vertical-wrapper .n-topmenu-new-vertical__left button";
    private static final String DEPARTMENTS_PANEL = ".n-navigation-vertical.i-bem.n-navigation-vertical_js_inited";
    private static final String MAIN_DEPARTMENTS_LIST = ".n-navigation-vertical span[class='link__title']";
    private static final String SUB_DEPARTMENTS_LIST =
            ".n-navigation-vertical-category.active .link.n-navigation-vertical-menu__item.i-bem.b-zone.b-spy-events";
    private static final String PRODUCT_ITEMS = ".n-snippet-card2";
    private static final String PRODUCT_ITEM_TITLE = ".n-snippet-card2__title";


    public YandexMarketPage() {
    }

    @WhenPageOpens
    public void waitUntilPageOpens() {
        $(HEADER_MAIN).waitUntilVisible();
    }

    public void openSubDepartment(String subDepartmentName) {

        for (WebElementFacade departmentElement : findAll(SUB_DEPARTMENTS_LIST)) {
            if (departmentElement.getText().equalsIgnoreCase(subDepartmentName)) {
                departmentElement.click();
                return;
            }
        }

        throw new RuntimeException("Can't find item with name " + subDepartmentName);
    }

    public void openMainDepartment(String departmentName) {


        List<WebElementFacade> collection = findAll(MAIN_DEPARTMENTS_LIST);
        for (WebElementFacade departmentElement : collection) {

            if (departmentElement.getText().equalsIgnoreCase(departmentName)) {

                Actions builder = new Actions(getDriver());
                Actions hoverOverLocationSelector = builder.moveToElement(departmentElement);
                hoverOverLocationSelector.perform();
                $(SUB_DEPARTMENTS_LIST).shouldBeVisible();
                return;
            }
        }

        throw new RuntimeException("Can't find item with name " + departmentName);


    }


    public void openNavPanel() {

        $(ALL_DEPARTMENTS_BTN).click();
        $(DEPARTMENTS_PANEL).waitUntilVisible();

    }


    public List<ProductItem> getResults() {

        List<ProductItem> productItems = new ArrayList<ProductItem>();
        for (WebElementFacade productItemElement : findAll(PRODUCT_ITEMS)) {

            ProductItem productItem1 = new ProductItem();
            productItem1.setProductName(productItemElement.findBy(PRODUCT_ITEM_TITLE).getText());
            productItems.add(productItem1);
        }
        return productItems;

    }
}

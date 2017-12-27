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
public class YandexMarketPage2 extends YandexMarketAbstractPage {

    private static final String HEADER_MAIN = ".header2__main";
    private static final String DEPARTMENTS_PANEL = ".n-navigation-vertical.i-bem.n-navigation-vertical_js_inited";
    private static final String MAIN_DEPARTMENTS_LIST = ".topmenu__list .topmenu__item.i-bem.topmenu__item_js_inited";
    private static final String SUB_DEPARTMENTS_LIST = ".topmenu__subwrap .topmenu__sublist";
    private static final String PRODUCT_ITEMS = ".n-snippet-card2";
    private static final String PRODUCT_ITEM_TITLE = ".n-snippet-card2__title";


    public YandexMarketPage2() {


    }

    @WhenPageOpens
    public  void waitUtilPageOpens() {
        $(HEADER_MAIN).shouldBeVisible();
    }

    public void openSubDepartment(String subDepartmentName) {

        for (WebElementFacade departmentElement : findAll(".link.topmenu__subitem")) {
            if(departmentElement.isCurrentlyVisible()) {
                if (departmentElement.getText().equalsIgnoreCase(subDepartmentName)) {
                    departmentElement.click();
                    return;
                }
            }
        }
        throw new RuntimeException("Can't find item with name " + subDepartmentName);
    }

    public void openMainDepartment(String departmentName) {


        List<WebElementFacade> collection = findAll(MAIN_DEPARTMENTS_LIST);
        for (WebElementFacade departmentElement : collection) {
            if(departmentElement.isCurrentlyVisible()) {
                if (departmentElement.getText().equalsIgnoreCase(departmentName)) {

                    Actions builder = new Actions(getDriver());
                    Actions hoverOverLocationSelector = builder.moveToElement(departmentElement);
                    hoverOverLocationSelector.perform();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                    departmentElement.findBy(SUB_DEPARTMENTS_LIST).waitUntilVisible();
                    return;
                }
            }
        }

        throw new RuntimeException("Can't find item with name " + departmentName);

    }


    public void openNavPanel() {

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

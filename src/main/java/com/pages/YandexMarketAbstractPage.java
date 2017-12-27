package com.pages;

import com.ProductItem;
import net.thucydides.core.pages.PageObject;

import java.util.List;

/**
 * Created by Igor on 12/27/2017.
 */
public abstract class YandexMarketAbstractPage extends PageObject {

    /**
     * Открывает под-категорию из списка
     * @param subDepartmentName имя под-категории
     */
    public abstract void openSubDepartment(String subDepartmentName);

    /**
     * Открывает категорию из списка
     * @param departmentName имя категории
     */
    public abstract void openMainDepartment(String departmentName);

    /**
     * Открывает список всех категорий
     * Доступно только для версии YandexMarketPage
     * Версия YandexMarketPage2 не требует открытия списка категорий, так как они уже открыты по умолчанию
     */
    public abstract void openNavPanel();

    /**
     * Возвращает список товаров на странице
     * @return список товаров
     */
    public abstract List<ProductItem> getResults();
}

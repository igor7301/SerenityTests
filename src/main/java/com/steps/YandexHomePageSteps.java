package com.steps;

import com.pages.YandexHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Igor on 12/27/2017.
 */

public class YandexHomePageSteps extends ScenarioSteps {

    YandexHomePage yandexHomePage;


    @Step("I open yandex market")
    public void openYandexMarket() {
        yandexHomePage.openMarket();
    }

    @Step("I open yandex home page")
    public void open() {
        yandexHomePage.open();
        getDriver().manage().window().maximize();
    }
}

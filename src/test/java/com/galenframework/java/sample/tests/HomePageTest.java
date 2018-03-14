package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.*;
import com.galenframework.java.sample.pageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void homePage_EmailSection_onDevice(TestDevice device) throws IOException {
        load(Config.HOME_PAGE);
        checkPageLayout(GalenSpecPath.INTL_HOME_PAGE_SPEC, device.getTags(), Locators.getPageLocators());
    }

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = true)
    public void  countryChanger_modal_onDevice(TestDevice device) throws  IOException {
        load(Config.HOME_PAGE);
        BoilerPlate.RegisterCookie(getDriver());
        load("/");

        HomePage homePage = new HomePage(getDriver());
        homePage.openCountryChangeModal();

        checkPageLayout(GalenSpecPath.COUNTRY_CHANGER_MODAL_SPEC, device.getTags(), Locators.getPageLocators());

    }

}

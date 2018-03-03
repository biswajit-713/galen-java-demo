package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.*;
import com.galenframework.java.sample.pageObjects.HomePage;
import com.galenframework.specs.page.Locator;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HomePageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = true)
    public void homePage_EmailSection_onDevice(TestDevice device) throws IOException {

        load(Config.HOME_PAGE);
//        checkLayout(GalenSpecPath.INTL_HOME_PAGE_SPEC, device.getTags());

        checkPageLayout(GalenSpecPath.INTL_HOME_PAGE_SPEC, device.getTags(), Locators.getPageLocators());
    }

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void  countryChanger_modal_onDevice(TestDevice device) throws  IOException {
        load(Config.HOME_PAGE);
        BoilerPlate.RegisterCookie(getDriver());
        load("/");

        //TODO - click on the change country link and check the layout
        HomePage homePage = new HomePage(getDriver());
        homePage.openCountryChangeModal();

        checkPageLayout(GalenSpecPath.COUNTRY_CHANGER_MODAL_SPEC, device.getTags(), Locators.getPageLocators());

    }

}

package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.BoilerPlate;
import com.galenframework.java.sample.components.GalenSpecPath;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.RetryAnalyzer;
import com.galenframework.java.sample.pageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = true)
    public void homePage_EmailSection_onDevice(TestDevice device) throws IOException {

        load(BoilerPlate.HOME_PAGE);
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout(GalenSpecPath.INTL_HOME_PAGE_SPEC, device.getTags());

    }

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void  countryChanger_modal_onDevice(TestDevice device) throws  IOException {
        load(BoilerPlate.HOME_PAGE);
        BoilerPlate.RegisterCookie(getDriver());
        load("/");

        //TODO - click on the change country link and check the layout
        HomePage homePage = new HomePage(getDriver());
        homePage.openCountryChangeModal();

        checkLayout(GalenSpecPath.COUNTRY_CHANGER_MODAL_SPEC, device.getTags());

    }

}

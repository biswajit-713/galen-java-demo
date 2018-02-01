package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.BoilerPlate;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.pageObjects.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends GalenTestBase {

    @Test(dataProvider = "devices")
    public void homePage_EmailSection_onDevice(TestDevice device) throws IOException {

        load("/");
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout("/specs/internationalHomePage.gspec", device.getTags());

    }

    @Test(dataProvider = "devices", enabled = false)
    public void  countryChanger_modal_onDevice(TestDevice device) throws  IOException {
        load("/");
        BoilerPlate.RegisterCookie(getDriver());
        load("/");

        //TODO - click on the change country link and check the layout
        HomePage homePage = new HomePage(getDriver());
        homePage.openCountryChangeModal();

        //checkLayout("/specs/changeCountryModal.gspec", device.getTags());

    }

}

package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;


public class WelcomePageTest extends GalenTestBase {

/*
    @Test(dataProvider = "devices")
    public void welcomePage_shouldLookGood_onDevice(TestDevice device) throws IOException {
        load("/");
        checkLayout("/specs/welcomePage.spec", device.getTags());
    }

    @Test(dataProvider = "devices")
    public void loginPage_shouldLookGood_onDevice(TestDevice device) throws IOException {
        load("/");
        getDriver().findElement(By.xpath("//button[.='Login']")).click();
        checkLayout("/specs/loginPage.spec", device.getTags());
    }
*/

    @Test(dataProvider = "devices")
    public void homePage_EmailSection_onDevice(TestDevice device) throws IOException {
        load("/");
        Cookie intlCookie = new Cookie.Builder("COUNTRY_SELECTOR", "true")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 28))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/")
                .build();
        Cookie homePageCookie = new Cookie.Builder("ihp", "DTT5")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 28))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/")
                .build();

        getDriver().manage().addCookie(intlCookie);
        getDriver().manage().addCookie(homePageCookie);
        load("/");

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


        //getDriver().navigate().refresh();
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout("/specs/internationalHomePage.gspec", device.getTags());
    }

}

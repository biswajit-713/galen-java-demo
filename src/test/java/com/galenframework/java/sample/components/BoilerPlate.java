package com.galenframework.java.sample.components;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class BoilerPlate {

    public static void RegisterCookie(WebDriver driver) {
        Cookie homePageCookie = new Cookie.Builder("ihp", "DTT8")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .path("/")
                .build();

        Cookie plpCookie = new Cookie.Builder("iplp", "DTT1")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie countrySelectorCookie = new Cookie.Builder("COUNTRY_SELECTOR", "true")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie plpPageCookie = new Cookie.Builder("PLP_PAGE", "true")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie favorite = new Cookie.Builder("FAVORITE", "true")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie favorite1 = new Cookie.Builder("FAVORITE", "true")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie quickLook = new Cookie.Builder("QUICK_LOOK", "true")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
                .build();

        Cookie quickLook1 = new Cookie.Builder("QUICK_LOOK", "true")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(true)
                .isSecure(false)
                .build();

        driver.manage().addCookie(homePageCookie);
        driver.manage().addCookie(countrySelectorCookie);
        driver.manage().addCookie(plpCookie);
        driver.manage().addCookie(plpPageCookie);
        driver.manage().addCookie(favorite);
        driver.manage().addCookie(favorite1);
        driver.manage().addCookie(quickLook);
        driver.manage().addCookie(quickLook1);
    }

    public static String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
}

package com.galenframework.java.sample.components;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.*;

/**
 * Created by biswajip on 9/16/17.
 */
public class BoilerPlate {

    public static final String HOME_PAGE = "/";
    public static final String PLP_PAGE = "/Test-Silo/Katies-Test-Cats/Biswajits-Category/FAW-5219-Endeca-Category/T1CAT42950731_T1CAT42640749_T1CAT42270731_T1CAT39040731/c.cat?navpath=cat000000_T1CAT39040731_T1CAT42270731_T1CAT42640749_T1CAT42950731&source=leftNav";
    public static final String PDP_PAGE = "prod189330314/p.prod"; //"/prod204860125/p.prod";

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

        Cookie quickLook = new Cookie.Builder("QUICK_LOOK", "true")
                .domain(".nmgcloudapps.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(false)
                .isSecure(true)
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
        driver.manage().addCookie(quickLook);
    }
}

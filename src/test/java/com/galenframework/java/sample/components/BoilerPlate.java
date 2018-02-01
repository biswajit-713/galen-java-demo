package com.galenframework.java.sample.components;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.*;

/**
 * Created by biswajip on 9/16/17.
 */
public class BoilerPlate {

    public static void RegisterCookie(WebDriver driver) {
        Cookie homePageCookie = new Cookie.Builder("ihp", "DTT5")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/")
                .build();

        Cookie countrySelectorCookie = new Cookie.Builder("COUNTRY_SELECTOR", "true")
                .domain(".neimanmarcus.com")
                .expiresOn(new Date(2019, 10, 10))
                .isHttpOnly(true)
                .isSecure(false)
                .build();

        driver.manage().addCookie(homePageCookie);
        driver.manage().addCookie(countrySelectorCookie);
    }
}

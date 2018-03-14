package com.galenframework.java.sample.pageObjects;

import com.galenframework.java.sample.components.Locators;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public void openCountryChangeModal(){
        this.driver.findElement(By.cssSelector(Locators.getLocatorProperty("country_selector"))).click();
        assert this.driver.findElement(By.cssSelector(Locators.getLocatorProperty("country_selector_modal")))
                .isDisplayed();
    }
}

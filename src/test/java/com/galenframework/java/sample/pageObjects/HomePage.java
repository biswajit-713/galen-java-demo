package com.galenframework.java.sample.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by biswajip on 9/17/17.
 */
public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void openCountryChangeModal() {
        this.driver.findElement(By.cssSelector("button.country-selector-link")).click();
        assert this.driver.findElement(By.cssSelector("div.country-selector-modal")).isDisplayed();
    }

}

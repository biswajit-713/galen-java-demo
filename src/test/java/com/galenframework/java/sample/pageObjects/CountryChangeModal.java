package com.galenframework.java.sample.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by biswajip on 9/17/17.
 */
public class CountryChangeModal {

    WebDriver driver;

    public CountryChangeModal (WebDriver driver) {
        this.driver = driver;
    }

    public void changeCountry(String country, String currency) {
        WebElement elmCountry = this.driver.findElement(By.cssSelector("select.country-select"));
        Select countryList = new Select(elmCountry);
        countryList.selectByVisibleText(country);

        WebElement elmCurrency = this.driver.findElement(By.cssSelector("select.currency-select"));
        Select currencyList = new Select(elmCurrency);
        currencyList.selectByVisibleText(currency);

        this.driver.findElement(By.cssSelector("country-selector-modal__confirm-button")).click();


    }
}

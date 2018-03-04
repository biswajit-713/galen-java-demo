package com.galenframework.java.sample.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by biswajip on 3/4/18.
 */
public class QuickLook {
    WebDriver driver;

    public QuickLook(WebDriver driver) {
        this.driver = driver;
    }

    public boolean selectProductSizeAndColor(){
        this.driver.findElement(By.xpath("//div[@id='product-options__size']//button[not(contains(@class, 'product-options__button--disabled'))]")).click();
        this.driver.findElement(By.xpath("//div[@id='product-options__color']//button[not(contains(@class, 'product-options__button--disabled'))]")).click();

        WebElement inStockStatus = new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sku-status-messages")));

        return inStockStatus.isDisplayed();
    }
}

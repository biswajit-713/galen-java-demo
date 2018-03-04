package com.galenframework.java.sample.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductListPage {
    WebDriver driver;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() throws TimeoutException{
        WebElement quickLookButton = new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.quick-look")));

        return  quickLookButton.isDisplayed();
    }

    public boolean launchQuickLookModal(){
        WebElement quickLookButton = new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.quick-look")));

        JavascriptExecutor js = (JavascriptExecutor)this.driver;
        js.executeScript("arguments[0].scrollIntoView()", quickLookButton);

        quickLookButton.click();
        WebElement quickLookModal = new WebDriverWait(this.driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.nm-modal__content")));

        return quickLookModal.isDisplayed();

    }
}

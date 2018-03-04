package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;


public class ProductDescriptionPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void Product_Image_onDevice(TestDevice device) throws IOException{
        load(Config.PDP_PAGE);
        WebElement mediaContainer = new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-media__container")));
        checkLayout(GalenSpecPath.PDP_SPEC, device.getTags());
//
    }
}

package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.BoilerPlate;
import com.galenframework.java.sample.components.GalenSpecPath;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.RetryAnalyzer;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by biswajip on 2/21/18.
 */
public class ProductListPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    @SneakyThrows
    public void Quick_Look_onDevice(TestDevice device) throws IOException {
        load(BoilerPlate.PLP_PAGE);
        BoilerPlate.RegisterCookie(getDriver());
        load(BoilerPlate.PLP_PAGE);

        WebElement quickLookButton = new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.quick-look")));
        quickLookButton.click();

        WebElement quickLookModal = new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.nm-modal__content")));

        getDriver().findElement(By.xpath("//div[@id='product-options__size']//button[not(contains(@class, 'product-options__button--disabled'))]")).click();
        getDriver().findElement(By.xpath("//div[@id='product-options__color']//button[not(contains(@class, 'product-options__button--disabled'))]")).click();

        WebElement inStockStatus = new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sku-status-messages")));
        checkLayout(GalenSpecPath.QUICK_LOOK_SPEC, device.getTags());

    }
}

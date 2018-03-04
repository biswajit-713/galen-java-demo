package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.*;
import com.galenframework.java.sample.pageObjects.ProductListPage;
import com.galenframework.java.sample.pageObjects.QuickLook;
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

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = true)
    public void Quick_Look_onDevice(TestDevice device) throws IOException {
        load(Config.PLP_PAGE);
        BoilerPlate.RegisterCookie(getDriver());
        load(Config.PLP_PAGE);

        ProductListPage plp = new ProductListPage(getDriver());
        assert plp.isPageLoaded() == true;

        plp.launchQuickLookModal();

        QuickLook quickLook = new QuickLook(getDriver());
        quickLook.selectProductSizeAndColor();

        checkPageLayout(GalenSpecPath.QUICK_LOOK_SPEC, device.getTags(), Locators.getPageLocators());

    }
}

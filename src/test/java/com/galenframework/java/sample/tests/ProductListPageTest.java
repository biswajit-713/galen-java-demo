package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.pageObjects.ProductListPage;
import com.galenframework.java.sample.pageObjects.QuickLook;

import com.galenframework.java.sample.components.*;
import org.testng.annotations.Test;
import java.io.IOException;

public class ProductListPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
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

package com.galenframework.java.sample.tests;

import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.RetryAnalyzer;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by biswajip on 2/3/18.
 */
public class ProductDescriptionPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class)
    public void Product_Image_onDevice(TestDevice device) throws IOException{
        load("/Bogner-Down-Puffer-Vest-Neon-Red/prod192090050/p.prod");
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout("/specs/ProductDescriptionPage.gspec", device.getTags());
    }
}

package com.galenframework.java.sample.tests;

import com.galenframework.api.Galen;
import com.galenframework.java.sample.components.BoilerPlate;
import com.galenframework.java.sample.components.GalenSpecPath;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.RetryAnalyzer;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;


public class ProductDescriptionPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class, enabled = false)
    public void Product_Image_onDevice(TestDevice device) throws IOException{
        load(BoilerPlate.PDP_PAGE);
        WebElement mediaContainer = new WebDriverWait(getDriver(), 30)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.main-media__container")));
//        JavascriptExecutor js = (JavascriptExecutor)getDriver();
//        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout(GalenSpecPath.PDP_SPEC, device.getTags());
//
//        LayoutReport layoutReport = Galen.checkLayout(getDriver(),
//                "/specs/ProductDescriptionPage.gspec",
//                device.getTags());
//        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
//        GalenTestInfo test = GalenTestInfo.fromString("mobile");
//        test.getReport().layout(layoutReport, "check");
//        tests.add(test);
//        new HtmlReportBuilder().build(tests, "target/galen-mobile-reports");
    }
}

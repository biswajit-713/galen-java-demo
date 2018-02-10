package com.galenframework.java.sample.tests;

import com.galenframework.api.Galen;
import com.galenframework.java.sample.components.GalenTestBase;
import com.galenframework.java.sample.components.RetryAnalyzer;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ProductDescriptionPageTest extends GalenTestBase {

    @Test(dataProvider = "devices", retryAnalyzer = RetryAnalyzer.class)
    public void Product_Image_onDevice(TestDevice device) throws IOException{
        load("/Burberry-Patchwork-Herringbone-Front-Zip-Sweater-Dark-Gray-Melange/prod189330314/p.prod");
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("window.scrollTo(0, window.outerHeight)");
        checkLayout("/specs/ProductDescriptionPage.gspec", device.getTags());
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

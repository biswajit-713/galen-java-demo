package com.galenframework.java.sample.components;

import com.galenframework.testng.GalenTestNgTestBase;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    private static final String USER_NAME = "biswajitpattanay1";
    private static final String API_KEY = "s1xiWnqpZZ2xyoCntHoj";
    //private static final String ENV_URL = "https://" + USER_NAME + ":" + API_KEY + "@hub-cloud.browserstack.com/wd/hub";
    private static final String ENV_URL = "http://testapp.galenframework.com/";
    //private static final String APP_URL = "http://testapp.galenframework.com/";
    private static final String APP_URL = "http://devint.neimanmarcus.com";

    @Override
    public WebDriver createDriver(Object[] args) {
        //WebDriver driver = new ChromeDriver();
        DesiredCapabilities caps = DesiredCapabilities.firefox();

        try {
            //WebDriver driver = new RemoteWebDriver(new URL(ENV_URL), caps);
            WebDriver driver = new ChromeDriver();
            if (args.length > 0) {
                if (args[0] != null && args[0] instanceof TestDevice) {
                    TestDevice device = (TestDevice)args[0];
                    if (device.getScreenSize() != null) {
                        driver.manage().window().setSize(device.getScreenSize());
                    }
                }
            }
            return driver;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }

    }

    public void load(String uri) {
        getDriver().get(APP_URL + uri);
    }

    @DataProvider(name = "devices")
    public Object [][] devices () {
        return new Object[][] {
/*
                {new TestDevice("mobile", new Dimension(450, 800), asList("mobile"))},
                {new TestDevice("tablet", new Dimension(750, 800), asList("tablet"))},
*/
                {new TestDevice("desktop", new Dimension(1366, 800), asList("desktop"))}
        };
    }

    public static class TestDevice {
        private final String name;
        private final Dimension screenSize;
        private final List<String> tags;

        public TestDevice(String name, Dimension screenSize, List<String> tags) {
            this.name = name;
            this.screenSize = screenSize;
            this.tags = tags;
        }

        public String getName() {
            return name;
        }

        public Dimension getScreenSize() {
            return screenSize;
        }

        public List<String> getTags() {
            return tags;
        }

        @Override
        public String toString() {
            return String.format("%s %dx%d", name, screenSize.width, screenSize.height);
        }
    }
}

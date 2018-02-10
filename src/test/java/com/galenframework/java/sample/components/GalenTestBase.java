package com.galenframework.java.sample.components;

import com.galenframework.testng.GalenTestNgTestBase;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static java.util.Arrays.asList;

public abstract class GalenTestBase extends GalenTestNgTestBase {

    private static final String USER_NAME = "biswajitpattanay1";
    private static final String API_KEY = "s1xiWnqpZZ2xyoCntHoj";
    private static final String ENV_URL = "https://" + USER_NAME + ":" + API_KEY + "@hub.browserstack.com/wd/hub";
    private static final String APP_URL = System.getProperty("applicationUrl");
    private String selectedBrowser;


    @Override
    @SneakyThrows
    public WebDriver createDriver(Object[] args) {

        //TODO - include implementation for firefox, chrome, Safari, BrowserStack
        WebDriver driver = null;
        String testBrowser = System.getProperty("device").toLowerCase();
        String platform = System.getProperty("platform").toLowerCase();

        if (platform.equalsIgnoreCase("local")){
            driver = returnDriverForLocalEnvironment(driver, testBrowser);

            // Resize the window
            if (args.length > 0) {
                if (args[0] != null && args[0] instanceof TestDevice) {
                    TestDevice device = (TestDevice)args[0];
                    if (device.getScreenSize() != null) {
                        driver.manage().window().setSize(device.getScreenSize());
                    }
                }
            }

        } else if (platform.equalsIgnoreCase("browserstack")) {

        } else if (platform.equalsIgnoreCase("saucelabs")) {

        } else if (platform.equalsIgnoreCase("mobileDevice")) {

        } else if (platform.equalsIgnoreCase("mobileSimulator")) {

        }

        return driver;

    }

    public void load(String uri) {

        getDriver().get(APP_URL + uri);
    }

    @DataProvider(name = "devices")
    public Object [][] devices () {

        selectedBrowser = System.getProperty("device");
        return new Object[][] {
                {new TestDevice(selectedBrowser,
                        new Dimension(Integer.parseInt(System.getProperty("device.width")),
                                Integer.parseInt(System.getProperty("device.height"))),
                        asList(System.getProperty("device.type")))}
        };
    }

    // set up the local environment
    private WebDriver returnDriverForLocalEnvironment(WebDriver driver, String device){

        DesiredCapabilities caps;

        if (device.contains("chrome")) {
            if (device.contains("chrome")){
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                driver = new ChromeDriver(service);
            } else if (device.contains("firefox")) {
                caps = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(caps);
            } else if (device.contains("safari")) {
                caps = DesiredCapabilities.safari();
                driver = new SafariDriver(caps);
            }

        }

        return driver;
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

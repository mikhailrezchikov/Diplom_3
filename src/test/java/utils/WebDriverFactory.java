package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class WebDriverFactory {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String WEBDRIVER_CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String YANDEX_DRIVER_PATH = "yandex.driver.path";

    public static WebDriver createWebDriver() {

        Browser browser = getActiveBrowser();

        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case YANDEX:
                String driverPath = Objects.requireNonNull(ClassLoader.getSystemResource("yandexdriver.exe")).getPath();
                String yandexDriverPath = System.getProperty(YANDEX_DRIVER_PATH, driverPath);
                System.setProperty(WEBDRIVER_CHROME_DRIVER_PROPERTY, yandexDriverPath);
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
    private static Browser getActiveBrowser() {
        String browserName = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER);
        return Browser.valueOf(browserName.toUpperCase());
    }
}
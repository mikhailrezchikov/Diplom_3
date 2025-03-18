package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private static final String LOGIN_BUTTON = "//a[@class = 'Auth_link__1fOlj' and text() ='Войти']";

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public ForgotPasswordPage openLoginPage() {
        driver.get(PAGE_URL);

        return this;
    }

    @Step("Клик на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }
}

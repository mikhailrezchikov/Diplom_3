package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.HeaderComponent;

public class RegistrationPage {
    private final WebDriver driver;
    public HeaderComponent headerComponent;
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final String NAME_INPUT = "//label[@class='input__placeholder text noselect text_type_main-default' and text() = 'Имя']/following-sibling::*";
    private static final String EMAIL_INPUT = "//label[@class='input__placeholder text noselect text_type_main-default' and text() = 'Email']/following-sibling::*";
    private static final String PASSWORD_INPUT = "//label[@class='input__placeholder text noselect text_type_main-default' and text() = 'Пароль']/following-sibling::*";
    private static final String REGISTER_BUTTON = "//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text() = 'Зарегистрироваться']";
    private static final String ERROR_MESSAGE = "//p[@class='input__error text_type_main-default']";
    private static final String LOGIN_BUTTON ="//a[@class = 'Auth_link__1fOlj']";

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
    }

    public RegistrationPage openRegistrationPage() {
        driver.get(PAGE_URL);

        return this;
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    @Step("Ввод имени")
    public RegistrationPage setName(String name) {
        driver.findElement(By.xpath(NAME_INPUT)).sendKeys(name);

        return this;
    }

    @Step("Ввод email")
    public RegistrationPage setEmail(String email) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(email);

        return this;
    }

    @Step("Ввод пароля")
    public RegistrationPage setPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);

        return this;
    }

    @Step("Клик на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();
    }
    @Step("Клик на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Step("Регистрация")
    public void registration(String name, String email, String password) {
        openRegistrationPage()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickRegisterButton();
    }

    public void waitRedirectToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlToBe(loginPage.getPageUrl()));
    }

    public String  getErrorMessage() {
        return driver.findElement(By.xpath(ERROR_MESSAGE)).getText();
    }
}

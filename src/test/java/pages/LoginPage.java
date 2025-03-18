package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.HeaderComponent;

public class LoginPage {
    private final WebDriver driver;
    public HeaderComponent headerComponent;
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private static final String EMAIL_INPUT = "//label[@class = 'input__placeholder text noselect text_type_main-default' and text()='Email']/following-sibling::input";
    private static final String PASSWORD_INPUT = "//label[@class = 'input__placeholder text noselect text_type_main-default' and text()='Пароль']/following-sibling::input";
    private static final String LOGIN_BUTTON = "//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']";
    private static final String REGISTER_BUTTON = "//a[@class = 'Auth_link__1fOlj' and text() ='Зарегистрироваться']";
    private static final String RECOVER_PASSWORD_BUTTON = "//a[@class = 'Auth_link__1fOlj' and text() ='Восстановить пароль']";
    private static final String LOGIN_SECTION = "//div[@class='Auth_login__3hAey']";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public LoginPage openLoginPage() {
        driver.get(PAGE_URL);

        return this;
    }

    @Step("Ввод имени")
    public LoginPage setEmail(String name) {
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(name);

        return this;
    }

    @Step("Ввод пароля")
    public LoginPage setPassword(String password) {
        driver.findElement(By.xpath(PASSWORD_INPUT)).sendKeys(password);

        return this;
    }

    @Step("Клик на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    @Step("Логин")
    public void login(String email, String password) {
        openLoginPage()
                .setEmail(email)
                .setPassword(password)
                .clickLoginButton();
    }

    public void waitRedirectToAccountProfilePage() {
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlToBe(accountProfilePage.getPageUrl()));
    }

    @Step("Проверяем, что конструктор бургера отображается на странице")
    public boolean checkWhatLoginSectionIsDispayed() {
        return driver.findElement(By.xpath(LOGIN_SECTION)).isDisplayed();
    }

}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.HeaderComponent;

public class AccountProfilePage {

    private final WebDriver driver;
    public HeaderComponent headerComponent;
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private static final String LOGOUT_BUTTON = "//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']";

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    public AccountProfilePage openAccountProfilePage() {
        driver.get(PAGE_URL);

        return this;
    }

    @Step("Клик на кнопку Выйти")
    public void clickLogoutButton() {
        driver.findElement(By.xpath(LOGOUT_BUTTON)).click();
    }

    @Step("Проверяем, что логин {value} отображается на странице")
    public boolean checkWhatLoginIsDispayed(String value) {
        String elementPath = String.format("//input[@class='text input__textfield text_type_main-default input__textfield-disabled' and @value='%s']", value);
        return driver.findElement(By.xpath(elementPath)).isDisplayed();
    }

    public void waitRedirectToLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.urlToBe(loginPage.getPageUrl()));
    }
}

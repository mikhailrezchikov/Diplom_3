package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.components.BurgerConstructorComponent;
import pages.components.HeaderComponent;

public class MainPage {
    private final WebDriver driver;
    public HeaderComponent headerComponent;
    public BurgerConstructorComponent burgerConstructorComponent;
    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_TO_ACCOUNT_BUTTON = "//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text() ='Войти в аккаунт']";
    private static final String CREATE_BURGER_SECTION = "//section[@class='BurgerIngredients_ingredients__1N8v2']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
        headerComponent = new HeaderComponent(driver);
        burgerConstructorComponent = new BurgerConstructorComponent(driver);
    }

    public MainPage openMainPage() {
        driver.get(PAGE_URL);

        return this;
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

    @Step("Клик на кнопку Войти в аккаунт")
    public void clickLoginButton() {
        driver.findElement(By.xpath(LOGIN_TO_ACCOUNT_BUTTON)).click();
    }

    @Step("Проверяем, что конструктор бургера отображается на странице")
    public boolean checkWhatCreateBurgerConstructorIsDispayed() {
        return driver.findElement(By.xpath(CREATE_BURGER_SECTION)).isDisplayed();
    }
}


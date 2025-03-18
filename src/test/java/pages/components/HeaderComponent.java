package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent {

    private final WebDriver driver;
    private static final String PERSONAL_ACCOUNT_BUTTON = "//p[@class = 'AppHeader_header__linkText__3q_va ml-2' and text() = 'Личный Кабинет']";
    private static final String CONSTRUCTOR_BUTTON = "//p[@class='AppHeader_header__linkText__3q_va ml-2' and text()='Конструктор']";
    private static final String LOGO = "//div[@class='AppHeader_header__logo__2D0X2']";
    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку Личный Кабинет")
    public void clickPersonalAccountButton() {
        driver.findElement(By.xpath(PERSONAL_ACCOUNT_BUTTON)).click();
    }

    @Step("Клик на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(By.xpath(CONSTRUCTOR_BUTTON)).click();
    }

    @Step("Клик на Лого")
    public void clickLogo() {
        driver.findElement(By.xpath(LOGO)).click();
    }
}

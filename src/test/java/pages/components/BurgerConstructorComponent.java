package pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BurgerConstructorComponent {

    private final WebDriver driver;

    private static final String BUN_BUTTON = "//span[@class='text text_type_main-default' and text()='Булки']/..";
    private static final String SAUCES_BUTTON = "//span[@class='text text_type_main-default' and text()='Соусы']/..";
    private static final String FILLINGS_BUTTON = "//span[@class='text text_type_main-default' and text()='Начинки']/..";

    public BurgerConstructorComponent(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на кнопку раздела Булки")
    public BurgerConstructorComponent clickBunButton() {
        driver.findElement(By.xpath(BUN_BUTTON)).click();

        return this;
    }

    @Step("Клик на кнопку раздела Соусы")
    public BurgerConstructorComponent clickSaucesButton() {
        driver.findElement(By.xpath(SAUCES_BUTTON)).click();

        return this;
    }

    @Step("Клик на кнопку раздела Начинки")
    public BurgerConstructorComponent clickFillingsButton() {
        driver.findElement(By.xpath(FILLINGS_BUTTON)).click();

        return this;
    }

    @Step("Проверка, что выбрана секция Булки")
    public boolean isBunSectionSelected() {
        WebElement saucesButton = driver.findElement(By.xpath(BUN_BUTTON));
        String classAttribute = saucesButton.getAttribute("class");
        return classAttribute.contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверка, что выбрана секция Соусы")
    public boolean isSaucesSectionSelected() {
        WebElement saucesButton = driver.findElement(By.xpath(SAUCES_BUTTON));
        String classAttribute = saucesButton.getAttribute("class");
        return classAttribute.contains("tab_tab_type_current__2BEPc");
    }

    @Step("Проверка, что выбрана секция Начинки")
    public boolean isFillingsSectionSelected() {
        WebElement saucesButton = driver.findElement(By.xpath(FILLINGS_BUTTON));
        String classAttribute = saucesButton.getAttribute("class");
        return classAttribute.contains("tab_tab_type_current__2BEPc");
    }


}

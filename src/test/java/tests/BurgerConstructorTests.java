package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.components.BurgerConstructorComponent;
import utils.WebDriverFactory;

public class BurgerConstructorTests {

    public WebDriver driver;

    @Before
    public void startUp() {
        driver = WebDriverFactory.createWebDriver();
    }

    @Test
    public void shouldSelectBunsSection() {
        MainPage mainPage = new MainPage(driver);
        BurgerConstructorComponent burgerConstructorComponent = new BurgerConstructorComponent(driver);

        mainPage
                .openMainPage()
                .burgerConstructorComponent
                .clickSaucesButton()
                .clickBunButton();

        Assert.assertTrue("Ожидается, что выбрана секция Булки", burgerConstructorComponent.isBunSectionSelected());

    }

    @Test
    public void shouldSelectSaucesSection() {
        MainPage mainPage = new MainPage(driver);
        BurgerConstructorComponent burgerConstructorComponent = new BurgerConstructorComponent(driver);

        mainPage
                .openMainPage()
                .burgerConstructorComponent
                .clickSaucesButton();

        Assert.assertTrue("Ожидается, что выбрана секция Соусы", burgerConstructorComponent.isSaucesSectionSelected());

    }

    @Test
    public void shouldSelectFillingsSection() {

        MainPage mainPage = new MainPage(driver);
        BurgerConstructorComponent burgerConstructorComponent = new BurgerConstructorComponent(driver);

        mainPage
                .openMainPage()
                .burgerConstructorComponent
                .clickFillingsButton();

        Assert.assertTrue("Ожидается, что выбрана секция Начинки", burgerConstructorComponent.isFillingsSectionSelected());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

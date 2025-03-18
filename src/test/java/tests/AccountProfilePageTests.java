package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AccountProfilePage;
import pages.LoginPage;
import pages.MainPage;

public class AccountProfilePageTests extends TestBase {

    @Test
    public void shouldNavigateToPersonalAccount() {

        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickLoginButton();
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.waitRedirectToAccountProfilePage();

        Assert.assertEquals("Ожидается переход на страницу личного кабинета",
                driver.getCurrentUrl(), accountProfilePage.getPageUrl());
        Assert.assertTrue("Ожидается, что email пользователя отображается в личном кабинете",
                accountProfilePage.checkWhatLoginIsDispayed(testData.email));
    }

    @Test
    public void shouldNavigateFromAccountToConstructorByConstructorButton() {

        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickLoginButton();
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage
                .waitRedirectToAccountProfilePage();
        accountProfilePage
                .checkWhatLoginIsDispayed(testData.email);
        accountProfilePage
                .headerComponent
                .clickConstructorButton();

        Assert.assertTrue("Ожидается, что на странице отображается секция создания бургера",
                mainPage.checkWhatCreateBurgerConstructorIsDispayed());
    }

    @Test
    public void shouldNavigateFromAccountToConstructorByLogoButton() {

        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage()
                .setEmail(testData.email)
                .setPassword(testData.password)
                .clickLoginButton();
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage
                .waitRedirectToAccountProfilePage();
        accountProfilePage
                .checkWhatLoginIsDispayed(testData.email);
        accountProfilePage
                .headerComponent
                .clickLogo();

        Assert.assertTrue("Ожидается, что на странице отображается секция создания бургера",
                mainPage.checkWhatCreateBurgerConstructorIsDispayed());
    }
}

package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;

public class LoginPageTests extends TestBase{
    @Test
    public void shouldLoginWhenClickLoginButtonOnMainPage() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);

        mainPage
                .openMainPage()
                .clickLoginButton();
        loginPage.login(testData.email, testData.password);
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.waitRedirectToAccountProfilePage();

        Assert.assertEquals("Ожидается переход на страницу личного кабинета",
                driver.getCurrentUrl(), accountProfilePage.getPageUrl());
        Assert.assertTrue("Ожидается, что пользователь успешно авторизовался",
                accountProfilePage.checkWhatLoginIsDispayed(testData.email));
    }

    @Test
    public void shouldLoginWhenClickPersonalAccountButton() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);

        mainPage
                .openMainPage()
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.login(testData.email, testData.password);
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.waitRedirectToAccountProfilePage();

        Assert.assertEquals("Ожидается переход на страницу личного кабинета",
                driver.getCurrentUrl(), accountProfilePage.getPageUrl());
        Assert.assertTrue("Ожидается, что пользователь успешно авторизовался",
                accountProfilePage.checkWhatLoginIsDispayed(testData.email));
    }

    @Test
    public void shouldLoginWhenClickLoginButtonInRegistrationForm() {

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage
                .openRegistrationPage()
                .clickLoginButton();
        loginPage.login(testData.email, testData.password);
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.waitRedirectToAccountProfilePage();

        Assert.assertEquals("Ожидается переход на страницу личного кабинета",
                driver.getCurrentUrl(), accountProfilePage.getPageUrl());
        Assert.assertTrue("Ожидается, что пользователь успешно авторизовался",
                accountProfilePage.checkWhatLoginIsDispayed(testData.email));
    }

    @Test
    public void shouldLoginWhenClickLoginButtonInPasswordRecoveryForm() {

        MainPage mainPage = new MainPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountProfilePage accountProfilePage = new AccountProfilePage(driver);

        forgotPasswordPage
                .openLoginPage()
                .clickLoginButton();
        loginPage.login(testData.email, testData.password);
        mainPage
                .headerComponent
                .clickPersonalAccountButton();
        loginPage.waitRedirectToAccountProfilePage();

        Assert.assertEquals("Ожидается переход на страницу личного кабинета",
                driver.getCurrentUrl(), accountProfilePage.getPageUrl());
        Assert.assertTrue("Ожидается, что пользователь успешно авторизовался",
                accountProfilePage.checkWhatLoginIsDispayed(testData.email));
    }
}

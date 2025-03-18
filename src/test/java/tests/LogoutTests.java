package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AccountProfilePage;
import pages.LoginPage;
import pages.MainPage;

public class LogoutTests extends TestBase{

    @Test
    public void shouldLogoutByLogoutButtonInPersonalAccount() {

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
        accountProfilePage.clickLogoutButton();
        accountProfilePage.waitRedirectToLoginPage();

        Assert.assertEquals("Ожидается переход на страницу логина",
                driver.getCurrentUrl(), loginPage.getPageUrl());
        Assert.assertTrue("Ожидается, что на странице отображается форма логина для входа",
                loginPage.checkWhatLoginSectionIsDispayed());
    }

}

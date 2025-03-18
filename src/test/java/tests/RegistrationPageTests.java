package tests;

import api.client.UserApiClient;
import api.models.Credentials;
import api.models.UserResponse;
import data.TestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.WebDriverFactory;

public class RegistrationPageTests {

    public WebDriver driver;
    TestData testData = new TestData();
    protected static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    UserApiClient userApiClient = new UserApiClient(BASE_URI);

    @Before
    public void startUp() {
        driver = WebDriverFactory.createWebDriver();
    }

    @Test
    public void registrationSuccessfulTest() {

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registrationPage
                .registration(testData.name, testData.email, testData.password);
        registrationPage.waitRedirectToLoginPage();

        Assert.assertEquals("Ожидается переход на страницу логина",
                driver.getCurrentUrl(), loginPage.getPageUrl());
    }

    @Test
    public void shouldNotRegisterWhenPasswordLessThanSixChars() {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage
                .registration(testData.name, testData.email, "12345");

        Assert.assertEquals("Ожидается сообщение о некорректном пароле",
                "Некорректный пароль", registrationPage.getErrorMessage());
    }

    @After
    public void teardown() {
        driver.quit();

        try {
            UserResponse userResponse = userApiClient.loginUser(new Credentials(testData.email,testData.password))
                    .extract()
                    .as(UserResponse.class);

            if (userResponse.getAccessToken() != null) {
                userApiClient.deleteUser(userResponse.getAccessToken());
            }
        } catch (Exception ignore) {

        }
    }
}

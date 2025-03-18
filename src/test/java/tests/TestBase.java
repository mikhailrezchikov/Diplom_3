package tests;

import api.client.UserApiClient;
import api.models.Credentials;
import api.models.User;
import api.models.UserResponse;
import data.TestData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

public class TestBase {

    public WebDriver driver;
    TestData testData = new TestData();
    protected static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    UserApiClient userApiClient = new UserApiClient(BASE_URI);

    @Before
    public void startUp() {
        driver = WebDriverFactory.createWebDriver();

        userApiClient.createUser(new User(testData.email, testData.password, testData.name))
                .extract()
                .as(UserResponse.class);
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

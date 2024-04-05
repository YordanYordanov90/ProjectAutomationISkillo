package WebTestingISkillo;

import factory.Header;
import factory.HomePage;
import factory.LogInPage;
import factory.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogOutTest extends TestObject {

    @DataProvider(name="getUser")
    public Object[][] getUsers() {
        return new Object[][]{

                {"user1900", "123456", "5612"},

        };
    }
    @Test(dataProvider = "getUser")
    public void logoutTest(String username, String password, String userId) {
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        HomePage homePage = new HomePage(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        logInPage.navigateTo();
        logInPage.completeSignIn(username, password);
        
        header.clickOnLogOutButton();

        boolean isUrlLoaded = logInPage.isUrlLoaded();
        Assert.assertTrue(isUrlLoaded, "Home page URL is not loaded correctly.");


    }
}

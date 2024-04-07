package WebTestingISkillo;

import io.github.bonigarcia.wdm.WebDriverManager;
import factory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogInTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers() {
        return new Object[][]{

                {"user1900", "123456", "5612"},

        };
    }
    @Test(dataProvider = "getUser")
    public void loginTest(String username, String password, String userId){
        WebDriver webDriver = super.getWebDriver();
        HomePage homePage = new HomePage(webDriver);
        Header header = new Header(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);

        homePage.navigateTo();
        boolean isUrlLoaded = homePage.isUrlLoaded();
        Assert.assertTrue(isUrlLoaded, "Home page URL is not loaded correctly.");

       header.clickLogInButton();
       Assert.assertTrue(isUrlLoaded,"LogIn page is not loaded correctly.");

       logInPage.fillUserName(username);
       logInPage.fillPassword(password);
       logInPage.checkRememberMeBox();
       logInPage.clickSignIn();
    }
}

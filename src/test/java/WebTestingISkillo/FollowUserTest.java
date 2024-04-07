package WebTestingISkillo;

import factory.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class FollowUserTest extends TestObject {
    @DataProvider(name = "getUser")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\Funny-panda-cartoon-vector.jpg");
        String caption = "Testing upload file";
        return new Object[][]{

                {"user1900", "123456"},
        };
    }
    @Test(dataProvider = "getUser")
    public void followUserTest(String username, String password) {
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);

        logInPage.navigateTo();
        logInPage.completeSignIn(username, password);

        header.fillSearchBar("p0li0m");
        header.clickFollowButton();
    }
}
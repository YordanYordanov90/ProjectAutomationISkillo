package WebTestingISkillo;

import factory.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

public class DeletePostTest extends TestObject {
    @DataProvider(name="getUser")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\Funny-panda-cartoon-vector.jpg");
        String caption = "Testing upload file";
        return new Object[][]{

                {"user1900", "123456", "5612",},

        };
    }
    @Test(dataProvider = "getUser")
    public void deletePostTest(String username, String password, String userId){
        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage = new PostPage(webDriver);

        logInPage.navigateTo();
        logInPage.completeSignIn(username, password);

        header.clickProfileButton();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");

        postPage.clickOnPostImage();

        postPage.clickDeletePostButton();

        postPage.clickDeleteYesButton();

        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");
    }

}

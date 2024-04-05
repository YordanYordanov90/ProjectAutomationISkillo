package WebTestingISkillo;

import factory.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;


public class CreatePostTest extends TestObject{

    @DataProvider(name="getUser")
    public Object[][] getUsers() {
        File postPicture = new File("src\\test\\resources\\upload\\Funny-panda-cartoon-vector.jpg");
        String caption = "Testing upload file";
        return new Object[][]{

                {"user1900", "123456", "5612", postPicture, caption},

        };
    }

    @Test(dataProvider = "getUser")
    public void createPost(String username, String password, String userId, File postPicture, String caption){

        WebDriver webDriver = super.getWebDriver();
        Header header = new Header(webDriver);
        LogInPage logInPage = new LogInPage(webDriver);
        ProfilePage profilePage = new ProfilePage(webDriver);
        PostPage postPage =new PostPage(webDriver);


        logInPage.navigateTo();
        logInPage.completeSignIn(username, password);

        header.clickProfileButton();
        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");

        postPage.clickNewPostButton();
        Assert.assertTrue(postPage.isNewPostLoaded(), "The new post is not loaded");

        postPage.uploadPicture(postPicture);

        String actualImageText = postPage.uploadImageText();
        Assert.assertTrue(postPage.isPictureUploaded("Funny-panda-cartoon-vector.jpg"), "Image is not uploaded");
        Assert.assertEquals(actualImageText, "Funny-panda-cartoon-vector.jpg", "Incorect image is uploaded");

        postPage.typePostCaption(caption);
        postPage.clickCreatPost();

        Assert.assertTrue(profilePage.isUrlLoaded(userId), "Current page in not profile page for " + userId + " user");
    }
}

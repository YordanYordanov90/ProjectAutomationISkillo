package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class PostPage {
    private final WebDriver webDriver;

    @FindBy(xpath = "//h3[text()='Post a picture to share with your awesome followers']")
    private WebElement newPostTitle;
    @FindBy(xpath = "//input[@class='form-control input-lg'][@type='text']")
    private WebElement uploadPictureText;
    @FindBy(name = "caption")
    private WebElement postCaption;
    @FindBy(id = "create-post")
    private WebElement createPostButton;
    @FindBy(id = "nav-link-new-post")
    private WebElement newPostButton;
    @FindBy(xpath = "//div[@class='post-img']")
    private WebElement clickOnPostImg;
    @FindBy(xpath = "//i[@class='fas fa-trash-alt']")
    private WebElement deletePostButton;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm' and @type='button']")
    private WebElement deleteButtonYes;



    public PostPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
     public boolean isNewPostLoaded(){

        return newPostTitle.isDisplayed();
     }

     public void uploadPicture(File file){
         WebElement uploadFile = webDriver.findElement(By.xpath("//*[@class='form-group']/input[@type='file']"));
         uploadFile.sendKeys(file.getAbsolutePath());
     }
     public boolean isPictureUploaded(String fileName){
        String actualText = uploadPictureText.getAttribute("placeholder");
        if(actualText.equals(fileName)){
            return true;
        }
        return false;
     }
     public String uploadImageText(){
        return uploadPictureText.getAttribute("placeholder");
     }
     public void typePostCaption(String text){

        postCaption.sendKeys(text);
     }
     public void clickCreatPost(){

        createPostButton.click();
     }
     public void clickNewPostButton(){

        newPostButton.click();
     }

     public void clickOnPostImage(){
        clickOnPostImg.click();
     }
     public void clickDeletePostButton(){
        deletePostButton.click();
     }
    public void clickDeleteYesButton(){
        deleteButtonYes.click();
    }
}

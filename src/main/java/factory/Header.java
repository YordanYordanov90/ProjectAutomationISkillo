package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Header {
    private final WebDriver webDriver;
    @FindBy(id = "nav-link-login")
    private WebElement logInLink;
    @FindBy(id = "nav-link-profile")
    private WebElement profilePageLink;
    @FindBy(id = "nav-link-new-post")
    private WebElement newPostLink;


    public Header(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogInButton(){
        logInLink.click();
    }

    public void clickProfileButton(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(profilePageLink));
        profilePageLink.click();
    }

    public void clickNewPostButton(){
        newPostLink.click();
    }
    boolean isLogInLinkEnabled(){
        return logInLink.isEnabled();
    }
}

package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    public static final String PAGE_URL = "http://training.skillo-bg.com:4200/users/login";
    private final WebDriver webDriver;
    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameTextField;
    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordTextField;
    @FindBy(xpath = "//*[@class=\"remember-me\"]/input[@type=\"checkbox\"]")
    WebElement rememberMeCheckBox;
    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    public LogInPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(){
        this.webDriver.get(PAGE_URL);
    }

     public boolean isUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(PAGE_URL));
    }

    public void fillUserName(String username){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }

    public void fillPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        passwordTextField.sendKeys(password);
    }

    public void checkRememberMeBox( ){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckBox));
        rememberMeCheckBox.click();
    }

    boolean isCheckRememberMe(){
        return rememberMeCheckBox.isSelected();
    }

    public void clickSignIn(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void completeSignIn(String username, String password){
        fillUserName(username);
        fillPassword(password);
        checkRememberMeBox();
        clickSignIn();
    }
}



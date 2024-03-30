package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    public static final String REG_URL = "http://training.skillo-bg.com:4200/users/register";
    private final WebDriver webDriver;

    @FindBy(xpath = "//*[@name='username']")
    WebElement usernameTextField;
    @FindBy(xpath = "//*[@placeholder='email']")
    WebElement emailTextField;
    @FindBy(id = "defaultRegisterFormPassword")
    WebElement passwordTextField;
    @FindBy(id = "defaultRegisterPhonePassword")
    WebElement confirmPasswordTextField;
    @FindBy(id = "sign-in-button")
    WebElement signInButton;
    public RegistrationPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }
    public void navigateTo(){
        this.webDriver.get(REG_URL);
    }
    boolean isRegUrlLoaded(){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.urlToBe(REG_URL));
    }
    public void fillUsename(String username){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(usernameTextField));
        usernameTextField.sendKeys(username);
    }
    public void fillEmail(String email){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(emailTextField));
        emailTextField.sendKeys(email);
    }
    public void fillPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(passwordTextField));
        usernameTextField.sendKeys(password);
    }
    public void fillConfirmPassword(String password){
        WebDriverWait wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordTextField));
        confirmPasswordTextField.sendKeys(password);
    }
    public void clickSignInButton(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }
}

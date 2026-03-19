package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loginPage {

    WebDriver driver;
    Logger logg;

    // Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.logg = LogManager.getLogger(this.getClass());
        PageFactory.initElements(driver, this);
        logg.info("LoginPage initialized");
    }

    // Locators (ParaBank)
    @FindBy(name = "username")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;

    @FindBy(xpath = "//p[@class='error']")
    WebElement errorMessage;

    
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        logg.info("Entered username");
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        logg.info("Entered password");
    }

    public void clickLogin() {
        loginButton.click();
        logg.info("Clicked Login button");
    }

    public void login(String username, String password) {
        logg.info("Starting login process");

        enterUsername(username);
        enterPassword(password);
        clickLogin();

        logg.info("Login action completed");
    }

  
    public String getErrorMessage() {
        String msg = errorMessage.getText();
        logg.error("Login failed: " + msg);
        return msg;
    }
}
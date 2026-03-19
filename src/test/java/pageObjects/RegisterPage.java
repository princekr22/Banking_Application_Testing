package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitUtils;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(id = "customer.firstName")
    WebElement firstName;

    @FindBy(id = "customer.lastName")
    WebElement lastName;

    @FindBy(id = "customer.address.street")
    WebElement address;

    @FindBy(id = "customer.address.city")
    WebElement city;

    @FindBy(id = "customer.address.state")
    WebElement state;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCode;

    @FindBy(id = "customer.phoneNumber")
    WebElement phone;

    @FindBy(id = "customer.ssn")
    WebElement ssn;

    @FindBy(id = "customer.username")
    WebElement username;

    @FindBy(id = "customer.password")
    WebElement password;

    @FindBy(id = "repeatedPassword")
    WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerBtn;

    @FindBy(xpath = "//h1[contains(text(),'Welcome')]")
    WebElement successMessage;

    // Actions

    public void enterFirstName(String fname) {
        waitUtils.waitForVisibility(driver, firstName);
        firstName.sendKeys(fname);
    }

    public void enterLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void enterAddress(String addr) {
        address.sendKeys(addr);
    }

    public void enterCity(String c) {
        city.sendKeys(c);
    }

    public void enterState(String s) {
        state.sendKeys(s);
    }

    public void enterZip(String zip) {
        zipCode.sendKeys(zip);
    }

    public void enterPhone(String ph) {
        phone.sendKeys(ph);
    }

    public void enterSSN(String s) {
        ssn.sendKeys(s);
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void enterConfirmPassword(String pass) {
        confirmPassword.sendKeys(pass);
    }

    public void clickRegister() {
        waitUtils.waitForElementClickable(driver, registerBtn);
        registerBtn.click();
    }

    public String getSuccessMessage() {
        waitUtils.waitForVisibility(driver, successMessage);
        return successMessage.getText();
    }
}
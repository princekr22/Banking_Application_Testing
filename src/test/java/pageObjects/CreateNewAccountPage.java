package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.waitUtils;

public class CreateNewAccountPage {

    WebDriver driver;

    // Constructor
    public CreateNewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(id = "type")
    WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    WebElement existingAccountDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openAccountBtn;

    @FindBy(id = "newAccountId")
    WebElement newAccountId;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened')]")
    WebElement successMessage;

    // Actions

    public void selectAccountType(String type) {
        waitUtils.waitForVisibility(driver, accountTypeDropdown);
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(type);
    }

    public void selectExistingAccount(String accountId) {
        waitUtils.waitForVisibility(driver, existingAccountDropdown);
        Select select = new Select(existingAccountDropdown);
        select.selectByVisibleText(accountId);
    }
    
    public void clickOpenAccount() {
        waitUtils.waitForElementClickable(driver, openAccountBtn);
        openAccountBtn.click();
    }

    public String getNewAccountId() {
        waitUtils.waitForVisibility(driver, newAccountId);
        return newAccountId.getText();
    }

    public String getSuccessMessage() {
        waitUtils.waitForVisibility(driver, successMessage);
        return successMessage.getText();
    }
}
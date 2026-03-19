package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.waitUtils;

public class CreateNewAccountPage {

    WebDriver driver;

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

    // Actions

    // 1. Select Account Type
    public void selectAccountType(String type) {
        waitUtils.waitForElementClickable(driver, accountTypeDropdown);
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(type);
    }

    // 2. Select Existing Account (by index = BEST)
    public void selectExistingAccount() {
        waitUtils.waitForElementClickable(driver, existingAccountDropdown);
        Select select = new Select(existingAccountDropdown);
        select.selectByIndex(0);  // first available account
    }

    // 3. Click Open Account
    public void clickOpenAccount() {
        waitUtils.waitForElementClickable(driver, openAccountBtn);
        openAccountBtn.click();
    }

}
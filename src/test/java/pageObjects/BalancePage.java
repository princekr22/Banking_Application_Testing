package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BalancePage {

    WebDriver driver;
    Logger logg;

    
    public BalancePage(WebDriver driver) {
        this.driver = driver;
        this.logg = LogManager.getLogger(this.getClass());
        PageFactory.initElements(driver, this);
        logg.info("BalancePage initialized");
    }

    
    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverviewLink;

    
    @FindBy(xpath = "(//td[@class='balance'])[1]")
    WebElement senderBalance;

 
    @FindBy(xpath = "(//td[@class='balance'])[2]")
    WebElement receiverBalance;

    
    public void goToAccountsOverview() {
        accountsOverviewLink.click();
        logg.info("Navigated to Accounts Overview page");
    }

    
    public double getSenderBalance() {
        String balanceText = senderBalance.getText().replace("$", "").trim();
        double balance = Double.parseDouble(balanceText);
        logg.info("Sender Balance: " + balance);
        return balance;
    }

   
    public double getReceiverBalance() {
        String balanceText = receiverBalance.getText().replace("$", "").trim();
        double balance = Double.parseDouble(balanceText);
        logg.info("Receiver Balance: " + balance);
        return balance;
    }

 
    public boolean verifyBalanceDeduction(double before, double after, double amount) {
        logg.info("Verifying sender balance deduction...");
        return (before - after) == amount;
    }

    public boolean verifyBalanceAddition(double before, double after, double amount) {
        logg.info("Verifying receiver balance addition...");
        return (after - before) == amount;
    }
}
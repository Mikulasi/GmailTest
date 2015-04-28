package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends Page {

    @FindBy(xpath = "//*[text()='Forwarding and POP/IMAP']")
    private WebElement linkForwardingPOPIMAP;

    @FindBy(xpath = "//*[@value='Add a forwarding address']")
    private WebElement buttonAddForwardingAddress;

    @FindBy(xpath = "//*[@class='PN']//[@id=':lp']")
    private WebElement inputFieldNewForwardingEmailAddress;

    @FindBy(xpath = "//*[@class='J-at1-auR'][text()='Next']")
    private WebElement buttonNext;

    @FindBy(xpath = "//*[@value='Proceed']")
    private WebElement buttonProceed;

    @FindBy(xpath = "//*[@class='J-at1-auR'][text()='OK']")
    private WebElement buttonOKForwardingEmail;

    public SettingsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickForwardingPOPIMAP() {
        linkForwardingPOPIMAP.click();
    }

    public void clickButtonAddForwardingAddress(String email3) {
        buttonAddForwardingAddress.click();
        inputFieldNewForwardingEmailAddress.sendKeys(email3);
        buttonNext.click();
        buttonOKForwardingEmail.click();
    }
}

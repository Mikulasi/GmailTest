package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends Page {

    public static final Logger LOGGER = Logger.getLogger(UserPage.class);

    @FindBy(xpath = "//*[@class = 'T-I J-J5-Ji T-I-KE L3']")
    private WebElement writeMessageButton;

    @FindBy(xpath = "//*[@aria-label='To']")
    private WebElement fieldToWhom;

    @FindBy(xpath = "//*[@name='subjectbox']")
    private WebElement fieldTopic;

    @FindBy(xpath = "//*[@role='textbox']")
    private WebElement fieldLetter;

    @FindBy(xpath = "//*[text()='Send']")
    private WebElement buttonSend;

    @FindBy(xpath = "//*[@id='link_vsm']")
    private WebElement elementSentSuccessfully;

    @FindBy(xpath = "//*[@class='gb_da gbii']")
    private WebElement profileElement;

    @FindBy(xpath = "//*[@class='gb_ac gb_hc gb_5']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//*[@class='logo']")
    private WebElement logoGoogle;

    @FindBy(className = "gb_za")
    private WebElement emailCheckElement;

    @FindBy(xpath = "//*[@email='mikulas.yakovlev@gmail.com']")
    private WebElement selectLetter;

    @FindBy(xpath = "//[@data-tooltip='Report spam']")
    private WebElement elementSpam;

    @FindBy(xpath = "//*[@class='CJ'][text()='More']")
    private WebElement downList;

    @FindBy(xpath = "//*[text()='Spam']")
    private WebElement folderSpam;

    @FindBy(xpath = "//*[@id='gbqfq']")
    private WebElement insideSpamFolder;

    @FindBy(xpath = "//*[@email='mikulas.yakovlev@gmail.com']")
    private WebElement elementSend;

    @FindBy(xpath = "//*[@class='G-asx T-I-J3 J-J5-Ji']")
    private WebElement buttonSettings;

    @FindBy(id = "ms")
    private WebElement menuSettings;


    public UserPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCreateNewMessage(String email, String topic, String description) {

        writeMessageButton.click();
        fieldToWhom.sendKeys(email);
        fieldTopic.sendKeys(topic);
        fieldLetter.sendKeys(description);
        buttonSend.click();

    }

    public boolean checkIfMessageSent() {
        return elementSentSuccessfully.getText().equals("View message");
    }

    public void userSignOut() {
        profileElement.click();
        buttonSignOut.click();

    }

    public boolean isUserSignedOut() {
        if (logoGoogle.isDisplayed()) {
            LOGGER.info("User signed out!");
        } else {
            LOGGER.error("Error while signing out");
        }
        return logoGoogle.isDisplayed();
    }

    public void markLetterAsSpam() {
        selectLetter.click();
        elementSpam.click();
    }

    public boolean isSpam() {
        folderSpam.click();
        return elementSend.isDisplayed();
    }

    public void folderSpam() {
        downList.click();
        folderSpam.click();
    }

    public boolean isInSpamFolder() {
        return insideSpamFolder.getText().equals("in:spam".trim());
    }

    public void clickButtonSettings(){
        buttonSettings.click();
        menuSettings.click();
    }
}

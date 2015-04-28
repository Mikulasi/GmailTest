package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public static final Logger LOG = Logger.getLogger(LoginPage.class);

    public static final String GMAIL = "http://www.gmail.com";

    @FindBy(xpath = "//*[@id='reauthEmail']")
    private WebElement emailIfExistElement;

    @FindBy(xpath = "//*[@id='Email']")
    private WebElement emailElement;

    @FindBy(xpath = "//*[@id='Passwd']")
    private WebElement passElement;

    @FindBy(xpath = "//*[@id='account-chooser-link']")
    private WebElement anotherAccountElement;

    @FindBy(xpath = "//*[@id='gb']")
    private WebElement addAccountElement;

    @FindBy(xpath = "//*[@class='gb_da gbii']")
    private WebElement profileElement;

    @FindBy(className = "gb_za")
    private WebElement emailCheckElement;

    @FindBy(className = "google-js")
    private WebElement mainpageInChrome;

    @FindBy(id = "gmail-sign-in")
    private WebElement buttonLoginInChrome;

    @FindBy(xpath = "//*[@id='PersistentCookie']")
    private WebElement checkboxStaySignedIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        getWebDriver().navigate().to(GMAIL);

    }

    public void login(String email, String password) {

//        if (isElementPresents(By.id("reauthEmail")) && emailIfExistElement.getText().equals(email)) {
//            passElement.sendKeys(password);
//            if (checkboxStaySignedIn.isSelected()) {
//                checkboxStaySignedIn.click();
//            }
//            passElement.submit();
//        } else if (isElementPresents(By.id("id=account-chooser-link"))) {
//            anotherAccountElement.click();
//            addAccountElement.click();
//            emailElement.sendKeys(email);
//            passElement.sendKeys(password);
//            if (checkboxStaySignedIn.isSelected()) {
//                checkboxStaySignedIn.click();
//            }
//            passElement.submit();
//        } else {
            emailElement.clear();
            emailElement.sendKeys(email);
            passElement.clear();
            passElement.sendKeys(password);
            if (checkboxStaySignedIn.isSelected()) {
                checkboxStaySignedIn.click();
            }
            passElement.submit();
        }
//    }

    public String checkIfLogedIn(String email) {

        profileElement.click();
        if (emailCheckElement.getText().equals(email)) {
            LOG.info(email + " logged in");
        } else {
            LOG.error("Wrong user");
        }

        return email;
    }
}

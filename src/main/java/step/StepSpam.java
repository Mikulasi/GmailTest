package step;

import page.LoginPage;
import page.UserPage;
import ru.yandex.qatools.allure.annotations.Step;

public class StepSpam extends AbstractStep {

    private LoginPage loginPage;
    private UserPage userPage;

    public StepSpam() {
        loginPage = new LoginPage(getDriver());
        userPage = new UserPage(getDriver());
    }
    @Step
    public void loginGmail(String email, String password) {
        loginPage.openPage();
        loginPage.login(email, password);
    }

    @Step
    public void signOut() {
        userPage.userSignOut();
    }

    @Step
    public boolean checkIfLogedIn(String email) {
        return loginPage.checkIfLogedIn(email).trim().toLowerCase().equals(email);
    }

    @Step
    public void createNewLetter(String email, String topic, String description) {
        userPage.clickOnCreateNewMessage(email, topic, description);
    }

    @Step
    public boolean chekIfMessageSent() {
        return userPage.checkIfMessageSent();
    }

    @Step
    public boolean checkIfSignedOut() {
        return userPage.isUserSignedOut();
    }

    @Step
    public void checkAsSpam() {
        userPage.markLetterAsSpam();
    }

    @Step
    public boolean checkIfSpam() {
        return userPage.isSpam();
    }

    @Step
    public void getInSpamFolder() {
        userPage.folderSpam();
    }

    @Step
    public boolean checkIfInSpamFolder() {
        return userPage.isInSpamFolder();
    }

}

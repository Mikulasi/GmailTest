package step;

import page.LoginPage;
import page.SettingsPage;
import page.UserPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ForwardStep extends AbstractStep {

    private UserPage userPage;
    private LoginPage loginPage;
    private SettingsPage settingsPage;

    public ForwardStep() {
        userPage = new UserPage(getDriver());
        loginPage = new LoginPage(getDriver());
        settingsPage = new SettingsPage(getDriver());
    }
    @Step
    public void loginUser2(String email, String password){
        loginPage.openPage();
        loginPage.login(email, password);
    }
    @Step
    public void clickButtonSettings(){
        userPage.clickButtonSettings();
    }

    @Step
    public void addEmailForward(String email3){
        settingsPage.clickForwardingPOPIMAP();
        settingsPage.clickButtonAddForwardingAddress(email3);
    }
}

package step;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StepSpamTest {

    private StepSpam stepSpam;
    private final String EMAIL1 = "mikulas.yakovlev@gmail.com";
    private final String EMAIL2 = "mikulas.test@gmail.com";
    private final String TOPIC = "Test";
    private final String PASS = "brnopraha2011";
    private final String DESCR = "Test";

    @BeforeClass(description = "Init browser")
    public void setUp() throws Exception {

        stepSpam = new StepSpam();
        stepSpam.initDriver();
    }

    @Test
    public void testLoginGmail() throws Exception {
        stepSpam.loginGmail(EMAIL1, PASS);
        Assert.assertTrue(stepSpam.checkIfLogedIn(EMAIL1));
    }

    @Test(dependsOnMethods = "testLoginGmail")
    public void testCreateNewLetter() throws Exception {
        stepSpam.createNewLetter(EMAIL2, TOPIC, DESCR);
        Assert.assertTrue(stepSpam.chekIfMessageSent());
    }

    @Test(dependsOnMethods = "testCreateNewLetter")
        public void testSignOut(){
        stepSpam.signOut();
        Assert.assertTrue(stepSpam.checkIfSignedOut());
    }

    @Test(dependsOnMethods = "testSignOut")
    public void testLoginGmail2() throws Exception {
        stepSpam.loginGmail(EMAIL2, PASS);
        Assert.assertTrue(stepSpam.checkIfLogedIn(EMAIL2));
    }

    @Test(dependsOnMethods = "testLoginGmail2",expectedExceptions = {ElementNotVisibleException.class, InvalidSelectorException.class})
        public void testCheckAsSpam(){
        stepSpam.checkAsSpam();
        Assert.assertTrue(stepSpam.checkIfSpam());
    }

    @Test(dependsOnMethods = "testCheckAsSpam")
    public void testSignOut2User(){
        stepSpam.signOut();
        Assert.assertTrue(stepSpam.checkIfSignedOut());
    }

    @Test
    public void testFolderSpam(){
        stepSpam.getInSpamFolder();
        Assert.assertTrue(stepSpam.checkIfInSpamFolder());
    }

    @AfterClass
    public void tearDown() throws Exception {
        stepSpam.closeDriver();
    }
}
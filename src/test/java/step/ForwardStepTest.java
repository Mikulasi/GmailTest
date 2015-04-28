package step;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForwardStepTest {

    private ForwardStep forwardStep;
    private static final String EMAIL = "mikulas.test@gmail.com";
    private static final String PASS = "brnopraha2011";
    private static final String EMAIL3 = "mikulas.test3@gmail.com";


    @BeforeClass
    public void setUp() throws Exception {
        forwardStep = new ForwardStep();
        forwardStep.initDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        forwardStep.closeDriver();
    }

    @Test
    public void testLoginUser2() throws Exception {
        forwardStep.loginUser2(EMAIL,PASS);
    }

    @Test(dependsOnMethods = "testLoginUser2")
    public void testClickButtonSettings() throws Exception {
        forwardStep.clickButtonSettings();
    }

    @Test(dependsOnMethods = "testClickButtonSettings")
    public void testAddEmailForward() throws Exception {
        forwardStep.addEmailForward(EMAIL3);
    }
}
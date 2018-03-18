package kz.yakovlev.memos.test.runner;

import kz.yakovlev.memos.test.action.MainActions;
import kz.yakovlev.memos.test.helpers.TimingUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestSuiteRegres.class,
        TestSuiteLoad.class
})

public class AllTests {

    @BeforeClass
    public static void webDriverSetup() {
        MainActions.connectToApplication();
        TimingUtils.waitSeconds(1);
    }


    @AfterClass
    public static void webDriverTearDown() {
        MainActions.disconnectFromApplication();
    }

}

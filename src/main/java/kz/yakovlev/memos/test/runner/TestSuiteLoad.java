package kz.yakovlev.memos.test.runner;

import kz.yakovlev.memos.test.testcase.Test_10;
import kz.yakovlev.memos.test.testcase.Test_11;
import kz.yakovlev.memos.test.testcase.Test_8;
import kz.yakovlev.memos.test.testcase.Test_9;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test_8.class,
        Test_9.class,
        Test_10.class,
        Test_11.class
})
public class TestSuiteLoad {
}

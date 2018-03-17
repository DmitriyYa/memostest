package kz.yakovlev.memos.test.runner;

import org.junit.internal.TextListener;
import org.junit.runner.Computer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import java.io.*;
import java.util.Properties;

public class MainTestRunner {

    public static void main(String[] args) throws Exception {
        readGlobalProperties();
        runTest();
    }

    private static void runTest() throws Exception {
        // Initializing junit core
        Computer computer = new Computer();
        JUnitCore jUnitCore = new JUnitCore();

        // running all tests
        Result result = jUnitCore.run(computer, AllTests.class);

        // writing to console
        RunListener resultListenerConsole = new TextListener(System.out);
        resultListenerConsole.testRunFinished(result);

        // returning result
        System.exit(result.wasSuccessful() ? 0 : 1);

    }

    private static void readGlobalProperties() throws IOException {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("src\\main\\resources\\config.properties" )));
            for(Object key : properties.keySet()){
                GlobalProperties.setParameter((String) key, properties.getProperty((String) key));
            }
    }

}

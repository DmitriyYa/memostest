package kz.yakovlev.memos.test.runner;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class GlobalProperties {
    private static WebDriver driver = null;
    private static Map<String, String> parameters = new HashMap<String, String>();

    public static final String APPLICATION_URL = "application_url";
    public static final String DRIVER_PATH="driver_path";
    public static final String LOG_FILE_PATH = "log_file_path";
    public static final String USER_LOGIN = "user_login";
    public static final String USER_PASSWORD = "user_password";
    public static final String PUBLISHER_LOGIN = "publisher_login";
    public static final String PUBLOSHER_PASSWORD = "publisher_password";
    public static final String COUNT_USERS = "count_users";
    public static final String COUNT_ENTRY = "count_entry";
    public static final String STATUS_ACTUAL= "ACTUAL";
    public static final String STATUS_ARCHIVED= "ARCHIVED";
    public static final String STATUS_CANDIDATE= "CANDIDATE";



    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        GlobalProperties.driver = driver;
    }

    public static void setParameter(String name, String value){
        parameters.put(name, value);
    }

    public static String getParameter(String name){
        return parameters.get(name);
    }

}

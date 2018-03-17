package kz.yakovlev.memos.test.action;

import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class MainActions {
    public static void connectToApplication() {
        ChromeDriverService driverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(GlobalProperties.getParameter(GlobalProperties.DRIVER_PATH)))
                .build();

        WebDriver driver = new ChromeDriver(driverService);
        driver.get(GlobalProperties.getParameter(GlobalProperties.APPLICATION_URL));
        GlobalProperties.setDriver(driver);
    }

    public static void disconnectFromApplication() {
        GlobalProperties.getDriver().close();
    }

}

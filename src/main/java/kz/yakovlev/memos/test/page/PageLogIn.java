package kz.yakovlev.memos.test.page;

import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Окно для входа в приложение.
 */
public class PageLogIn {

    private static WebDriver driver = GlobalProperties.getDriver();

    public static WebElement txtBox_UserName(){
        return driver.findElement(By.id("username"));
    }

    public static WebElement txtBox_Password(){
        return driver.findElement(By.id("password"));
    }

    public static WebElement btn_LogIn(){
        return driver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']//form//input[@value='Log In']"));
    }

    public static WebElement chBox_Rebemder(){
        return driver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']/div[2]//form//input[@type='checkbox']"));
    }
}

package kz.yakovlev.memos.test.page;

import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRegister {
    private static WebDriver driver = GlobalProperties.getDriver();

    public static WebElement txtBox_UserName(){
        return driver.findElement(By.id("username"));
    }

    public static WebElement txtBox_Password(){
        return driver.findElement(By.id("password"));
    }

    public static WebElement btn_Register(){
        return driver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']//form//input[@value='Register']"));
    }
}

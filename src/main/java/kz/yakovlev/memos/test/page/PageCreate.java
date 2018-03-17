package kz.yakovlev.memos.test.page;

import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageCreate {

    private static WebDriver webDriver = GlobalProperties.getDriver();

    public static WebElement txt_Title() {
        return webDriver.findElement(By.id("title"));
    }

    public static WebElement txt_Descrition() {
        return webDriver.findElement(By.id("Description"));
    }

    public static WebElement btn_Save() {
        return webDriver.findElement(By.xpath("/html/body/div[@class='container']//form//button[@type='submit']"));
    }

    public static WebElement btn_Status(String status) {

        WebElement elementStatus = webDriver.findElement(By.id("status"));
        List<WebElement> chElement = elementStatus.findElements(new By.ByTagName("option"));
        WebElement elementResult = null;

        for (WebElement e : chElement) {
            if (status.equals(e.getText())) {
                elementResult = e;
            }
        }
        return elementResult;
    }

    public static String getTextError() {
        return webDriver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
    }

    public static WebElement btn_Status() {
        return webDriver.findElement(By.id("status"));
    }
}

package kz.yakovlev.memos.test.page;

import kz.yakovlev.memos.test.runner.GlobalProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageHome {
    private static WebDriver webDriver = GlobalProperties.getDriver();

    public static WebElement btnUser() {
        return webDriver.findElement(By.className("caret"));
    }

    public static WebElement btnUser(String userName) {
        return webDriver.findElement(By.linkText(userName));
    }

    public static WebElement btn_LogOut() {
        return webDriver.findElement(By.linkText("Logout"));
    }

    public static WebElement chBox_Archived() {
        return webDriver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']/div[3]/label[1]/input[@type='checkbox']"));
    }

    public static WebElement chBox_Actual() {
        return webDriver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']/div[3]/label[2]/input[@type='checkbox']"));
    }

    public static WebElement chBox_Candidate(){
        return webDriver.findElement(By.xpath("/html/body/div[@class='container']/div[@class='ng-scope']/div[3]/label[3]/input[@type='checkbox']"));
    }

    public static WebElement btn_Plus(){
        return webDriver.findElement(By.xpath("/html/body/div[@class='container']//a[@title='Create']"));
    }

    public static WebElement btn_Edit(String idTitle){
        WebElement elementParrent = getElementEntry(idTitle).findElement(By.xpath(".."));
        return elementParrent.findElement(By.xpath("//div/a[2]"));
    }

    public static WebElement btn_Bucket(String idTitle){
        WebElement elementParrent = getElementEntry(idTitle).findElement(By.xpath(".."));
        return elementParrent.findElement(By.xpath("//div/a[1]"));
    }

    public static String getTextEntry(String idElement){

        WebElement element = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]"));
        List<WebElement> chElements = element.findElements(By.className("ng-binding"));
        for (WebElement result:chElements) {
            if (result.getText().equals(idElement)){
                return result.getText();
            }
        }

        return null;
    }

    public static WebElement getElementEntry(String idElement){

        WebElement element = webDriver.findElement(By.xpath("/html/body/div[2]/div[2]"));
        List<WebElement> chElements = element.findElements(By.className("ng-binding"));
        for (WebElement result:chElements) {
            if (result.getText().equals(idElement)){
                return result;
            }
        }

        return null;
    }

    public static class MainMenu {
        public static WebElement btn_Memos() {
            return webDriver.findElement(By.linkText("Memos"));
        }

        public static WebElement btn_Home() {
            return webDriver.findElement(By.linkText("Home"));
        }

        public static WebElement btn_Login() {
            return webDriver.findElement(By.linkText("Login"));
        }

        public static WebElement btn_Register() {
            return webDriver.findElement(By.linkText("Register"));
        }
    }
}

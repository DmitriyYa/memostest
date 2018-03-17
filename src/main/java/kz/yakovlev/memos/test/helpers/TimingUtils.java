package kz.yakovlev.memos.test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimingUtils {
    /**
     * Waits sec seconds
     * @param sec
     */
    public static void waitSeconds(double sec){
        try {
            Thread.sleep(Math.round(sec * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     //явное ожидание загрузки страницы по XPath
     */
    public static void waitByXPath(WebDriver driver, int watSeconds, String stringEllement) {
        (new WebDriverWait(driver, watSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(stringEllement)));
    }

    /*
     //явное ожидание загрузки страницы по ClassName
     */
    public static void waitByClassName(WebDriver driver, int watSeconds, String stringEllement) {
        (new WebDriverWait(driver, watSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.className(stringEllement)));
    }

    /*
     //явное ожидание загрузки страницы по name
     */
    public static void waitByName(WebDriver driver, int watSeconds, String stringEllement) {
        (new WebDriverWait(driver, watSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.name(stringEllement)));
    }

    /*
     //явное ожидание загрузки страницы по id
     */
    public static void waitById(WebDriver driver, int watSeconds, String stringEllement) {
        (new WebDriverWait(driver, watSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.id(stringEllement)));
    }

}

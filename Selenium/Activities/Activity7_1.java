package activities;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity7_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");

        System.out.println("The title of the page is " + driver.getTitle());

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class, 'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, 'password')]")) ;

        username.sendKeys("admin");
        password.sendKeys("password");

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.quit();
    }
}

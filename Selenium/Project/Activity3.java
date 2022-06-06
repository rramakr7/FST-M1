package SeleniumProject;

//Goal: Open the site and login with the credentials provided

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity3 extends Activity1{
    @Test
    public static void login_OrangeHRM(){
        //find and enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("orange");
        //find and enter password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passWord.sendKeys("orangepassword123");
        //click on Login button
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
    }
    @Test
    public static void verify_Homepage(){
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
    }
}

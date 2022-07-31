package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test
    @Parameters({"Username","Password"})
    public void test1(String Username, String Password){
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        username.sendKeys(Username);
        password.sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmationMessage, "Welcome Back, admin");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}


package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;
    @BeforeClass
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @DataProvider(name = "Authentication")
    public static Object[][] credentials(){
        return new Object[][] {{"admin","password"}};
    }
    @Test(dataProvider = "Authentication")
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

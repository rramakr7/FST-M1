package SeleniumProject;

//Goal: Open the site and login with the credentials provided

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity3 extends Activity1{
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
    public static void verify_Homepage(){
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
        System.out.println("Assertion result is " + driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
        System.out.println("Homepage is displayed");
    }
    public static void main(String[] args) {
        //open the website
        driver_Init();
        login_OrangeHRM();
        //find and enter username
        //WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        //userName.sendKeys("orange");

        //find and enter password
        //WebElement passWord = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        //passWord.sendKeys("orangepassword123");

        //click Login button
        //driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

        //verify that the homepage is displayed
       /* Assert.assertTrue(driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
        System.out.println("Assertion result is " + driver.findElement(By.xpath("//a[@id='welcome']")).isDisplayed());
        System.out.println("Homepage is displayed");*/

        verify_Homepage();

        //close the browser
        driver_Close();
    }

}

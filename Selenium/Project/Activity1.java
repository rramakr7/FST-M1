package SeleniumProject;

//Goal: Read the title of the website and verify the text

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    static WebDriver driver = new FirefoxDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public static void driver_Init(){
        //open the website
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Website is opened");

    }
    @AfterClass
    public static void driver_Close(){
        //close the browser
        driver.quit();
        System.out.println("Browser is closed");
    }

    @Test
    public void verifyWebsiteTitle(){
        String websiteTitle = driver.getTitle();
        System.out.println("The title of the website is " + websiteTitle);
        //verify the website title is OrangeHRM
        Assert.assertEquals(websiteTitle,"OrangeHRM");
    }


}

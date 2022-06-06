package SeleniumProject;

//Goal: Read the title of the website and verify the text

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    static WebDriver driver = new FirefoxDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static void driver_Init(){
        //open the website
        driver.get("http://alchemy.hguy.co/orangehrm");
        System.out.println("Website is opened");
    }
    public static void driver_Close(){
        //close the browser
        driver.quit();
        System.out.println("Browser is closed");
    }

    public static void main(String[] args){
        //open the website
        driver_Init();
        String websiteTitle = driver.getTitle();
        System.out.println("The title of the website is " + websiteTitle);
        //verify the website title is OrangeHRM
        if(websiteTitle.equals("OrangeHRM")) {
            System.out.println("Website title is as expected");
            //close the browser
            driver_Close();
        }
        else
            System.out.println("Found website title mismatch");

    }


}

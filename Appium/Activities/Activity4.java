package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {
    AndroidDriver driver;

    WebDriverWait wait;

    //setUp method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        //Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ramya's Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.samsung.android.dialer");
        options.setAppActivity(".DialtactsActivity");
        options.noReset();

        //Server address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void addNewContact(){
        //Find and click the button to add a new contact.
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();
        //Find and fill the first name, last name, and phone number fields with the data provided.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Show detailed name fields")));
        driver.findElement(AppiumBy.accessibilityId("Show detailed name fields")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Hide detailed name fields")));
        driver.findElement(AppiumBy.accessibilityId("Hide detailed name fields")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Phone']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");

        //Click on Save.
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Save']")).click();

        //Write an assertion to ensure the new contact has been added.
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id ='com.samsung.android.app.contacts:id/communication_card']")));
        String name = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.samsung.android.app.contacts:id/header']")).getText();
        Assert.assertEquals(name, "Aaditya Varma");
        String number = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.samsung.android.app.contacts:id/display_number']")).getText();
        Assert.assertEquals(number, "999148292");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GoogleChromeActivity {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ramya's Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver(appServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open page
        driver.get("https://www.training-support.net/selenium");
    }
    @Test
    public void toDoList(){
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(UiScrollable + ".flingForward()"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //Add 3 tasks to the list
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Add tasks to list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Get number of tasks");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys("Clear the list");
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']")).click();

        //Get the number of tasks in the list
        WebElement tasklist = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']"));
        List<WebElement> tasks = tasklist.findElements(AppiumBy.className("android.widget.TextView"));
        System.out.println("No of tasks: " + tasks.size());

        //click on each of the tasks to strike them out
        int i=0;
        while(i<tasks.size()) {
            System.out.println("Task" + i + ":" + tasks.get(i).getText());
            tasks.get(i).click();
            i++;
        }

        //clear the list
        driver.findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[@text=' Clear List']")).click();

        //assert that all the tasks are cleared from task list
        //get the number of tasks from the list and assert if it is 0.
        tasks = tasklist.findElements(AppiumBy.className("android.widget.TextView"));
        System.out.println("No of tasks: " + tasks.size());

        Assert.assertEquals(tasks.size(),0);

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

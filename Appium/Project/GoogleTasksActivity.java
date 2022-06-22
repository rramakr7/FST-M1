package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class GoogleTasksActivity {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ramya's Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");

        //Driver initialization
        driver = new AndroidDriver(appServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void addNewTasks(){
        //Add 'Complete Activity with Google Tasks' task and save
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Tasks");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //Add 'Complete Activity with Google Keep' task and save
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete Activity with Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        //Add 'Complete the second Activity Google Keep' task and save
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='New task']")).sendKeys("Complete the second Activity Google Keep");
        driver.findElement(AppiumBy.id("add_task_done")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.id("task_name")));
        //assertion to check all 3 tasks have been added to the list
        List<WebElement> tasknames = driver.findElements(AppiumBy.id("task_name"));
        int noOfTasks = tasknames.size();
        System.out.println("Number of tasks: " + noOfTasks);

        //assuming the new tasks will be added to the top of the list
        System.out.println("Task1: " + tasknames.get(0).getText());
        System.out.println("Task2: " + tasknames.get(1).getText());
        System.out.println("Task3: " + tasknames.get(2).getText());
        Assert.assertEquals(tasknames.get(2).getText(),"Complete Activity with Google Tasks");
        Assert.assertEquals(tasknames.get(1).getText(),"Complete Activity with Google Keep");
        Assert.assertEquals(tasknames.get(0).getText(),"Complete the second Activity Google Keep");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

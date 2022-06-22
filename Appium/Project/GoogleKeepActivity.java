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

public class GoogleKeepActivity {
    WebDriverWait wait;
    AndroidDriver driver;
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("ramya's Galaxy M51");
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");

        //Driver initialization
        driver = new AndroidDriver(appServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addNewNotes(){
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@text='Title']")));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Title']")).sendKeys("Appium Project1");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Note']")).sendKeys("Appium Project1 for FST");
        driver.findElement(AppiumBy.accessibilityId("Open navigation drawer")).click();

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.id("index_note_title")));

        //getting the list of notes from the google keep home page
        List<WebElement> keepNoteTitles = driver.findElements(AppiumBy.id("index_note_title"));
        System.out.println("Number of Notes: " + keepNoteTitles.size());
        System.out.println(keepNoteTitles.get(0).getText());

        //assuming the latest note is saved as the first one
        Assert.assertEquals(keepNoteTitles.get(0).getText(), "Appium Project1");

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity12_3 {
    public static void main(String[] args){
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions builder = new Actions(driver);

        //Open browser
        driver.get("https://www.training-support.net/selenium/popups");

        //Print title of page and heading on page
        System.out.println("Page title is: " + driver.getTitle());

        //Find the Sign in button and hover over it. Print the tooltip message.
        WebElement signInButton = driver.findElement(By.xpath("//button[contains(@class,'orange')]"));
        builder.moveToElement(signInButton).pause(Duration.ofSeconds(2)).build().perform();
        String toolTipMessage = signInButton.getAttribute("data-tooltip");
        System.out.println("Tooltip text is " + toolTipMessage);

        //Click the button to open the Sign in form.
        signInButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        //Enter the credentials
        //username: admin
        //password: password
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        //Click login and print the message on the page after logging in.
        driver.findElement(By.xpath("//button[text()='Log in']"));
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        //Finally, close the browser.
        driver.quit();
    }
}

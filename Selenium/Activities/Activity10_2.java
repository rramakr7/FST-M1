package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);
        String pressedKeyText;

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("The title of the page is " + driver.getTitle());
        WebElement keyPressed = driver.findElement(By.id("keyPressed"));

        //Perform the following actions
        //Create an Action sequence - Press the key of your first name in caps
        Action actionSequence1 = builder.sendKeys("R").build();
        actionSequence1.perform();
        pressedKeyText = keyPressed.getText();
        System.out.println("Pressed key is " + pressedKeyText);

        //Create an Action sequence - Press CTRL+a and the CTRL+c to copy all the text on the page (Paste the text in a text editor to verify results.)
        Action actionSequence2 = builder.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build();
        actionSequence2.perform();
        pressedKeyText = keyPressed.getText();
        System.out.println("Pressed key is " + pressedKeyText);




        //Finally, close the browser.
        driver.quit();
    }
}

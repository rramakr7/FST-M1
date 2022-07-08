package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        Actions builder = new Actions(driver);

        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("The title of the page is " + driver.getTitle());

        //Find Cube web element
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));
        //On the page, perform
        //Left click and print the value of the side in the front.
        builder.click(cube);
        WebElement cubeValue = driver.findElement(By.className("active"));
        System.out.println("Value of the cube's side in front: " + cubeValue.getText());
        //Double click to show a random side and print the number.
        builder.doubleClick(cube).perform();
        cubeValue = driver.findElement(By.className("active"));
        System.out.println("Number on the random side: " + cubeValue.getText());
        //Right click and print the value shown on the front of the cube.
        builder.contextClick(cube).perform();
        cubeValue = driver.findElement(By.className("active"));
        System.out.println("Value of the cube's side in front: " + cubeValue.getText());

        //Finally, close the browser.
        driver.quit();


    }
}

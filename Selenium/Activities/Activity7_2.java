package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        System.out.println("The title of the page is " + driver.getTitle());

        //Sign Up details
        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input[1]"));
        WebElement email = driver.findElement(By.xpath("//input[starts-with(@class,'email')]"));

        userName.sendKeys("NewUser");
        password.sendKeys("Password");
        confirmPassword.sendKeys("Password");
        email.sendKeys("newuser@xyz.com");

        //click on sign up button
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();

        //print the login message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.quit();
    }
}

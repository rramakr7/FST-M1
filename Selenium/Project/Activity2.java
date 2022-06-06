package SeleniumProject;

//Goal: Print the url of the header image to the console

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 extends Activity1{
    public static void main(String[] args){
        //open the website
        driver_Init();
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        //print the url of the header image
        System.out.println("The url of the header image is " + headerImage.getAttribute("src"));
        //close the browser
        driver_Close();

    }

}

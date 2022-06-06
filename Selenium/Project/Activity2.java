package SeleniumProject;

//Goal: Print the url of the header image to the console

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity2 extends Activity1{

    @Test
    public void verifyHeaderImage(){
        //open the website
        WebElement headerImage = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        //print the url of the header image
        System.out.println("The url of the header image is " + headerImage.getAttribute("src"));
        //close the browser
    }

}

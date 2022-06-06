package SeleniumProject;

//Goal: Verify that the “Directory” menu item is visible and clickable

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Activity6 extends Activity3{

    @Test
    public void verifyDirectoryMenuItemIsVisible()  {
        //Locate the navigation menu
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='menu']")).isDisplayed());

        //Verify that the “Directory” menu item is visible and clickable
        Assert.assertTrue(driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']/b[text()='Directory']")).isDisplayed());

        //if clickable, click on the menu item
        driver.findElement(By.xpath("//a[@id='menu_directory_viewDirectory']/b[text()='Directory']")).click();

        //Verify that the heading of the page matches “Search Directory”
        WebElement pageHeading = driver.findElement(By.xpath("//div[@class='head']/h1"));
        System.out.println("Page Heading is " + pageHeading.getText());
        String directoryPageHeading = pageHeading.getText();
        Assert.assertEquals(directoryPageHeading,"Search Directory");

    }
}

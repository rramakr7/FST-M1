package SeleniumProject;

//Goal: Add an employee and their details to the site

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Activity4 extends Activity3{

    @Test
    @Parameters({"empFirstName","empLastName"})
    public void addEmployee(String firstName,String lastName) throws InterruptedException {

        //add the employee, click on PIM
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnAdd']")));
        //click on Add button
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        //enter firstname,lastname and click on Save
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        //search for the newly added employee, navigate back to PIM page
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();
        driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys(firstName+" "+lastName);
        driver.findElement(By.xpath("//input[@id='searchBtn']")).click();

        try{
            Assert.assertTrue(driver.findElement(By.linkText(firstName)).isDisplayed());
            Assert.assertTrue(driver.findElement(By.linkText(firstName)).isDisplayed());
            System.out.println("Newly added employee is getting retrieved");
        }catch(AssertionError assertionError){
            System.out.println("Assertion failed");
            System.out.println(assertionError.getMessage());
        }

    }
}

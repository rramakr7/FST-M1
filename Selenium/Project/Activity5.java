package SeleniumProject;

//Goal: Edit a user’s information

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.Scanner;

public class Activity5 extends Activity3{

    @Test
    @Parameters({"firstName","lastName","gender","nationality","doB"})
    public void editUserInfo(String firstName,String lastName,String gender, String nationality,String doB){
        //find the My Info menu item and click it
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b[text()='My Info']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b[text()='My Info']")).click();
        System.out.println("My Info page opened");
        //click on Edit button
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Edit']")));
        driver.findElement(By.xpath("//input[@value='Edit']")).click();

        //Fill in the Name, Gender, Nationality, and the DOB fields
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();
        driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys(firstName);
        System.out.println("First name entered");
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).clear();
        driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys(lastName);
        System.out.println("Last name entered");
        if(gender.equals("M") || gender.equals("m"))
            driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();
        else
            driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
        System.out.println("Gender entered");
        WebElement selectNationality = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
        Select s = new Select(selectNationality);
        s.selectByVisibleText(nationality);
        System.out.println("Nationality entered");
        driver.findElement(By.xpath("//input[@id='personal_DOB']")).clear();
        driver.findElement(By.xpath("//input[@id='personal_DOB']")).sendKeys(doB);
        System.out.println("DoB entered");
        //click on Save
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Edit']")));
        System.out.println("Saved");

    }
}

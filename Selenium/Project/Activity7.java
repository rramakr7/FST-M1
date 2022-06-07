package SeleniumProject;

//Goal: Add employee qualifications

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 extends Activity3{

    @Test
    @Parameters({"employer","jobTitle"})
    public void addQualifications(String employer,String jobTitle) {

        //find the My Info menu item and click it
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b[text()='My Info']")).click();
        driver.findElement(By.xpath("//a[@id='menu_pim_viewMyDetails']/b[text()='My Info']")).click();
        System.out.println("My Info page opened");

        //On the new page, find the Qualification option on the left side menu and click it.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[text()='Qualifications' and @href!='#']")));
        driver.findElement(By.xpath("//li/a[text()='Qualifications' and @href!='#']")).click();

        //Add Work Experience and click Save
        driver.findElement(By.xpath("//input[@id='addWorkExperience']")).click();
        driver.findElement(By.xpath("//input[@id='experience_employer']")).sendKeys(employer);
        driver.findElement(By.xpath("//input[@id='experience_jobtitle']")).sendKeys(jobTitle);
        driver.findElement(By.xpath("//input[@id='btnWorkExpSave']")).click();

        if(driver.findElement(By.xpath("//div[@class='head']/h1[text()='Work Experience']")).isDisplayed())
            System.out.println("Qualification is saved");
        else
            System.out.println("Qualification not saved");

    }
}

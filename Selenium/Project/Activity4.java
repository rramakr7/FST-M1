package SeleniumProject;

//Goal: Add an employee and their details to the site

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.Scanner;

public class Activity4 extends Activity3{

    public static void main(String[] args) {
        //open the website
        driver_Init();

        //login to website
        login_OrangeHRM();

        //verify homepage is displayed
        verify_Homepage();

        //Get the first name and last name using console (scanner class)
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        //System.out.println("First Name is " + firstName);
        System.out.println("Enter last name: ");
        String lastName = sc.next();
        //System.out.println("Last Name is " + lastName);

        /*add the employee
        click on PIM*/
        driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']/b[text()='PIM']")).click();

        //click on Add button
        driver.findElement(By.xpath("//input[@id='btnAdd']")).click();
        //enter firstname,lastname and click on Save
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='btnSave']")).click();

        /*search for the newly added employee
        navigate back to PIM page*/
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

        //close the browser
        driver_Close();
    }
}

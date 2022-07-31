package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
    @Test
    public void testCase1(){
        String pageTitle = driver.getTitle();
        System.out.println("Title of the page is " + pageTitle);
        Assert.assertEquals(pageTitle,"Target Practice");
    }
    @Test
    public void testCase2(){
        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(), "black");
    }
    @Test(enabled = false)
    public void testCase3(){
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    @Test
    public void testCase4(){
        throw new SkipException("Test case is skipped");
    }


}

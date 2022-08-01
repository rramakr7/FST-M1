package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTestSteps extends BaseClass {
    @Given("^User is on Login page$")
    public void openLoginPage(){
        //open the login page
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @When("^User enter username and password$")
    public void enterCredentials(){
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void enterCredentials_without_examples(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    @Then("^Read the page title and confirmation message$")
    public void readPageTitleAndMessage(){
        System.out.println("The title of the page is "+driver.getTitle());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("action-confirmation"))));
        String confirmationMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation message is " + confirmationMessage);
    }


}

package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestingWithTags extends BaseClass{
    @Given("^User is on the page$")
    public void alertTestPage(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }
    @When("^User clicks the Simple Alert button$")
    public void simpleAlertTest(){
        driver.findElement(By.xpath("//button[@id='simple']")).click();
    }
    @When("^User clicks the Confirm Alert button$")
    public void confirmAlertTest(){
        driver.findElement(By.xpath("//button[@id='confirm']")).click();
    }
    @When("^User clicks the Prompt Alert button$")
    public void promptAlertTest(){
        driver.findElement(By.xpath("//button[@id='prompt']")).click();
    }
    @Then("^Alert opens$")
    public void switchFocus(){
        alert = driver.switchTo().alert();
    }
    @And("^Read the text from it and print it$")
    public void readAlert(){
        String alertMessage = alert.getText();
        System.out.println("Alert message is " + alertMessage);
    }
    @And("^Write a custom message in it$")
    public void writeCustomMessage(){
        alert.sendKeys("OK to close");
    }
    @And("^Close the alert$")
    public void acceptAndCloseAlert(){
        alert.accept();
        System.out.println("Alert is accepted");
    }
    @And("^Close the alert with Cancel$")
    public void dismissAndCloseAlert(){
        alert.dismiss();
        System.out.println("Alert is dismissed");
    }
  /*  @And("^Read the result text$")
    public void readResultText(){
        String resultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println("Result Text is " + resultText);
    }*/

}

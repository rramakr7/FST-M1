package stepDefinitions;

import io.cucumber.java.en.And;


public class CloseBrowser extends BaseClass{
    @And("^Close the browser$")
    public void closeBrowser(){

        driver.quit();
        System.out.println("Browser is closed");
    }
}

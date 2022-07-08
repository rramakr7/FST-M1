package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");
        System.out.println("The title of the page is " + driver.getTitle());

        //Use findElement() to find the multi-select WebElement on the page.
        //Create a new Select class object with the WebElement.
        WebElement chosen = driver.findElement(By.id("multi-value"));
        Select multiSelect = new Select(driver.findElement(By.id("multi-select")));

        //Check if the HTML element is a multi-list. Proceed with other actions if it is.
        if(multiSelect.isMultiple()){
            //Select the 'JavaScript' option by visible text.
            multiSelect.selectByVisibleText("Javascript");
            System.out.println(chosen.getText());
            //Select the 'NodeJS' option by value.
            multiSelect.selectByValue("node");
            System.out.println(chosen.getText());
            //Select the 4th, 5th, and the 6th options by index.
            multiSelect.selectByIndex(4);
            multiSelect.selectByIndex(5);
            multiSelect.selectByIndex(6);
            System.out.println(chosen.getText());
            //Deselect the 'NodeJS' option by value attribute.
            multiSelect.deselectByValue("node");
            System.out.println(chosen.getText());
            //Deselect the 7th option by index.
            multiSelect.deselectByIndex(7);
            System.out.println(chosen.getText());
            //Print the first selected option.
            List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
            System.out.println("First selected option " + selectedOptions.get(0).getText());
            //Print all selected options one by one and deselect all options.
            for(WebElement selectedOption : selectedOptions){
                System.out.println(selectedOption.getText());
            }
            multiSelect.deselectAll();
            System.out.println(chosen.getText());

            //close the browser
            driver.quit();
        }

    }
}

package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");
        System.out.println("The title of the page is " + driver.getTitle());

        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        System.out.println("Number of rows are " + rows.size());
        System.out.println("Number of columns are " + columns.size());

        //Find and print the all the cell values of the third row of the table.
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        for(WebElement cellValue : thirdRow) {
            System.out.println(cellValue.getText());
        }

        // Find and print the cell value at the second row and second column.
        WebElement cellValue2_2 = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Cell Value at second row and second column: " + cellValue2_2.getText());

        //Close the browser.
        driver.quit();


    }
}

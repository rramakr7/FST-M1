package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");
        System.out.println("The title of the page is " + driver.getTitle());

        //Use findElements() in combination with xpath() to find the number of columns and rows (not counting the table header) and print them.
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of rows are " + rows.size());
        System.out.println("Number of columns are " + columns.size());

        //Find and print the cell value at the second row and second column.
        WebElement cellValue2_2_before = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell Value at second row and second column: " + cellValue2_2_before.getText());

        //Click the header of the first column to sort by name.
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]")).click();

        //Find and print the cell value at the second row and second column again.
        WebElement cellValue2_2_after = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell Value at second row and second column: " + cellValue2_2_after.getText());

        //Print the cell values of the table footer.
        List<WebElement> footer = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for(WebElement footer_cellvalue : footer){
            System.out.println(footer_cellvalue.getText());
        }

        //Alternate way to print footer cell values.
        WebElement footer_alt = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println(footer_alt.getText());

        //Close the browser.
        driver.quit();


    }
}

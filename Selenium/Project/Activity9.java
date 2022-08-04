package SeleniumProject;

//Goal: Login and retrieve the emergency contacts for the user

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 extends Activity3{

    @Test
    public void retrieveEmergencyContacts(){
        //Navigate to the “My Info” page.
        driver.findElement(By.xpath("//li/a[@id='menu_pim_viewMyDetails']")).click();
        driver.findElement(By.xpath("//li/a[@id='menu_pim_viewMyDetails']")).click();
        //Locate the left hand menu
        //Click on the “Emergency Contacts” menu item
        driver.findElement(By.xpath("//li/a[text()='Emergency Contacts']")).click();
        //Retrieve information about all the contacts listed in the table
        WebElement table = driver.findElement(By.id("emgcontact_list"));
        List<WebElement> table_Rows = table.findElements(By.tagName("tr"));
        int no_Of_Rows = table_Rows.size();
        System.out.println("The number of rows in the table: " + no_Of_Rows);
        int no_Of_Columns = table_Rows.get(1).findElements(By.tagName("td")).size();
        System.out.println("The number of columns in the table: " + no_Of_Columns);

        List <WebElement> table_Column_Headers = table_Rows.get(0).findElements(By.tagName("th"));

        String[][] tableData = new String[no_Of_Rows][no_Of_Columns];
        List<WebElement> columns = null;

        for(int i=0; i<no_Of_Columns; i++)
        {
            tableData[0][i] = table_Column_Headers.get(i).getText();
        }

        WebElement table_Rows_Data;
        List<WebElement> table_Columns_Data;

        for(int j=1; j<no_Of_Rows; j++)
        {
            table_Rows_Data = table_Rows.get(j);
            for(int k=0; k<no_Of_Columns; k++)
            {
                table_Columns_Data = table_Rows_Data.findElements(By.xpath("//tr/td"));
                tableData[j][k] = table_Columns_Data.get(k).getText();
            }
        }

        for (int r = 0; r < no_Of_Rows; r++) {       //for loop for row iteration.
            for (int c = 0; c < no_Of_Columns; c++) {   //for loop for column iteration.
                System.out.print(tableData[r][c] + " ");
            }
            System.out.println(); //using this for new line to print array in matrix format.
        }

    }
}

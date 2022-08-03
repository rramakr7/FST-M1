package SeleniumProject;

//Goal: Login and apply for a leave on the HRM site

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;

public class Activity8 extends Activity3{

    @Test
    @Parameters({"typeOfLeave","fromDate","toDate"})
    public void applyLeave(String typeOfLeave, String fromDate, String toDate){
        //Navigate to the Dashboard page and click on the Apply Leave option
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();

        //Select leave type and duration of the leave
        WebElement leaveType = driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']"));
        Select sel_LeaveType = new Select(leaveType);
        sel_LeaveType.selectByVisibleText(typeOfLeave);

        System.out.println("From Date: "+fromDate);
        String[] from_Year_Month_Date = fromDate.split("-");
        for(String a: from_Year_Month_Date) {
            System.out.println(a);
        }

        System.out.println("To Date: "+toDate);
        String[] to_Year_Month_Date = toDate.split("-");
        for(String a: to_Year_Month_Date) {
            System.out.println(a);
        }

        driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']")).click();

        WebElement from_LeaveYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select sel_FromLeaveYear = new Select(from_LeaveYear);
        sel_FromLeaveYear.selectByVisibleText(from_Year_Month_Date[0]);

        WebElement from_LeaveMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel_FromLeaveMonth = new Select(from_LeaveMonth);
        sel_FromLeaveMonth.selectByVisibleText(from_Year_Month_Date[1]);

        List<WebElement> calendar_days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for(WebElement day: calendar_days)
            if(day.getText().equals(from_Year_Month_Date[2])){
                System.out.println("day: " + day.getText());
                day.click();
                break;
            }

        driver.findElement(By.xpath("//input[@id='applyleave_txtToDate']")).click();

        WebElement to_LeaveYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select sel_ToLeaveYear = new Select(to_LeaveYear);
        sel_ToLeaveYear.selectByVisibleText(to_Year_Month_Date[0]);

        WebElement to_LeaveMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel_ToLeaveMonth = new Select(to_LeaveMonth);
        sel_ToLeaveMonth.selectByVisibleText(to_Year_Month_Date[1]);

        List<WebElement> to_calendar_days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for(WebElement day: to_calendar_days)
            if(day.getText().equals(to_Year_Month_Date[2])){
                System.out.println("day: " + day.getText());
                day.click();
                break;
            }

        //Click Apply
        driver.findElement(By.xpath("//input[@id='applyBtn']")).click();
        System.out.println("Leave data saved");

        //Navigate to the My Leave page to check the status of the leave application
        driver.findElement(By.xpath("//a[@id='menu_leave_viewMyLeaveList']")).click();

        driver.findElement(By.xpath("//input[@id='calFromDate']")).click();

        WebElement fromYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select sel_FromYear = new Select(fromYear);
        sel_FromYear.selectByVisibleText(from_Year_Month_Date[0]);

        WebElement fromMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel_FromMonth = new Select(fromMonth);
        sel_FromMonth.selectByVisibleText(from_Year_Month_Date[1]);

        List<WebElement> search_From_Calendar_Days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for(WebElement day: search_From_Calendar_Days)
            if(day.getText().equals(from_Year_Month_Date[2])){
                System.out.println("day: " + day.getText());
                day.click();
                break;
            }

        driver.findElement(By.xpath("//input[@id='calToDate']")).click();

        WebElement toYear = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select sel_ToYear = new Select(toYear);
        sel_ToYear.selectByVisibleText(to_Year_Month_Date[0]);

        WebElement toMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select sel_toMonth = new Select(toMonth);
        sel_toMonth.selectByVisibleText(to_Year_Month_Date[1]);

        List<WebElement> search_To_Calendar_Days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
        for(WebElement day: search_To_Calendar_Days)
            if(day.getText().equals(to_Year_Month_Date[2])){
                System.out.println("day: " + day.getText());
                day.click();
                break;
            }

        //Click Apply
        driver.findElement(By.xpath("//input[@id='btnSearch']")).click();

        List<WebElement> leaveTableDetails = driver.findElements(By.xpath("//td/a"));

        String leaveStatus = leaveTableDetails.get(2).getText();

        System.out.println("The status of the leave is " + leaveStatus);



    }
}

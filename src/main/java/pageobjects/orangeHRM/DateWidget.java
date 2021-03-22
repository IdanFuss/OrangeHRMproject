package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DateWidget
{
    @FindBy(className = "ui-datepicker-trigger")
    public List<WebElement> btn_datePicker;

    @FindBy(className = "ui-datepicker-month")
    public WebElement dropdown_month;

    @FindBy(className = "ui-datepicker-year")
    public WebElement dropdown_year;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//td")
    public List<WebElement> btn_day;
}

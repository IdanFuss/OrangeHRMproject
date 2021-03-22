package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;

public class UIActions extends CommonOps
{
    @Step("Click on element")
    public static void click(WebElement elem) {
    wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update text in element")
    public static void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Select dropdown element by name")
    public static void selectDropdown(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown = new Select(elem);
        dropdown.selectByVisibleText(text);
    }

    @Step("Select dropdown element by index")
    public static void selectDropdownByIndex(WebElement elem, int index) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropdown = new Select(elem);
        dropdown.selectByIndex(index - 1);
    }

    @Step("Clear text in textBox")
    public static void clear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    @Step("Upload file")
    public static void uploadFile(WebElement elem, String fileName) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys("C:/automation/test-automation/OrangeHRMproject/Files/" + fileName);
    }

    @Step("Click on each checkbox from a list")
    public static void markCheckboxOneByOne(List<WebElement> elem) {
        for (WebElement checkbox : elem) {
            UIActions.click(checkbox);
        }
    }
  //  int selectedDay, int selectedMonth, int selectedYear
    @Step("Picking date in a dateWidget")
    public static void datePicker(WebElement elem, String fullDate){
        wait.until(ExpectedConditions.visibilityOf(elem));
        UIActions.click(elem);
        String[] date = fullDate.split(",");
        UIActions.selectDropdownByIndex(orangeHRMDateWidget.dropdown_month, Integer.parseInt(date[1]));
        UIActions.selectDropdown(orangeHRMDateWidget.dropdown_year, date[2]);
        for (WebElement cell : orangeHRMDateWidget.btn_day){
            if(cell.getText().equals(date[0])){
                UIActions.click(cell);
                break;
            }
        }
    }
}

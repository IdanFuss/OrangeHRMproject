package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage
{
    @FindBy(xpath = "//div[@class='head']")
    public WebElement header_dashboard;
}

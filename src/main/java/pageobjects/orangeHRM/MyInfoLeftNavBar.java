package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyInfoLeftNavBar
{
    @FindBy(xpath = "//div[@class='imageHolder']")
    public WebElement pic_profilePic;

    @FindBy(xpath = "//ul[@id='sidenav']/li[1]")
    public WebElement btn_personalDetails;

    @FindBy(xpath = "//ul[@id='sidenav']/li[2]")
    public WebElement btn_contactDetails;

    @FindBy(xpath = "//ul[@id='sidenav']/li[3]")
    public WebElement btn_emergencyContacts;

    @FindBy(xpath = "//ul[@id='sidenav']/li[4]")
    public WebElement btn_dependents;

    @FindBy(xpath = "//ul[@id='sidenav']/li[5]")
    public WebElement btn_immigration;

    @FindBy(xpath = "//ul[@id='sidenav']/li[6]")
    public WebElement btn_job;

    @FindBy(xpath = "//ul[@id='sidenav']/li[7]")
    public WebElement btn_salary;

    @FindBy(xpath = "//ul[@id='sidenav']/li[8]")
    public WebElement btn_taxExemptions;

    @FindBy(xpath = "//ul[@id='sidenav']/li[9]")
    public WebElement btn_reportTo;

    @FindBy(xpath = "//ul[@id='sidenav']/li[10]")
    public WebElement btn_qualifications;

    @FindBy(xpath = "//ul[@id='sidenav']/li[11]")
    public WebElement btn_memberships;
}

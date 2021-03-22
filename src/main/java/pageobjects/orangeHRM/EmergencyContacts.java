package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmergencyContacts
{
    @FindBy(id = "btnAddContact")
    public WebElement btn_addContact;

    @FindBy(id = "delContactsBtn")
    public WebElement btn_deleteContact;

    @FindBy(name = "emgcontacts[name]")
    public WebElement txt_name;

    @FindBy(name = "emgcontacts[relationship]")
    public WebElement txt_relationship;

    @FindBy(name = "emgcontacts[homePhone]")
    public WebElement txt_homePhone;

    @FindBy(name = "emgcontacts[mobilePhone]")
    public WebElement txt_mobilePhone;

    @FindBy(name = "emgcontacts[workPhone]")
    public WebElement txt_workPhone;

    @FindBy(id = "btnCancel")
    public WebElement btn_cancel;

    @FindBy(name = "btnSaveEContact")
    public WebElement btn_saveContact;

    @FindBy(xpath = "//td/input[@class='checkbox']")
    public List<WebElement> checkbox_markContact;

    @FindBy(xpath = "//th/input[@id='checkAll']")
    public WebElement checkbox_markAllContacts;
}

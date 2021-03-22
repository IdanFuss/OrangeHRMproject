package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetailsMainPage
{
    @FindBy(name = "contact[street1]")
    public WebElement txt_firstAddressSt;

    @FindBy(name = "contact[street2]")
    public WebElement txt_secondAddressSt;

    @FindBy(name = "contact[city]")
    public WebElement txt_city;

    @FindBy(name = "contact[province]")
    public WebElement txt_state_province;

    @FindBy(name = "contact[emp_zipcode]")
    public WebElement txt_zipCode;

    @FindBy(name = "contact[country]")
    public WebElement dropdown_country;

    @FindBy(name = "contact[emp_hm_telephone]")
    public WebElement txt_homeTelephone;

    @FindBy(xpath = "//span[@for='contact_emp_hm_telephone']")
    public WebElement err_homeTelephoneFillingValidation;

    @FindBy(name = "contact[emp_mobile]")
    public WebElement txt_mobile;

    @FindBy(xpath = "//span[@for='contact_emp_mobile']")
    public WebElement err_mobileFillingValidation;

    @FindBy(name = "contact[emp_work_telephone]")
    public WebElement txt_workTelephone;

    @FindBy(xpath = "//span[@for='contact_emp_work_telephone']")
    public WebElement err_workTelephoneFillingValidation;

    @FindBy(name = "contact[emp_work_email]")
    public WebElement txt_workEmail;

    @FindBy(xpath = "//span[@for='contact_emp_work_email']")
    public WebElement err_workEmailFillingValidation;

    @FindBy(name = "contact[emp_oth_email]")
    public WebElement txt_otherEmail;

    @FindBy(xpath = "//span[@for='contact_emp_oth_email']")
    public WebElement err_otherEmailFillingValidation;

    @FindBy(id = "btnSave")
    public WebElement btn_edit_save;
}

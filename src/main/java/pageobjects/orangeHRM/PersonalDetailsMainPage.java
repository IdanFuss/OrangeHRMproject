package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PersonalDetailsMainPage
{
    @FindBy(xpath = "//input[@name='personal[txtEmpFirstName]']")
    public WebElement txt_firstName;

    @FindBy(xpath = "//*[@id='pdMainContainer']/div[1]/h1")
    public WebElement header_personalDetails;

    @FindBy(xpath = "//input[@name='personal[txtEmpMiddleName]']")
    public WebElement txt_middleName;

    @FindBy(xpath = "//input[@name='personal[txtEmpLastName]']")
    public WebElement txt_lastName;

    @FindBy(xpath = "//input[@name='personal[txtEmployeeId]']")
    public WebElement txt_employeeId;

    @FindBy(xpath = "//input[@name='personal[txtOtherID]']")
    public WebElement txt_otherID;

    @FindBy(xpath = "//input[@name='personal[txtLicenNo]']")
    public WebElement txt_licenseNumber;

    @FindBy(xpath = "//input[@name='personal[txtLicExpDate]']")
    public WebElement txt_licenseExpiryDate;

    @FindBy(xpath = "//ol[2]/li[4]/img")
    public WebElement btn_licenseExpiryDateWidget;

    @FindBy(xpath = "//input[@name='personal[txtNICNo]']")
    public WebElement txt_SSNNumber;

    @FindBy(xpath = "//input[@name='personal[txtSINNo]']")
    public WebElement txt_SINNumber;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    public WebElement radioBtn_genderMale;

    @FindBy(xpath = "//input[@id='personal_optGender_2']")
    public WebElement radioBtn_genderFemale;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    public WebElement dropdown_martialStatus;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement dropdown_nationality;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    public WebElement txt_dateOfBirth;

    @FindBy(xpath = "//ol[3]/li[4]/img")
    public WebElement btn_dateOfBirthWidget;

    @FindBy(xpath = "//input[@id='personal_txtEmpNickName']")
    public WebElement txt_nickName;

    @FindBy(xpath = "//input[@id='personal_chkSmokeFlag']")
    public WebElement checkBox_isSmoking;

    @FindBy(xpath = "//input[@id='personal_txtMilitarySer']")
    public WebElement txt_militaryService;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement btn_personalDetailsEdit_save;

    @FindBy(xpath = "//div[3]/div[1]/h1")
    public WebElement header_customFields;

    @FindBy(xpath = "//select[@name='custom1']")
    public WebElement dropdown_bloodType;

    @FindBy(xpath = "//input[@id='btnEditCustom']")
    public WebElement btn_bloodTypeEdit_save;
}

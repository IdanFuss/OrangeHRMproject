package workflows;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class WebFlows extends CommonOps
{
    @Step("Business flow - Login")
    public static void login(String username, String password) {
        UIActions.updateText(orangeHRMLogin.txt_username, username);
        UIActions.updateText(orangeHRMLogin.txt_password, password);
        UIActions.click(orangeHRMLogin.btn_login);
    }

    @Step("Business flow - Add attachment")
    public static void addAttachment(String fileName) {
        wait.until(ExpectedConditions.visibilityOf(orangeHRMAttachmentFrame.btn_addAttachment));
        UIActions.click(orangeHRMAttachmentFrame.btn_addAttachment);
        UIActions.uploadFile(orangeHRMAttachmentFrame.file_attachmentUpload, fileName);
        UIActions.click(orangeHRMAttachmentFrame.btn_attachmentSave);
    }

    @Step("Business flow - Delete attachment by marking each one")
    public static void deleteAttachmentOneByOne() {
        UIActions.markCheckboxOneByOne(orangeHRMAttachmentFrame.checkbox_markSpecificAttachment);
        UIActions.click(orangeHRMAttachmentFrame.btn_deleteAttachment);
    }

    @Step("Business flow - Delete all attachments by marking all")
    public static void deleteAllAttachment() {
        UIActions.click(orangeHRMAttachmentFrame.checkbox_markAllAttachment);
        UIActions.click(orangeHRMAttachmentFrame.btn_deleteAttachment);
    }

    @Step("Business flow - Delete emergency contact by marking each one")
    public static void deleteEmergencyContactOneByOne() {
        UIActions.markCheckboxOneByOne(orangeHRMEmergencyContacts.checkbox_markContact);
        UIActions.click(orangeHRMEmergencyContacts.btn_deleteContact);
    }

    @Step("Business flow - Delete all emergency contact by marking all")
    public static void deleteAllEmergencyContact() {
        UIActions.click(orangeHRMEmergencyContacts.checkbox_markAllContacts);
        UIActions.click(orangeHRMEmergencyContacts.btn_deleteContact);
    }

    @Step("Business flow - Logout from the site")
    public static void logout() {
        UIActions.click(orangeHRMMainNavBar.btn_welcome);
        UIActions.click(orangeHRMMainNavBar.btn_logout);
    }

    @Step("Business flow - Personal details - check specific details should be disabled")
    public static void personalDetailsElemDisabledCheck() {
        UIActions.click(orangeHRMPersonalDetailsMainPage.btn_personalDetailsEdit_save);
        Verifications.verifyElementIsNotEnabled(orangeHRMPersonalDetailsMainPage.txt_employeeId);
        Verifications.verifyElementIsNotEnabled(orangeHRMPersonalDetailsMainPage.txt_licenseNumber);
        Verifications.verifyElementIsNotEnabled(orangeHRMPersonalDetailsMainPage.txt_SSNNumber);
        Verifications.verifyElementIsNotEnabled(orangeHRMPersonalDetailsMainPage.txt_SINNumber);
        Verifications.verifyElementIsNotEnabled(orangeHRMPersonalDetailsMainPage.txt_dateOfBirth);
    }

    @Step("Business flow - Fill personal details")
    public static void personalDetailsFilling() {
        UIActions.click(orangeHRMPersonalDetailsMainPage.btn_personalDetailsEdit_save);
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_firstName);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_firstName, getData("FirstName"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_middleName);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_middleName, getData("MiddleName"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_lastName);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_lastName, getData("LastName"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_employeeId);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_employeeId, getData("EmployeeId"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_otherID);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_otherID, getData("OtherId"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_licenseNumber);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_licenseNumber, getData("DriversLicenseNo"));
        UIActions.datePicker(orangeHRMPersonalDetailsMainPage.btn_licenseExpiryDateWidget, getData("LicenseExpiryDate"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_SSNNumber);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_SSNNumber, getData("SSNNo"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_SINNumber);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_SINNumber, getData("SINNo"));
        UIActions.click(orangeHRMPersonalDetailsMainPage.radioBtn_genderMale);
        UIActions.selectDropdown(orangeHRMPersonalDetailsMainPage.dropdown_martialStatus, getData("MaritalStatus"));
        UIActions.selectDropdown(orangeHRMPersonalDetailsMainPage.dropdown_nationality, getData("Nationality"));
        UIActions.datePicker(orangeHRMPersonalDetailsMainPage.btn_dateOfBirthWidget, getData("DateOfBirth"));
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_nickName);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_nickName, getData("NickName"));
        UIActions.click(orangeHRMPersonalDetailsMainPage.checkBox_isSmoking);
        UIActions.clear(orangeHRMPersonalDetailsMainPage.txt_militaryService);
        UIActions.updateText(orangeHRMPersonalDetailsMainPage.txt_militaryService, getData("MilitaryService"));
        UIActions.click(orangeHRMPersonalDetailsMainPage.btn_personalDetailsEdit_save);
        Verifications.verifyTextInsertedToElement(orangeHRMPersonalDetailsMainPage.txt_firstName, getData("FirstName"));
    }

    @Step("Business flow - Upload my info photograph and check success")
    public static void myInfoUploadPhoto(String fileName,String fileType, String validFile) {
        UIActions.click(orangeHRMMyInfoLeftBar.pic_profilePic);
        UIActions.uploadFile(orangeHRMPhotographPage.btn_uploadPhoto, fileName + "." + fileType);
        UIActions.click(orangeHRMPhotographPage.btn_savePhoto);
        if (validFile.equalsIgnoreCase("valid")) {
            Verifications.verifyElementDisplayed(orangeHRMPhotographPage.txt_successfullyUpload);
        } else if (validFile.equalsIgnoreCase("invalid")) {
            Verifications.verifyElementDisplayed(orangeHRMPhotographPage.txt_warningMessage);
        } else System.out.println("Wrong scenario given, can be only valid or non valid");
    }
}


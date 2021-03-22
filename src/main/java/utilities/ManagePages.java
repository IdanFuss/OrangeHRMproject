package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.orangeHRM.PhotographPage;

public class ManagePages extends Base
{
    //initializing all the AUT pages for further use
    public static void initOrangeHRM(){
        orangeHRMLogin = PageFactory.initElements(driver, pageobjects.orangeHRM.LoginPage.class);
        orangeHRMDateWidget = PageFactory.initElements(driver, pageobjects.orangeHRM.DateWidget.class);
        orangeHRMDashboard =  PageFactory.initElements(driver, pageobjects.orangeHRM.DashboardPage.class);
        orangeHRMMyInfoLeftBar = PageFactory.initElements(driver, pageobjects.orangeHRM.MyInfoLeftNavBar.class);
        orangeHRMPersonalDetailsMainPage = PageFactory.initElements(driver, pageobjects.orangeHRM.PersonalDetailsMainPage.class);
        orangeHRMMainNavBar = PageFactory.initElements(driver, pageobjects.orangeHRM.MainNavBar.class);
        orangeHRMAttachmentFrame = PageFactory.initElements(driver, pageobjects.orangeHRM.AttachmentFrame.class);
        orangeHRMContactDetailsMainPage = PageFactory.initElements(driver, pageobjects.orangeHRM.ContactDetailsMainPage.class);
        orangeHRMPhotographPage = PageFactory.initElements(driver, PhotographPage.class);
        orangeHRMEmergencyContacts = PageFactory.initElements(driver, pageobjects.orangeHRM.EmergencyContacts.class);
    }
}

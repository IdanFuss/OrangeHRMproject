package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageobjects.orangeHRM.*;

public class Base
{

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softAssert;
    protected static Screen screen;


    //Page objects
    protected static LoginPage orangeHRMLogin;
    protected static DateWidget orangeHRMDateWidget;
    protected static DashboardPage orangeHRMDashboard;
    protected static MyInfoLeftNavBar orangeHRMMyInfoLeftBar;
    protected static PersonalDetailsMainPage orangeHRMPersonalDetailsMainPage;
    protected static MainNavBar orangeHRMMainNavBar;
    protected static AttachmentFrame orangeHRMAttachmentFrame;
    protected static ContactDetailsMainPage orangeHRMContactDetailsMainPage;
    protected static PhotographPage orangeHRMPhotographPage;
    protected static EmergencyContacts orangeHRMEmergencyContacts;
}

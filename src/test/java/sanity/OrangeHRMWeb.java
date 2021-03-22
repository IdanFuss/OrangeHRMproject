package sanity;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class OrangeHRMWeb extends CommonOps
{
    @Test(description = "TC-01 - Login", dataProvider = "Data provider - Login", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test login to the site and verify expected result - using DDT")
    public void TC_01(String user, String password, String validOrInvalid) {
        WebFlows.login(user, password);
        Verifications.assertLoginSucceed(validOrInvalid);
    }

    @Test(description = "TC-05 - Verify personal details on my info")
    @Description("This test click on my info and check if personal details page appears")
    public void TC_05() {
        WebFlows.login(getData("LoginUserName"), getData("LoginPassword"));
        UIActions.click(orangeHRMMainNavBar.btn_myInfo);
        Verifications.verifyElementDisplayed(orangeHRMPersonalDetailsMainPage.header_personalDetails);
    }

    @Test(description = "TC-06 - check in personal details if the user can edit details other what mentioned in RTM")
    @Description("This test check if the specific elements is disabled while editing")
    public void TC_06() {
        UIActions.click(orangeHRMMainNavBar.btn_myInfo);
        WebFlows.personalDetailsElemDisabledCheck();
    }

    @Test(description = "TC-07 - Fill personal details and save")
    @Description("This test check filling the personal details data and verify its saved")
    public void TC_07() {
        UIActions.click(orangeHRMMainNavBar.btn_myInfo);
        WebFlows.personalDetailsFilling();
    }

    @Test(description = "TC-08 - Login", dataProvider = "Data provider - My info pic upload", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test upload a specific type of file and check if it appear as profile picture")
    public void TC_08(String fileName, String fileType, String isValid) {
        UIActions.click(orangeHRMMainNavBar.btn_myInfo);
        WebFlows.myInfoUploadPhoto(fileName, fileType, isValid);
    }
}

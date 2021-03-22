package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainNavBar
{
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement btn_admin;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement btn_PIM;

    @FindBy(id = "menu_leave_viewLeaveModule")
    public WebElement btn_leave;

    @FindBy(id = "menu_time_viewTimeModule")
    public WebElement btn_time;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    public WebElement btn_recruitment;

    @FindBy(xpath = "//*[@id='menu_pim_viewMyDetails']")
    public WebElement btn_myInfo;

    @FindBy(id = "menu__Performance")
    public WebElement btn_Performance;

    @FindBy(id = "menu_dashboard_index")
    public WebElement btn_dashboard;

    @FindBy(id = "menu_directory_viewDirectory")
    public WebElement btn_directory;

    @FindBy(id = "menu_maintenance_purgeEmployee")
    public WebElement btn_maintenance;

    @FindBy(id = "menu_buzz_viewBuzz")
    public WebElement btn_buzz;

    @FindBy(className = "panelTrigger")
    public WebElement btn_welcome;

    @FindBy(xpath = "//a[@href='/index.php/auth/logout']")
    public WebElement btn_logout;
}

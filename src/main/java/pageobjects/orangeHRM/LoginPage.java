package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage
{
    @FindBy(name = "txtUsername")
    public WebElement txt_username;

    @FindBy(name = "txtPassword")
    public WebElement txt_password;

    @FindBy(name = "Submit")
    public WebElement btn_login;

    @FindBy(id = "spanMessage")
    public WebElement txt_loginError;
}

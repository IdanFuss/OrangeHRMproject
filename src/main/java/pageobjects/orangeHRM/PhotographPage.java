package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhotographPage
{
    @FindBy(name = "photofile")
    public WebElement btn_uploadPhoto;

    @FindBy(id = "btnSave")
    public WebElement btn_savePhoto;

    @FindBy(id = "btnDelete")
    public WebElement btn_deletePhoto;

    @FindBy(xpath = "//div[@class='message success fadable']")
    public WebElement txt_successfullyUpload;

    @FindBy(xpath = "//div[@class='message warning fadable']")
    public WebElement txt_warningMessage;
}

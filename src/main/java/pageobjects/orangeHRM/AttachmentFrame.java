package pageobjects.orangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AttachmentFrame
{
    @FindBy(xpath = "//*[@id='attachmentList']/div[1]/h1")
    public WebElement header_attachment;

    @FindBy(xpath = "//td/input[@class='checkboxAtch']")
    public List<WebElement> checkbox_markSpecificAttachment;

    @FindBy(xpath = "//th/input[@class='checkboxAtch']")
    public WebElement checkbox_markAllAttachment;

    @FindBy(id = "btnDeleteAttachment")
    public WebElement btn_deleteAttachment;

    @FindBy(className = "addbutton")
    public WebElement btn_addAttachment;

    @FindBy(id = "ufile")
    public WebElement file_attachmentUpload;

    @FindBy(id = "btnSaveAttachment")
    public WebElement btn_attachmentSave;
}

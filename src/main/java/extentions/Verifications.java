package extentions;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;

import static org.testng.AssertJUnit.*;

public class Verifications extends CommonOps
{
    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement elem, String expectedResult){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expectedResult);
    }

    @Step("Verify text inserted to element")
    public static void verifyTextInsertedToElement(WebElement elem, String expectedResult){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getAttribute("value"), expectedResult);
    }

    //Verify the error that following the tested element
    @Step("Verify following error is displayed")
    public static void VerifyErrorAppear(WebElement elem){
        String elemTagName = elem.getTagName();
        String elemNameAttribute = elem.getAttribute("name");
        WebElement error = driver.findElement(By.xpath("//" + elemTagName + "[@name='" + elemNameAttribute + "']/following-sibling::span"));
        wait.until(ExpectedConditions.visibilityOf(error));
        softAssert.assertTrue(error.isDisplayed());
    }

    @Step("Verify display of several elements by softAssert")
    public static void visibilityOfElements(List<WebElement> elems){
        for (WebElement elem: elems){
            softAssert.assertTrue(elem.isDisplayed());
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify element is displayed")
    public static void verifyElementDisplayed(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify element is not displayed")
    public static void verifyElementIsNotDisplayed(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertFalse(elem.isDisplayed());
    }

    //Verify image by sikuli
    @Step("Verify element visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo") + expectedImageName);
        } catch (FindFailed findFailed) {
            System.out.println("Error finding expected image " + findFailed);
            fail("Error finding expected image " + findFailed);
        }
    }

    @Step("Verify element is not enabled")
    public static void verifyElementIsNotEnabled(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertFalse(elem.isEnabled());
    }

    @Step("Assert login succeeded or show error")
    public static void assertLoginSucceed(String validLogin) {
        if (validLogin.equalsIgnoreCase("valid")){
            Verifications.verifyElementDisplayed(orangeHRMDashboard.header_dashboard);
            WebFlows.logout();
        } else if (validLogin.equalsIgnoreCase("invalid"))
            Verifications.verifyElementDisplayed(orangeHRMLogin.txt_loginError);
        else
            throw new RuntimeException("Invalid expected output - should get only valid or invalid");
    }
}

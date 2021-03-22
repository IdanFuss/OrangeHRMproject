package utilities;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Listeners extends CommonOps implements ITestListener
{
    public void onTestStart(ITestResult test) {
        System.out.println("-------------------" + test.getName() + " Started-------------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("-------------------" + test.getName() + " Passed-------------------");
        //Stop recording
        try {
            MonteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Delete file
        File file = new File("./test-recordings/" + test.getName() + ".avi");
        if (file.delete())
            System.out.println("File deleted successfully");
        else
            System.out.println("Failed to delete file");
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("-------------------" + test.getName() + " Failed-------------------");
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        //Stop recording
        try {
            MonteScreenRecorder.stopRecord();
            System.out.println("File saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveScreenShot();
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("-------------------Skipping Test " + test.getName() + "-------------------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    public void onStart(ITestContext execution) {
        System.out.println("-------------------Test-Suit started-------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("-------------------Test-Suit Ending-------------------");
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenShot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

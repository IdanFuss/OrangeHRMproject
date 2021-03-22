package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base
{
    @BeforeClass
    public void startSession() {
        if (getData("PlatformName").equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
//      else if (getData("PlatformName").equalsIgnoreCase("mobile"))
//            initMobile();
        else
            throw new RuntimeException("invalid platform name");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        softAssert = new SoftAssert();
        screen = new Screen();
    }

    @AfterClass
    public void closeSession() {
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        //Start recording screen recorder
        try {
            MonteScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterMethod() {
        driver.get(getData("URL"));
    }

    //get data from xml file method
    public static String getData (String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    //initializing the browser type
    public void initBrowser(String browserType) {
       if (browserType.equalsIgnoreCase("chrome"))
           driver = initChromeDriver();
       else if (browserType.equalsIgnoreCase("firefox"))
           driver = initFirefoxDriver();
       else if (browserType.equalsIgnoreCase("edge"))
           driver = initEdgeDriver();
       else
           throw new RuntimeException("invalid Browser type");
       driver.get(getData("URL"));
       wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
       driver.manage().window().maximize();
       ManagePages.initOrangeHRM();
       action = new Actions(driver);
    }

    //initializing the chrome driver
    public WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    //initializing the firefox driver
    public WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
    //  System.setProperty("webdriver.gecko.driver", "C:/automation/libs/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    //initializing the internetExplorer driver
    public WebDriver initEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        return driver;
    }
}

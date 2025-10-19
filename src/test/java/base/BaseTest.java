package base;

import com.aventstack.extentreports.*;
import com.microsoft.playwright.*;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotUtil.takeScreenshot(page, result.getName());

            System.out.println("*** screenshotPath : "+screenshotPath);
            String projectPath = System.getProperty("user.dir");

            String absoluteScreenshotPath = projectPath+"/"+screenshotPath;
            System.out.println(" *** absoluteScreenshotPath : "+absoluteScreenshotPath);

           test.addScreenCaptureFromPath(absoluteScreenshotPath, "screenshot");
		//	test.addScreenCaptureFromBase64String(absoluteScreenshotPath, "screenshot");

        } else if(result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }

        extent.flush();

        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

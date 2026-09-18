package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentLogger;
import utils.ExtentReportManager;

public class TestListener implements ITestListener {

    ExtentReports extent =ExtentReportManager.getReportObject();
    ExtentTest test;


    @Override
    public void onTestStart(ITestResult result)
    {
        test = extent.createTest(result.getMethod().getMethodName());

        ExtentLogger.test = test;
        test.info("Test execution started");
    }


    @Override
    public void onTestSuccess(ITestResult result)
    {
        addReporterLogs(result);
        test.pass("Test passed successfully");
    }


    @Override
    public void onTestFailure(ITestResult result)
    {
        addReporterLogs(result);
        test.fail("Test failed");
        test.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) 
    {
        test.skip("Test skipped");
    }


    @Override
    public void onFinish(ITestContext context) 
    {
        extent.flush();
    }
    private void addReporterLogs(ITestResult result)
    {
        for(String log : Reporter.getOutput(result))
        {
            test.info(log);
        }
    }
}

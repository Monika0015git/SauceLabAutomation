package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager 
{
	 static ExtentReports extent;

	    public static ExtentReports getReportObject() 
	    {
	        String reportPath = System.getProperty("user.dir")+ "/reports/ExtentReport.html";

	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
	        sparkReporter.config().setReportName("Automation Test Report");
	        sparkReporter.config().setDocumentTitle("Selenium Test Execution Report");

	        extent = new ExtentReports();

	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Tester", "Monika Rani Bilung");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("Browser", "Chrome");

	        return extent;
	    }

}

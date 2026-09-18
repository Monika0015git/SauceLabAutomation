package utils;

import com.aventstack.extentreports.ExtentTest;

public class ExtentLogger {

    public static ExtentTest test;

    public static void log(String message) 
    {
        test.info(message);
    }

}

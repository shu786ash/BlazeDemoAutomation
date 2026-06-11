package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.Base;
import Utilities.ExtentManager;
import Utilities.ScreenshotUtils;

public class MyListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println("Test Execution Finished");
    }

    @Override
    public void onTestStart(ITestResult result) {

        Object[] data = result.getParameters();

        if (data.length > 0) {

            test = extent.createTest(
                    result.getName() + " - " + data[0].toString());

        } else {

            test = extent.createTest(result.getName());
        }

        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");

        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        System.out.println("Test Failed: " + result.getName());

        try {

            ScreenshotUtils.captureScreenshot(
                    Base.driver,
                    result.getName());

            System.out.println("Screenshot captured successfully");

        } catch (Exception e) {

            System.out.println("Failed to capture screenshot");

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.skip("Test Skipped");

        System.out.println("Test Skipped: " + result.getName());
    }
}
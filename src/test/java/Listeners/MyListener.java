package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.Base;
import Utilities.ScreenshotUtils;

public class MyListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Execution Finished");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed: " + result.getName());

        try {

            ScreenshotUtils.captureScreenshot(
                    Base.driver,result.getName());

            System.out.println("Screenshot captured successfully");

        } catch (Exception e) {

            System.out.println("Failed to capture screenshot");

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
    }
}
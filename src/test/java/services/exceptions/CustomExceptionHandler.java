package services.exceptions;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomExceptionHandler extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("Test Failed: " + tr.getName());
        System.out.println("Error: " + tr.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("Test Skipped: " + tr.getName());
    }
}

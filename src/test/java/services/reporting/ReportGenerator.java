package services.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGenerator {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReport(String reportFilePath) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFilePath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logError(String message) {
        test.error(message);
    }

    public static void flushReport() {
        extent.flush();
    }
}

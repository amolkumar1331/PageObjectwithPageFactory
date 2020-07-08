package Listener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.Browser;

public class DemoListener extends Browser implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("Completed execution");

	}

	public void onStart(ITestContext arg0) {
		System.out.println("Started execution");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		String date = new SimpleDateFormat("DD-mm-yyyy").format(new Date());

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f,
					new File("D:\\Class\\ClearTrip\\ScreenShots\\failes\\" + result.getName() + date + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {

		String date = new SimpleDateFormat("DD-mm-yyyy").format(new Date());

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(f,
					new File("D:\\Class\\ClearTrip\\ScreenShots\\Pass\\" + result.getName() + date + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

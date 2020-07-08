package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Browser {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fp;

	@BeforeSuite
	public void launchBrowser() throws FileNotFoundException, IOException {

		prop = new Properties();
		prop.load(new FileInputStream("D:\\Class\\ClearTrip\\src\\test\\java\\PropertyFiles\\config.properties"));
		if (prop.get("Browser").equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"D:\\Class\\ClearTrip\\src\\test\\java\\Exe_files\\chromedriver_Version83.exe");
			driver = new ChromeDriver();

		} else if (prop.get("Browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\Class\\ClearTrip\\src\\test\\java\\Exe_files\\chromedriver_Version83.exe");
			driver = new InternetExplorerDriver();

		} else {
			System.out.println("Browser not found");
		}

		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void validateURL(){
		String url =driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.cleartrip.com/");
	}
	
	@Test
	public void Validatetitle(){
		String title =driver.getTitle();
		Assert.assertEquals(title, "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	}
	
	@AfterSuite
	public void closeBrowser() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}

}

package PageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utility.Utility;

public class HomePO {

	WebDriver driver;
	
	public HomePO(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(id = "FromTag")
	WebElement fromtext;

	@FindBy(id = "ToTag")
	WebElement totext;

	@FindBy(id = "DepartDate")
	WebElement departdate;

	@FindBy(id = "Adults")
	WebElement adult;

	@FindBy(id = "Childrens")
	WebElement childrens;

	@FindBy(id = "Infants")
	WebElement infants;

	@FindBy(id = "SearchBtn")
	WebElement SearchBtn;

	@FindBy(xpath = "//*[@class='ui-datepicker-year']")
	WebElement year;

	@FindBy(xpath = "//*[@class='ui-datepicker-month']")
	WebElement month;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td/a")
	List<WebElement> date;

	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/div/a")
	WebElement nextcalendarbtn;

	public void searchflights() {

		fromtext.clear();
		fromtext.sendKeys("Mumbai");
		fromtext.sendKeys(Keys.DOWN);
		fromtext.sendKeys(Keys.ENTER);

		totext.clear();
		totext.sendKeys("Delhi");
		totext.sendKeys(Keys.DOWN);
		totext.sendKeys(Keys.ENTER);

		calendardateSelect();

		Utility.selectDropdown(adult, "2");
		Utility.selectDropdown(childrens, "1");
		Utility.selectDropdown(infants, "1");

	}

	public void calendardateSelect() {
		departdate.click();
		String yr = year.getText();
		while (!yr.contains("2020")) {
			nextcalendarbtn.click();
			yr = year.getText();
		}

		String m = month.getText();
		while (!m.contains("December")) {
			nextcalendarbtn.click();
			m = month.getText();
		}

		for (WebElement d : date) {
			if (d.getText().contains("13")) {
				d.click();
			}
		}

	}

}

package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.Browser;
import Listener.DemoListener;
import PageObjects.HomePO;

@Listeners(DemoListener.class)
public class HomeTest extends Browser {

	@Test
	public void m1() {

		HomePO hp = PageFactory.initElements(driver, HomePO.class);
		hp.searchflights();

	}

}

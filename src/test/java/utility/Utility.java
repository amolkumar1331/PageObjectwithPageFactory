package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility{

	public static void selectDropdown(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

}

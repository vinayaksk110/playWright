package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectingElementInOther {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
		loc.allInnerTexts().forEach(e -> System.out.println(e));
	}

}

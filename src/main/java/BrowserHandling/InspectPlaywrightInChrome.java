package BrowserHandling;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InspectPlaywrightInChrome {

	// navigate to the project folder and run the below link

	// mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI
	// -Dexec.args="codegen https://www.amazon.com/"

	// Once downloaded and opened, open inspector and open console
	// playwright object will be created in new browser
	// playwright.$ - for single element
	// playwright.$$ for multiple elements

	// Search for playwright.$("text=registry")
	// search for playwright.inspect("text=registry")
	// Search for playwright.$$("text=registry")
	// Search for playwright.$$("a:has text('Amazon')")

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		
		List<String> amazonLinksList = page.locator("a:has-text('Amazon')").allInnerTexts();
		amazonLinksList.stream().forEach(e -> System.out.println(e));
		
		browser.close();
		playwright.close();
		
	}
}


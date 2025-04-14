package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class selectorsPlaywrightInfo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting browser");
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//different selectors
//		text selector
//		CSS selector
//		selecting by visible elements
//		selecting elements that contain other elements
//		selecting elements matching one of the conditions
//		selecting elements in shadow DOM
//		selecting elements based on layout
//		Xpath selector
//		N-th element selector
//		React selectors
//		Vue selectors
//		id, data-testid, data-test-id, data-test
//		pick nth match from query result
//		chaining selectors
//		
		
	}

}

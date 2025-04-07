package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class selectorsPlaywright {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//different selectors
//		test selector
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
		
		//use below tags
//		div.vinayak   --div tag and . is for class and vinayak is classname 
//		div#vinayak   --div is tag, # is for id and vinayak is id value
//		select#Form_getForm_Country option  --select tag, #is for id, Form_getForm_country is id value, option is child tag
		
	}

}

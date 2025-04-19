package elements;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CreateElement {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting browser");
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		
		//locators
		BrowserContext browserContext =browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		System.out.println("Title is "+page.title());
		
		
		//single element
		Locator sso = page.locator("text = Login");
		sso.click();
		Thread.sleep(5000);
		
		page.close();
		browser.close();
		playwright.close();
		System.out.println("Playwright closed");
		
	}

}

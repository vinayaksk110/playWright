package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomSelector {
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		//Page --> DOM --> Shadow DOM --> Elements
		//Page --> DOM --> iFrame --> Shadow DOM --> Elements
		
		//#shadow-root (Open)
//		page.navigate("https://selectorshub.com/xpath-practice-page/");
//		page.locator("div#userName input#pizza").fill("Vinayak");
//		String text = page.locator("div#userName div#concepts").textContent();
//		System.out.println(text);
//		if(text.equalsIgnoreCase("Concept Test")){
//			System.out.println("Test passed");
//		}
//		
		page.navigate("https://selectorshub.com/shadow-dom-in-iFrame/");
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");
	}

}

package playwright.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {
	
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		
		
//		page.navigate("https://");
//		String text = page.locator("button:visible").textContent();
//		String text1 = page.locator("button >> visible=true").textContent();
//		System.out.println(text);
//		System.out.println(text1);
		
		page.navigate("https://www.amazon.com/");
		Thread.sleep(10000);
		List<String> texts = page.locator("a:visible").allInnerTexts();
		for(int i=0;i<texts.size();i++) {
			System.out.println(i+" >>"+texts.get(i));
		}
		
		System.out.println(page.locator("xpath=//img >> visible=true").count());
		
	}

}

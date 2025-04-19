package LaunchBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchWebkitBrowserUI {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		lp.setHeadless(false);

		Browser browser = playwright.webkit().launch(lp);

		Page page = browser.newPage();
		
		page.navigate("https://www.idrive.com/idrive/login/loginForm");
		String title = page.title();
		System.out.println("Title is " + title);
		
		browser.close();
		playwright.close();
	}

}

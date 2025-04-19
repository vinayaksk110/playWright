package LaunchBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchMSEdgeBrowserHeadless {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		LaunchOptions lp = new LaunchOptions();
		// to open actual chrome instead of chromium use below line
		lp.setChannel("msedge");

		Browser browser = playwright.chromium().launch(lp);

		Page page = browser.newPage();

		page.navigate("https://www.idrive.com/idrive/login/loginForm");
		String title = page.title();
		System.out.println("Title is " + title);

		browser.close();
		playwright.close();
	}

}

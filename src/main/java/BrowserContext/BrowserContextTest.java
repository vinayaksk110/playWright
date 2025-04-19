package BrowserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextTest {
	
	//multiple browsers with one browser class parallelly running

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext br2 = browser.newContext();
		Page p2 = br2.newPage();
		p2.navigate("https://www.idrive360.com/enterprise/signup");
		Thread.sleep(5000);
		System.out.println(p2.title());

		BrowserContext br1 = browser.newContext();
		Page p1 = br1.newPage();
		p1.navigate("https://www.idrive.com/idrive/login/loginForm");
		System.out.println(p1.title());

		br1.close();
		br2.close();
		browser.close();
		playwright.close();

	}

}

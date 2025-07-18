package loginScript;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginToIdrive360 {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext brcontext = browser.newContext();
		Page page = brcontext.newPage();

		page.navigate("https://www.idrive360.com/enterprise/login");
		page.fill("#username", "vinayak.kumbar+whitelabel@idrive.com");
		page.fill("#password", "test12");
		Thread.sleep(2000);
		page.click("#frm-btn");

		brcontext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("applogin.json")));

//		browser.close();
//		playwright.close();

	}
}

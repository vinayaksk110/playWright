package LaunchBrowser;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class maximizeBrowser {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting browser");

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		System.out.println(width + "," + height);

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

//		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = browserContext.newPage();
		page.navigate("https://www.idrive360.com/enterprise/login");
		Thread.sleep(5000);

		browser.close();
		playwright.close();

	}

}

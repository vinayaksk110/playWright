package launchBrowser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {

	public static void main(String[] args) {
		// Playwright is a interface
		try (Playwright playwright = Playwright.create()) {
			// The setHeadless(false) option specifies that the browser should be launched
			// in a headful mode, meaning you will be able to see the browser window.
			// This creates a new browser page (or tab).

			// headless mode
//			Browser browser = playwright.chromium().launch();

			// Head mode
//			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			// Use Webkit to test mac safari in windows machine
//			Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));

			// With launch options
			LaunchOptions lp = new LaunchOptions();
			lp.setHeadless(false);
			// to open actual chrome instea of chromium use below line
			lp.setChannel("chrome");
			// edge browser uses chromium
//			lp.setChannel("msedge");
			// firefox browser
//			lp.setChannel("firefox");

			Browser browser = playwright.chromium().launch(lp);
//			Browser browser = playwright.firefox().launch(lp);

//			Each BrowserContext can have multiple pages. A Page refers to a single tab or a popup window 
//			within a browser context. It should be used to navigate to URLs and interact with the page content.
			Page page = browser.newPage();

			page.navigate("https://www.idrive.com/idrive/login/loginForm");
			String title = page.title();
			System.out.println("Title is " + title);

			String url = page.url();
			System.out.println("Title is " + url);

			// close the browser and playwright server
			browser.close();
			System.out.println("browser closed");
			playwright.close();
			System.out.println("Playwright closed");
		}
	}

}

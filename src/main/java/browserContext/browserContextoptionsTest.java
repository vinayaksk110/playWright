package browserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ColorScheme;

public class browserContextoptionsTest {
	static Playwright pw = null;
	static Browser browser = null;
	static BrowserContext context = null;

	public static void main(String[] args) {
		pw = Playwright.create();
		browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// denmark language
//		denmarkDarkScheme();

		// denmark language
		denmarkLightScheme();

		Page page = context.newPage();
		page.navigate("https://www.google.co.in/");
		System.out.println(page.title());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();

	}

	public static void denmarkDarkScheme() {
		context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)
				.setColorScheme(ColorScheme.DARK).setLocale("de-DE"));
	}

	public static void denmarkLightScheme() {
		context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080)
				.setColorScheme(ColorScheme.LIGHT).setLocale("en-IN"));
	}

}

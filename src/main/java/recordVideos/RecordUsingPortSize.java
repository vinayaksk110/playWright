package recordVideos;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class RecordUsingPortSize {

	public static void main(String[] args) {

		Playwright pw = Playwright.create();
		Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext brContext = browser.newContext(new Browser.NewContextOptions()
				.setRecordVideoDir(Paths.get("C:\\Users\\vinay\\Downloads\\")).setRecordVideoSize(1920, 980)); // desired
																												// video
																												// size.
		// video clarity will be reduced when we give lower resolution size

		Page page = brContext.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");

		page.click("text=MacBook");

		page.click("'Add to Cart'");

		page.click("'Shopping Cart'");

		page.locator("#content").allInnerTexts().forEach(e -> System.out.println(e));

		// Saved video files will appear in the specified folder. They all have
		// generated unique names.
		// For the multi-page scenarios, you can access the video file associated with
		// the page via the Page.video()
		System.out.println("path to video is: " + page.video().path().toString());

		page.close();
		brContext.close();
		browser.close();
	}

}

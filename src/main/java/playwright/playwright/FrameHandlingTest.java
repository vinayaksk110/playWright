package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandlingTest {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();

//		//incase of locator use this
//		page.navigate("https://demoqa.com/frames");
//		String content = page.frameLocator("#frame1").locator("h1").textContent();
//		System.out.println(content);

//		// frame locator using name
//		page.navigate("https://www.londonfreelance.org/courses/frames/");
//		String frameText = page.frame("main").locator("h2").textContent();
//		System.out.println(frameText);

		page.navigate("https://www.idrive.com/idrive/signup");
		page.frameLocator("//iFrame[contains(@name,'__privateStripeFrame') and (@title='Secure card payment input frame')]")
				.locator("input.InputElement is-empty Input Input--empty").fill("4111");

	}
}

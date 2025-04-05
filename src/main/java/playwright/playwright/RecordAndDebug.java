package playwright.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class RecordAndDebug {

	public static void main(String[] args) {
		// run the following code in cmd of project to get inspector mode

//		mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://www.idrive.com/idrive/login/loginForm"

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			// To start in debug mode
			BrowserContext context = browser.newContext();

			// Debug start
			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

			// Open new page
			Page page = context.newPage();
			
			//page.pause to stop code while debugging
			
			page.navigate("https://www.idrive.com/idrive/login/loginForm");
			page.pause();

			// Debug end
			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
		}
	}

}

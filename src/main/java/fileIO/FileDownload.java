package fileIO;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_win32.zip')");
		});
		
//		// download.cancel();
//		System.out.println(download.failure());

		System.out.println(download.url());
		System.out.println(download.page().title());

		String path = download.path().toString();
		System.out.println("Downloaded file path is:"+path);

		download.saveAs(Paths.get("C:\\Users\\vinay\\Downloads\\file.zip"));
		System.out.println(download.suggestedFilename());// chromedriver_mac64.zip
		
		//cancel the download
		//download.cancel(); 
		
		//to know failure
		//download.failure();
	}
}

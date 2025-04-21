package fileIO;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MultipleFileUpload {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

		page.setInputFiles("input#filesToUpload",
				new Path[] { Paths.get("C:\\Users\\vinay\\Downloads\\FileIOPlaywright\\zip_2MB.zip"),
						Paths.get("C:\\Users\\vinay\\Downloads\\FileIOPlaywright\\file_example_CSV_5000.csv") });

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// deselecting files
		page.setInputFiles("input#filesToUpload", new Path[0]);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

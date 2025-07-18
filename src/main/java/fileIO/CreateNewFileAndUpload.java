package fileIO;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class CreateNewFileAndUpload {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		// https://davidwalsh.name/demo/multiple-file-upload.php

		// run time file - upload:
		page.setInputFiles("input#filesToUpload",
				new FilePayload("Vinayak.txt", "text/plain",
						"this is Vinayak here".getBytes(StandardCharsets.UTF_8)));

	}

}

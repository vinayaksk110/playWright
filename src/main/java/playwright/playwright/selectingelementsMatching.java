package playwright.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class selectingelementsMatching {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();

		page.navigate("https://academy.naveenautomationlabs.com/");

//		//to find locators with , for or statement
//		page.locator("a:has-text('SignIn'), a:has-text('LogIn'), a:has-text('Signin')").click();
		
//		//multiple locators with , seperated css
//		Locator locators = page.locator("a:has-text('LogIn'), a:has-text('Courses')");
//		System.out.println(locators.count());
		
		//using xpath union
		Locator singin = page.locator("//a[text()='Login'] | //a[text()='LogIn']");
		System.out.println(singin.textContent());
		singin.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		browser.close();
		playwright.close();

	}

}

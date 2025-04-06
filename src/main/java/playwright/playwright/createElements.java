package playwright.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class createElements {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting browser");
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// locators
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://www.orangehrm.com/en/book-a-free-demo");
		System.out.println("Title is " + page.title());

//		// single element
//		Locator sso = page.locator("text = Login");
//		sso.click();
//		Thread.sleep(5000);

		// multiple elements
		Locator countryOptions = page.locator("select#Form_getForm_Country option");
		System.out.println(countryOptions.count());

//		for(int i=0;i<countryOptions.count();i++) {
//			String country = countryOptions.nth(i).textContent();
//			System.out.println(country);
//		}

//		//easy
//		List<String> countrylists = countryOptions.allTextContents();
//		
//		for(String e:countrylists) {
//			System.out.println(e);
//		}

		List<String> countrylists = countryOptions.allTextContents();
		countrylists.forEach(ele -> System.out.println(ele));

		page.close();
		browser.close();
		playwright.close();
		System.out.println("Playwright closed");

	}

}

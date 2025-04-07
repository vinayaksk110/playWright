package playwright.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelectorTest {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting browser");
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// text locators
		//use for link texts
		Page page = browser.newPage();
//		page.navigate("https://demoqa.com/links");
//		Locator created = page.locator("text=Created");
//		created.click();
//		System.out.println("Created clicked");
//		
//		Locator moved = page.locator("text=Moved");
//		moved.click();
//		System.out.println("moved clicked");
		
		
		//multiple texts with same text
//		page.navigate("https://www.orangehrm.com/en/book-a-free-demo");
//		page.locator("text= Privacy Policy").first().click();
		
//		//list all the links available
//		page.navigate("https://www.orangehrm.com/en/book-a-free-demo");
//		Locator links = page.locator("text= Privacy Policy");
//		
//		List<String> alllinks = links.allTextContents(); 
//		
//		for(String link:alllinks) {
//			System.out.println(link);
//		}
//		//different method
//		for(int i=0;i<links.count();i++) {
//			String text = links.nth(i).textContent();
//			System.out.println(text);
//			if(text.contains("Service Privacy Policy")) {
//				links.nth(i).click();
//				break;
//			}
//		}
		
//		// has text content which is inside a tag
//		page.navigate("https://demoqa.com/elements");
//		String header = page.locator("li:has-text('Text Box')").textContent();
//		System.out.println(header);
		
		//use without text=
		//use '' single quotes to add your content or it will not detect
		page.navigate("https://demoqa.com/links");
		String loc = page.locator("'No Content'").textContent();
		System.out.println(loc);
	}

}

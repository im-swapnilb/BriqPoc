package briqPoc.briqPoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebScraper {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		UIAutomation();
	}
	
	public static boolean UIAutomation() throws InterruptedException {
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver", "D:/briqTest/briqPoc/chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://www.bizjournals.com/milwaukee/feature/crane-watch");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//#milwaukee_7663_layer > image:nth-child(210) -- css selector
		
		driver.close();
		return true;
	}

}

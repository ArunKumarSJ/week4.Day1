package Week4.Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev113545.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame1 = driver.findElementByXPath("//div[@class='navpage-main-left ng-isolate-scope']/iframe");
		driver.switchTo().frame(frame1);
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementByName("user_password").sendKeys("w6hnF2FRhwLC");
		driver.findElementById("sysverb_login").click();
		// Thread.sleep(20000);
		WebElement filter = driver.findElementById("filter");
		filter.sendKeys("incident");
		Thread.sleep(20000);
		filter.sendKeys(Keys.ENTER);
		driver.findElementByXPath("(//div[text()='All'])[2]").click();
		// Thread.sleep(20000);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		driver.switchTo().defaultContent();
		// Thread.sleep(20000);
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//input[@name='incident.short_description']").sendKeys("AutoMation Testing");
		String text = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(text);
		driver.findElementById("lookup.incident.caller_id").click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		driver.findElementByXPath("(//a[@role='button'])[7]").click();
		Thread.sleep(50000);
		driver.switchTo().window(windowHandlesList.get(0));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElementByXPath("//div[@enable-extensions='false']/iframe");
		driver.switchTo().frame(frame2);
		WebElement search1 = driver.findElementByXPath("(//input[@class='form-control'])");
		search1.sendKeys(text);
		search1.sendKeys(Keys.ENTER);
		String text2 = driver.findElementByXPath("(//td[@class='vt'])[1]").getText();
		if(text.contains(text2)) {
			System.out.println("SERVICE IS CREATED");
		}

	}

}

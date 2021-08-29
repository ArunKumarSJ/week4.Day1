package Week4.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("frame1");
		driver.findElementByXPath("//input[@type='text']").sendKeys("NOT A FRIENDLY TOPIC");
		driver.switchTo().frame("frame3");
		driver.findElementByXPath("//input[@type='checkbox']").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement List = driver.findElementById("animals");
		Select dropdwn1=new Select(List);
		dropdwn1.selectByIndex(1);
	}

}

package Week4.Day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File src1 = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/seat.png");
		FileUtils.copyFile(src1, dst);
		WebElement frame1 = driver.findElementByXPath("(//div[@id='wrapframe'])[1]/iframe");
		driver.switchTo().frame(frame1);
		WebElement click = driver.findElementById("Click");
		File src2 = click.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./snaps/seat1.png");
		FileUtils.copyFile(src2, dst1);
		driver.switchTo().defaultContent();
		List<WebElement> ListofFrame = driver.findElements(By.tagName("iframe"));
		int size = ListofFrame.size();
		System.out.println("THE NUMBER OF FRAMES IN THE PAGE:"+size);
	}

}

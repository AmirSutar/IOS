package Home;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IphoneCheckout {

	@Test

	public void CheckOutTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		SoftAssert softassert = new SoftAssert();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();

		WebElement search = driver
				.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));

		search.sendKeys("Iphone");
		Thread.sleep(3000);

		search.sendKeys(Keys.ARROW_DOWN);

		driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();

		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[3]/div[2]/div/div[1]/div/label/div[1]"))
				.click();

		driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 (Black, 128 GB)']")).click();
		Set<String> WindoHandles = driver.getWindowHandles();
		System.out.println(WindoHandles);

		Iterator<String> iterator = WindoHandles.iterator();

		String parentwindow = iterator.next();
		// System.out.println(parentwindow);

		String childwindow = iterator.next();
		// System.out.println(childwindow);
		driver.switchTo().window(childwindow);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[2]/form/button"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id=\"container\"]/div/div[2]/div/div[1]/div[1]/div/div/div/div/div[1]/div/form/div[1]/input"))
				.sendKeys("9665688084");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		driver.close();
		driver.switchTo().window(parentwindow);
		Thread.sleep(500);
		driver.close();

	}
}

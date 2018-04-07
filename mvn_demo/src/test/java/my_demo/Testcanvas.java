package my_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcanvas {
	WebDriver driver;
	@BeforeClass
	private void setup(){
		System.out.println("��ʼ���в��Ե㣺");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	private void testhtml5canvas() throws InterruptedException{
		driver.get("http://literallycanvas.com/");
		WebElement canvas=
		driver.findElement(By.xpath(".//*[@id='literally-canvas']/div[1]/div[1]/canvas[2]"));
		Actions drawing =new Actions(driver);
		drawing.clickAndHold(canvas).moveByOffset(10, 50).
		moveByOffset(50, 10).moveByOffset(-10, -50).moveByOffset(-50, -10).release().perform();	
		Thread.sleep(3000);
	}
	
	@AfterClass
	private void quit(){
		driver.quit();
	}
}

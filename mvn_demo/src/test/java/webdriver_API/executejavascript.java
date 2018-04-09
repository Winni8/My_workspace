package webdriver_API;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class executejavascript {
	private WebDriver driver;
	String baseurl;

	@BeforeClass(enabled = true)
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "E:\\java_自动化\\workspace\\mvn_demo\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		baseurl = "http://www.sogou.com";
		driver.get(baseurl);
	}

	@Test
	public void executejavascript_test() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		String title =(String) js.executeScript("retuan document.title");
			System.out.println(title);	
		String cut_title = driver.getTitle();
		
		System.out.println(cut_title);
		if(title.equals(cut_title)){
			System.out.println("ok");
		}
		
		//Assert.assertEquals("", title);
		
		
	}
	
	@AfterClass
	public void quit_win(){
		driver.close();
	}
}



















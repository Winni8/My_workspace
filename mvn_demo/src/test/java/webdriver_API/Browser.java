package webdriver_API;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Browser {
	private WebDriver driver;
	String baseurl;

	@BeforeClass
	public void setup_breswer() {

		// 这种方式不知道为什么会有两个浏览器打开
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "driver/chromedriver.exe"); DesiredCapabilities capabilities =
		 * DesiredCapabilities.chrome();
		 * capabilities.setCapability("chrome.switches",
		 * Arrays.asList("--incognito")); ChromeOptions options = new
		 * ChromeOptions(); options.addArguments("--test-type");
		 * capabilities.setCapability("chrome.binary",
		 * "driver/chromedriver.exe");
		 * capabilities.setCapability(ChromeOptions.CAPABILITY, options); driver
		 * = new ChromeDriver(capabilities);
		 */

		System.setProperty("webdriver.chrome.driver", "E:\\java_自动化\\workspace\\mvn_demo\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		baseurl = "http://www.sogou.com";
		driver.get(baseurl);

	}

	@Test(priority = 1)
	public void operateBrowser() {
		Point point = new Point(500, 500);

		Dimension dimension = new Dimension(700, 500);
		// dimension的表示point對象的坐標；
		driver.manage().window().setPosition(point);
		// 浏览器的大小
		driver.manage().window().setSize(dimension);
		// 浏览器在屏幕上的位置；
		System.out.println(driver.manage().window().getPosition());
		// 浏览器的大小
		System.out.println(driver.manage().window().getSize());

		driver.manage().window().maximize();
		System.out.println(driver.manage().window().getSize());
		// 有原来url sogou跳转到百度；
		driver.navigate().to("http://baidu.com");

		driver.navigate().back();
	}

	@Test(priority = 2)
	public void get_Title() {

		String title = driver.getTitle();
		System.out.println(title);
		// 断言
		Assert.assertEquals("搜狗搜索引擎 - 上网从搜狗开始", title);
		System.out.println("cjj");
	}

	@Test(priority = 3,enabled=false)
	public void get_pagesource() {
		String pagesource = driver.getPageSource();
		System.out.println(pagesource);

	}

	@Test(priority = 4)
	public void get_url() {
		String currenturl = driver.getCurrentUrl();
		System.out.println("当前的url= " + currenturl);
		if (currenturl.equals("https://www.sogou.com/")) {
			System.out.println("跳转OK");
		} else {
			System.out.println("跳转出错");
		}
	}
	
	@Test(priority = 5)
	public void sendtext(){
		String input_text= "测试工程师";
		WebElement  input =driver.findElement(By.id("query"));
		input.clear();
		input.sendKeys(input_text);
		
		driver.findElement(By.id("stb")).click();
		
		try{
			Thread.sleep(5000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5)
	public void 
	
	
	
	
	
	
	
	
	
	
	
	

	@AfterClass
	public void quit_broswer() {
		driver.close();
	}
}












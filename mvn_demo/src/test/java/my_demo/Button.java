package my_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Button {
	private WebDriver driver;
	private String baseUrl;
	private String baseUrl1;
	private String e_mail = "2694571567@qq.com";
	private String password = "123456";

	@BeforeClass
	public void Setup() {
		System.out.println("��ʼ���в��Ե㣺");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://login.rosewholesale.com.b.s1.egomsl.com/m-users-a-sign.htm";
		baseUrl1 = "";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Login() {
		driver.get(baseUrl);
		RW_Login.Login(driver, e_mail, password);
	}

	@Test(priority = 2)
	public void getwish() {
		List<WebElement> rows = driver.findElements(By.cssSelector(".nav-ul>li"));

		System.out.println(rows);
		for (int i = 1; i < rows.size(); i++) {
			String list = rows.get(i).getText();
			System.out.println(list);
		}
	}

	@Test(priority = 3)
	public void ff() {
		driver.findElement(By.xpath("//*[@id='nav']/div/ul/li[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='js_proList']/ul/li[1]/h3/a")).click();
	}

	@AfterClass
	public void quit() {

		driver.quit();
	}
}

package my_demo;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dfgdg {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://twinkledeals.com.b.s1.egomsl.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testDfgdg() throws Exception {
		driver.get(baseUrl + "/login");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		
		driver.findElement(By.xpath(".//*[@id='signinform']/div[3]/button")).click();
		driver.findElement(By.id("js_index_page")).click();
		driver.findElement(By.linkText("LOG IN")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("2694571567@qq.com");
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys("123456");
		driver.findElement(By.id("code")).clear();
		driver.findElement(By.id("code")).sendKeys("yxidgu");
		driver.findElement(By.cssSelector("button.redBtn.js-addRef")).click();
		driver.findElement(By.cssSelector("img[alt=\"twinkledeals\"]")).click();
		driver.findElement(By.linkText("JEWELRY")).click();
		driver.findElement(By.linkText("$ Low to High")).click();
		driver.findElement(By.linkText("Bird Shape Hollow Out Tattoo Choker - Black")).click();
		driver.findElement(By.id("new_addcart")).click();
		driver.findElement(By.cssSelector("a.checkOutBtn.redBtn > span")).click();
		driver.findElement(By.id("insurance_checked")).click();
		driver.findElement(By.id("placeOrderBtn")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Egrow%$167168");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("confirmButtonTop")).click();
		driver.findElement(By.linkText("My Orders")).click();
		driver.findElement(By.linkText("T Points")).click();
		driver.findElement(By.cssSelector("ul.userNavBox.clearfix > li > a")).click();
		driver.findElement(By.linkText("T1802240245522091")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		//driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}

package webdriver_API;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Kill_window {
	private WebDriver driver;
	String baseurl;

	@BeforeClass(enabled = true)
	public void setup() {

		System.setProperty("webdriver.gecko.driver", "E:\\java_自动化\\workspace\\mvn_demo\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		baseurl = "http://www.sogou.com";
		driver.get(baseurl);
	}

	@Test(enabled=false)
	public void Screen() {
		// WindowsUtils.tryToKillByName("firefox.exe");
		// driver.quit();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("E:\\Testing\\test.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void iselementtextpresent() {
		WebElement text =driver.findElement(By.xpath("//p[1]"));
		String content =text.getText();
		Assert.assertEquals("《光荣之路》 这个电影真的很棒！",content );
		Assert.assertTrue(content.contains("光荣之路"));
		
		Assert.assertTrue(content.startsWith("《光荣之"));
		Assert.assertTrue(content.endsWith("很棒！"));
		
	}

	@AfterClass
	public void exit_window() {
		driver.quit();
	}

}

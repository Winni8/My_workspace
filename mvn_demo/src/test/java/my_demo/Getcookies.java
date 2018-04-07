package my_demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Getcookies {
	WebDriver Driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void getcookies() {
		Driver.get("https://www.zhihu.com/signup?next=%2F");
		Driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div/div/div[2]/div[2]/span")).click();
		
		Driver.findElement(By.name("username")).sendKeys("17620443750");
		Driver.findElement(By.name("password")).sendKeys("135507ftky");
		
		Driver.findElement(By.xpath(".//*[@id='root']/div/main/div/div/div/div[2]/div[1]/form/button")).click();

		File cookieFile = new File("zhihu.cookie.txt");
		try {
			cookieFile.delete();
			cookieFile.createNewFile();
			FileWriter fileWriter = new FileWriter(cookieFile);
			BufferedWriter bufferedwriter = new BufferedWriter(fileWriter);
			for (Cookie cookie : Driver.manage().getCookies()) {
				bufferedwriter.write(cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";"
						+ cookie.getPath() + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
				bufferedwriter.newLine();
			}
			bufferedwriter.flush();
			bufferedwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void quit() {
		Driver.quit();
	}
}
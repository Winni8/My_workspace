package my_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testisenabled {
	public static void main(String[] args) {
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Driver.get("https://www.baidu.com/");
		
		if(Driver.findElement(By.id("kw")).isEnabled() ){
			System.out.println("�ɱ༭");
			Driver.findElement(By.id("kw")).sendKeys("�༭");
		}else{
			System.out.println("���ɱ༭");
		}
		
		Driver.quit();
	}
}
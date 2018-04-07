package my_demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testpageobject {
	private WebDriver driver;

	@BeforeClass
	public void Setup() {
		System.out.println("��ʼ���в��Ե㣺");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Login() {
		driver.get("https://www.cnblogs.com/");
		driver.findElement(By.linkText("��¼")).click();
		driver.findElement(By.id("input1")).sendKeys("Winni8");
		driver.findElement(By.id("input2")).sendKeys("adc?123456");
		driver.findElement(By.id("signin")).click();
	}

	@Test(priority = 2)
	public void Messeage() {
		driver.findElement(By.partialLinkText("����Ϣ")).click();
		driver.findElement(By.linkText("׫д�¶���Ϣ")).click();
		driver.findElement(By.id("txtIncept")).sendKeys("person1");
		driver.findElement(By.id("txtTitle")).sendKeys("testpage");
		driver.findElement(By.id("txtContent")).sendKeys("����1");
		driver.findElement(By.id("btnSend")).click();

		driver.findElement(By.linkText("׫д�¶���Ϣ")).click();
		driver.findElement(By.id("txtIncept")).sendKeys("person2");
		driver.findElement(By.id("txtTitle")).sendKeys("testpagefsf");
		driver.findElement(By.id("txtContent")).sendKeys("����2");
		driver.findElement(By.id("btnSend")).click();
	}

	@Test(priority = 3)
	public void logout() throws InterruptedException{
		driver.findElement(By.linkText("�˳�")).click();
		Alert logoutPropt =driver.switchTo().alert();
		Thread.sleep(3000);
		logoutPropt.accept();	
	}
	
	@Test(priority = 4)
	public void Login2() throws InterruptedException {
		driver.findElement(By.id("input1")).sendKeys("Winni8");
		driver.findElement(By.id("input2")).sendKeys("adc?123456");
		driver.findElement(By.id("signin")).click();
		Thread.sleep(4000);
	}
	@Test(priority = 5)
	public void Messeage2() {
		driver.findElement(By.partialLinkText("����Ϣ")).click();
		driver.findElement(By.linkText("׫д�¶���Ϣ")).click();
		driver.findElement(By.id("txtIncept")).sendKeys("person1");
		driver.findElement(By.id("txtTitle")).sendKeys("testpage");
		driver.findElement(By.id("txtContent")).sendKeys("����3");
		driver.findElement(By.id("btnSend")).click();

		driver.findElement(By.linkText("׫д�¶���Ϣ")).click();
		driver.findElement(By.id("txtIncept")).sendKeys("person2");
		driver.findElement(By.id("txtTitle")).sendKeys("testpagefsf");
		driver.findElement(By.id("txtContent")).sendKeys("����4");
		driver.findElement(By.id("btnSend")).click();
	}
	
	@Test(priority = 6)
	public void seall() throws InterruptedException{
		driver.findElement(By.id("lnk_outbox")).click();
		WebElement webElement= driver.findElement(By.id("chkSelAll"));
		if(!webElement.isSelected()){
			webElement.click();
		}
		Thread.sleep(3000);
		
		driver.findElement(By.id("btnBatDel")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[4]/div/div/nav/button[2]")).click();
		
	}
	
	@AfterClass
	public void qiut(){
		driver.quit();
	}
	
	
}
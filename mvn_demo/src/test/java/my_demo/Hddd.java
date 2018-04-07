package my_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Hddd {
	/** ��־������� */
	private WebDriver driver;
	String baseUrl;

	@BeforeClass
	public void Setup() {
		System.out.println("��ʼ���в��Ե㣺");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://mfk4.fangyitongsoft.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get(baseUrl);
		WebElement usernameWebEle = driver.findElement(By.xpath("//input[@name='username']"));
		usernameWebEle.sendKeys("yewenli");

		WebElement passwordWebEle = driver.findElement(By.xpath("//input[@name='password']"));
		passwordWebEle.sendKeys("123456");

		WebElement verifyWebEle = driver.findElement(By.xpath("//input[@name='verifyCode']"));
		verifyWebEle.sendKeys("wannengyanzhengma");

		WebElement btnWebEle = driver.findElement(By.xpath("//button"));
		btnWebEle.click();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void benin() throws InterruptedException {
		String js = "document.getElementsByClassName('newnav-menu-box')[0].style.display='block';";
		((JavascriptExecutor) driver).executeScript(js);
		driver.findElement(By.id("02")).click();
		Thread.sleep(1000);
		// driver.get(baseUrl + "/sellhouse/sellhouseList.html?modulecode=02");
		Set<String> winHandels = driver.getWindowHandles(); // �õ���ǰ���ڵ�set����
		List<String> it = new ArrayList<String>(winHandels); // ��set���ϴ���list����
		driver.switchTo().window(it.get(1)); // �л����������´���
		Thread.sleep(1000);
		String url = driver.getCurrentUrl(); // ��ȡ�´��ڵ�url
		System.out.println("�´��ڵĵ�ַ��" + url);
		// driver.close();
		// driver.findElement(By.linkText("��ѯ")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void Fangyuan() throws InterruptedException {
		driver.findElement(By.linkText("������Դ")).click();
		driver.findElement(By.id("addHouse")).click();
		System.out.println("1�� "+driver.getTitle());
		// ��λiframe
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='layui-layer-iframe2']"));
		driver.switchTo().frame(iframe);
		
		// ����iframe
		// driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		// driver.findElement(By.xpath("//div[@id='estateid_chosen']/div/ul/li[1]")).click();
		// String es =
		// "document.getElementById('estateid')[0].style.display='block';";
		// ((JavascriptExecutor)driver).executeScript(es);
	}

	@Test(priority = 4)
	public void xuanloupan() {
		String alljs = "document.querySelectorAll('select')[0].style.display='block';";
		((JavascriptExecutor) driver).executeScript(alljs);
		// Select sel = new Select(driver.findElement(By.id("estateid")));
		
//		WebElement s = driver.findElement(By.xpath("//select[@id='estateid']/option[1]"));
//		if (s.isDisplayed()) {
//			System.out.println("Ԫ���Ƿ�����ʾ");
//		}
//		s.click();
//		
		driver.findElement(By.xpath(".//*[@id='estateid_chosen']/a")).click();
		driver.findElement(By.xpath(".//*[@id='estateid_chosen']/div/ul/li[3]")).click();
		

//		Select sel = new Select(driver.findElement(By.xpath("//select[@id='estateid']")));
//		List<WebElement> estateids = sel.getOptions();
//		for (WebElement webElement : estateids) {
//			System.out.println(webElement.getText());
//		}
	}

	@Test(priority = 5)
	public void Last() {
		// sel.selectByIndex(1);
		// driver.findElement(By.id("estateid")).click();
		driver.findElement(By.xpath(".//*[@id='s2id_buildingid']/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li[2]/div")).click();
		System.out.println("��֮ǰok");
		
		driver.findElement(By.id("roomno")).clear();
		driver.findElement(By.id("roomno")).sendKeys("0101");
		driver.findElement(By.id("countt")).clear();
		driver.findElement(By.id("countt")).sendKeys("1");
		driver.findElement(By.id("countw")).click();
		driver.findElement(By.id("countw")).clear();
		driver.findElement(By.id("countw")).sendKeys("1");
		driver.findElement(By.id("county")).clear();
		driver.findElement(By.id("county")).sendKeys("1");
		driver.findElement(By.id("square")).clear();
		driver.findElement(By.id("square")).sendKeys("222");
		driver.findElement(By.id("squareuser")).clear();
		driver.findElement(By.id("squareuser")).sendKeys("222");
		driver.findElement(By.id("sellprice")).clear();
		driver.findElement(By.id("sellprice")).sendKeys("2222");
		driver.findElement(By.id("propertydirction")).click();
		driver.findElement(By.name("propertydecoration")).click();
		driver.findElement(By.name("tradestatus")).click();
		driver.findElement(By.name("propertysource")).click();
		driver.findElement(By.name("privy")).click();
		driver.findElement(By.name("sellpropertybuy")).click();
		driver.findElement(By.name("sellHouseinfoVO.sellpropertycommiss")).click();
		driver.findElement(By.name("owername")).clear();
		driver.findElement(By.name("owername")).sendKeys("ad");
		driver.findElement(By.name("ownemobile")).clear();
		driver.findElement(By.name("ownemobile")).sendKeys("13011001520");
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// null | ]]
		driver.findElement(By.linkText("����")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectFrame |
		// layui-layer-iframe4 | ]]
		driver.findElement(By.id("countf")).click();
		driver.findElement(By.id("countf")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// null | ]]
		driver.findElement(By.linkText("����")).click();
		driver.findElement(By.linkText("��ѯ")).click();
	}

	@AfterClass()
	public void Quit() {
		 driver.quit();

	}

}

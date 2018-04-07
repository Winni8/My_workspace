package my_demo;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day5 {
	private WebDriver Driver;

	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeFirefox() {
		// Driver.close();
		// Driver.quit();
	}

	@Test(priority = 1)
	public void goTo() {
		// �ļ�·����
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	// ģ����������alert��ȷ����
	@Test(priority = 2)
	public void testAlert() throws InterruptedException {
		WebElement element = Driver.findElement(By.className("alert"));
		// element.click();
		Actions action = new Actions(Driver);
		action.click(element).perform();
		// ��ȡ��ǰ������alert��
		Alert alert = Driver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		/// ģ����alertȷ�ϰ�ť
		alert.accept();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void testAction() throws InterruptedException {
		WebElement element = Driver.findElement(By.className("over"));
		Actions action = new Actions(Driver);
		// ������ƶ���Action�İ�ť����
		action.moveToElement(element).perform();
		Thread.sleep(3000);
		// �������ƶ���action��ť�������ʾ�����֡�
		System.out.println(Driver.findElement(By.id("over")).getText());

	}

	// �ϴ�
	@Test(priority = 4)
	public void testUpload() throws InterruptedException {
		WebElement element = Driver.findElement(By.id("load"));
		element.sendKeys("C:\\Users\\chenjingjian\\Deskto\\TD-ALL-�������ƺ�̨���ù��ܲ�������");
		Thread.sleep(3000);
	}

	// ����һ��js
	public void testJs() {
		JavascriptExecutor javascript = (JavascriptExecutor) Driver;
		javascript.executeScript("alert('��ã�')");

	}

	// ��iframe��Ԫ�صĲ���,ע�⻹û�лص�Ĭ�ϵ�iframe��
	@Test(priority = 5)
	public void testIframe() throws InterruptedException {
		Driver.findElement(By.id("user")).sendKeys("my test");
		// �л�ifame
		WebElement element = Driver.findElement(By.name("aa"));
		Driver.switchTo().frame(element);

		Driver.findElement(By.id("user")).sendKeys("iframe test");
		//*************************************
		//����Ĭ�ϵ�iframe��
	    Driver.switchTo().defaultContent();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver.findElement(By.id("user")).sendKeys("my end test");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����Ĭ�ϵ�iframe��
		//Driver.switchTo().defaultContent();
		// �Զ�����ڽ����л�����

		WebElement element2 = Driver.findElement(By.className("open"));
		element2.click();
		Set<String> handles = Driver.getWindowHandles();
		System.out.println("�ܾ��������"+handles.size());
		
		String handle = Driver.getWindowHandle(); // �õ�Ĭ�����������	
		System.out.println("Ĭ�ϴ��ھ��:"+handle);
		
		handles.remove(handle);
		if(handles.size()>0){
			try{
				Driver.switchTo().window(handles.iterator().next());
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		String handle2= Driver.getWindowHandle();
		System.out.println("�л�����֮��ľ����"+handle2);
		
		// �����ٶȣ�ݔ��myString
		Driver.findElement(By.id("kw")).sendKeys("myString");
		Thread.sleep(3000);

		// �ص��ʼ�Ĵ���
		Driver.switchTo().window(handle);
		
		String handle1 = Driver.getWindowHandle();
		System.out.println("����Ĭ�ϴ���֮��ľ����"+handle1);
		//�Ҷ�û�з���Ĭ��iframe����ô���ܵ�Ĭ��iframe������ˣ�����
		
		if(handle.equals(handle1)){
			System.out.println("˵����ͬһ���ڣ�");
		}else{
			System.out.println("false");
		}
		
		Driver.findElement(By.id("user")).sendKeys("new test");

	}

	// ��ȡ��ʱ��Ϣ�������ڲ���ajax���󷵻ص���Ϣ
	@Test(priority = 7)
	public void testWait() {
		WebElement element = Driver.findElement(By.className("wait"));
		element.click();
		// ����1 ��Thread.sleep��������10�룬ֻ��10�����ܻ�ȡ���ݡ�
		// try {
		// Thread.sleep(6000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// Driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		// ����2 ��WebDriverWait��������10�� �������5��ͷ��صĻ���5����ܻ�ȡ������
		boolean wait = new WebDriverWait(Driver, 10).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.findElement(By.className("red")).isDisplayed();
			}
		});

		print(String.valueOf(wait));
		WebElement elementRed = Driver.findElement(By.className("red"));
		String str = elementRed.getText();
		print(str);

	}

	public void print(String str) {
		System.out.println(str);

	}
}
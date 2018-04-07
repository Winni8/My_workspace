package my_demo;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testhandle {

	private WebDriver Driver;

	@BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	@AfterClass
	public void closeFirefox() {
		//Driver.quit();
	}
	
	@Test
	public void testIframe() throws InterruptedException {
		Driver.findElement(By.id("user")).sendKeys("my test");
		// �л�ifame
		WebElement element = Driver.findElement(By.name("aa"));
		Driver.switchTo().frame(element);

		Driver.findElement(By.id("user")).sendKeys("iframe test");
		//*************************************
		//����Ĭ�ϵ�iframe��ע��Ӧ�������ˣ�
		//Driver.switchTo().defaultContent();
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
		//Driver.findElement(By.id("kw")).sendKeys("myString");
		Thread.sleep(3000);

		// �ص��ʼ�Ĵ���
		Driver.switchTo().window(handle);
		
		String handle1 = Driver.getWindowHandle();
		System.out.println("����Ĭ�ϴ���֮��ľ����"+handle1);
		//�Ҷ�û�з���Ĭ��iframe����ô���ܵ�Ĭ��iframe������ˣ�����,********************
		
		
		if(handle.equals(handle1)){
			System.out.println("˵����ͬһ���ڣ�");
		}else{
			System.out.println("false");
		}
		//�ٴ��е�iframeȥ
		Driver.switchTo().frame(element);
		Driver.findElement(By.id("user")).sendKeys("new test");

	}
}

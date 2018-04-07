package my_demo;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class day4 {
	private WebDriver Driver;

	@BeforeClass
	public void startFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:/Program Files (x86)/Mozilla Firefox/geckodriver.exe");
		Driver = new FirefoxDriver();
		// ���
		// Driver.manage().window().maximize();
	}

	@AfterClass
	public void closeFirefox() {
		Driver.close();
		Driver.quit();
	}

	@Test(priority = 1)
	public void goTo() {
		// �ļ�·����
		File f = new File("\\Users\\chenjingjian\\Desktop\\demo.html");
		Driver.navigate().to(f.getAbsolutePath());
	}

	/**
	 * @author chenjingjian �����λ
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void testInput() throws InterruptedException {
		// �����ı���Ĳ�������ʹ��sendkeys������
		Driver.findElement(By.xpath("//*[@id='user']")).clear();
		Driver.findElement(By.xpath("//*[@id='user']")).sendKeys("���");
		Thread.sleep(3000);

	}

	/**
	 * @author chenjingjian ���Ӷ�λ
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3, enabled = false)
	public void testLink() {
		Driver.findElement(By.xpath("//a[@class='baidu']")).click();
	}

	/**
	 * @author chenjingjian ������λ
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 4)
	public void testOption() throws Exception {
		WebElement element = Driver.findElement(By.cssSelector("select[name='select']"));
		Select select = new Select(element);
		// select.selectByValue("audi");//����valueֵѡ����
		// select.selectByIndex(1);//��������ֵ��
		// select.selectByVisibleText("Audi");//�����ܿ��������ݣ�
		System.out.println(select.getFirstSelectedOption().getText());
		List<WebElement> options = select.getOptions();
		int optionsSize = options.size();
		System.out.println("optionsһ���ж��ٸ���" + optionsSize);
		for (int i = 0; i < optionsSize; i++) {
			select.selectByIndex(i);
		}
		select.selectByIndex(2);
		Thread.sleep(3000);

	}

	/**
	 * @author chenjingjian ��ѡ��λ
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void testRadio() throws InterruptedException {
		// name��λ,����Ϊʲô��name��λ��
		List<WebElement> elements = Driver.findElements(By.name("identity"));
		WebElement el = elements.get(2);
		el.click();
		boolean isSelect = el.isSelected();
		System.out.println(isSelect);
		System.out.println("�Ƿ�ѡ�У�" + elements.get(3).isSelected());
		Thread.sleep(3000);
	}

	/**
	 * @author chenjingjian ��ѡ��λ
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void testCheckBox() throws InterruptedException {
		// xpath��λ
		List<WebElement> elements = Driver.findElements(By.xpath(".//div[@id='checkbox']/input"));
		elements.get(2).click();
		elements.get(0).click();
		elements.get(3).click();
		Thread.sleep(3000);
		// ��ʲô���ã�
		for (WebElement e : elements) {
			if (!e.isSelected()) {
				e.click();
			}
		}
	}

	/**
	 * @author chenjingjian
	 * @version 2.1
	 * @deprecated �ύ
	 *
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void testButton() {
		WebElement element = Driver.findElement(By.xpath(".//div[@id='alert']/input"));
		element.click();
	}

}
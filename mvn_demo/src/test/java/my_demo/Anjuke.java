package my_demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * 
 * sfsfsfsfsfswrwrwr
 * 
 */
public class Anjuke {
	public static void main(String[] args) {
		WebDriver Driver;
		System.setProperty("webdriver.chrome.driver",
				"E:\\java_自动化\\workspace\\mvn_demo\\driver\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.get("https://www.anjuke.com/calculator/return");
		//ѡ�񹫻������
		Driver.findElement(By.xpath("//*[@id='calleft']/div[1]/span[2]/input")).click();
//	    List<WebElement> ff= Driver.findElements(By.xpath(".//*[@id='calleft']/div[1]/span[1]"));
//	    System.out.println(ff.get(0).getText());
//	    ff.get(0).click();
//	    if( ff.get(0).isSelected()){
//	    	System.out.println("shi");
//	    }else{
//	    	System.out.println("bushi");
//	    }


		Driver.findElement(By.id("loanAmt")).clear();
		Driver.findElement(By.id("loanAmt")).sendKeys("150");
	/*
		Select year = new Select(Driver.findElement(By.id("loanTime")));
		year.selectByIndex(5);
		
		List<WebElement> year =Driver.findElements(By.xpath("//*[@style='height:32px;line-height:32px;']"));
		year.get(10);
		
		Select Firet_year = new Select(Driver.findElement(By.id("yearOne")));
		Firet_year.selectByIndex(0);

		Select Firet_month = new Select(Driver.findElement(By.id("monthOne")));
		Firet_month.selectByIndex(1);*/

		List<WebElement> list2 = Driver.findElements(By.xpath(".//*[@name='loanType']"));
		list2.get(1).click();
		
		System.out.println(list2.get(1).getTagName());
		if (list2.get(1).isSelected()) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}

		//Driver.quit();
	}
}

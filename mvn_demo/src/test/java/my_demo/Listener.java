package my_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;

 class Listener1 extends AbstractWebDriverEventListener {
	@Override
	public void afterNavigateTo(String url,WebDriver driver){
		System.out.println("after navigate to "+url);
	}
	
	@Override
	public void afterNavigateBack(WebDriver driver){
		System.out.println("after navigate back to "+driver.getCurrentUrl());
	}

	@Override
	public void afterClickOn(WebElement webElement,WebDriver driver){
		System.out.println("after click on "+webElement.getText());
	}	
}

public class Listener{
	public static void main(String[] args) {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		
		EventFiringWebDriver eventFiringWebDriver=new EventFiringWebDriver(driver);
		
		Listener1  mylistener =new Listener1();
		eventFiringWebDriver.register(mylistener);
		eventFiringWebDriver.get("https://www.google.com.hk/");
		eventFiringWebDriver.get("https://www.baidu.com/");
		
		eventFiringWebDriver.navigate().back();
		
		 WebElement webElement=eventFiringWebDriver.findElement(By.name("btnK"));
		 webElement.click();
		driver.quit();
	}
}

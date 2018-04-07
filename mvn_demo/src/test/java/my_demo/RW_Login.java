package my_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class RW_Login {
	public static void Login(WebDriver driver, String username, String password) {

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("passwordsign")).clear();
		driver.findElement(By.id("passwordsign")).sendKeys(password);
		driver.findElement(By.id("js_signInBtn")).click();
	}

	public static void Logout(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='header']/div/div[6]/a"))).perform();
		action.click(driver.findElement(By.linkText("Logout"))).perform();
	}
}

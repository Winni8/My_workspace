package my_demo;
//package my_demo;
//
//import java.sql.Driver;
//import java.util.Arrays;
//import java.util.List;
//
//import org.apache.commons.logging.Log;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.sun.corba.se.spi.orbutil.fsm.Action;
//
//import org.openqa.selenium.JavascriptExecutor;
//
//
//
//@SuppressWarnings("restriction")
//class postioningDemo {
//
//	WebDriver driver;
//	
//	@BeforeClass
//	public void beforeClass(){
//		
//		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe"); 		
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();  
//	    capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));  
//	    ChromeOptions options = new ChromeOptions();  
//	    options.addArguments("--test-type");  
//	    capabilities.setCapability("chrome.binary", "driver/chromedriver.exe");  
//	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);  
//	    driver = new ChromeDriver(capabilities);
//	    //driver.get("http://pdm.hqygou.com");//需要打开的网址
//	    driver.get("http://login.rosewholesale.com.trunk.s1.egomsl.com/m-users-a-sign.htm");
//	}
//	
//	@Test
//	public void baidu(){
//		/*logTest.logInfo("进来了");
//		driver.findElement(By.id("kw")).sendKeys("环球易购ss");
//	      testThreds(3);
//		driver.findElement(By.id("su")).click();*/
//		driver.findElement(By.id("email")).sendKeys("zhanghualing@globalegrow.com");
//		driver.findElement(By.id("passwordsign")).sendKeys("123456");
//		driver.findElement(By.id("js_signInBtn")).click();
//		
//		testThreds(3);
//	}
//	/**
//	 * 
//	* @测试点: search 
//	* @验证点: 演示内容
//	* @使用环境：     测试环境，正式环境
//	* @备注： void    
//	* @author zhangjun 
//	  @修改说明
//	 */
//	
//	//@Test
//	public void search(){
//		
//		logTest.logInfo("id的定位方式");
//         driver.findElement(By.id("username")).sendKeys("zhangjun1");;  
//         testThreds(3);
//		logTest.logInfo("name的定位方式");	
//		driver.findElement(By.name("password")).sendKeys("zhangjun1");
//		  testThreds(3);
//		logTest.logInfo("tagName的定位方式");
//		int count=driver.findElements(By.tagName("input")).size();
//	    logTest.logInfo("tagName总共有:"+count+"个");
//	    
//		logTest.logInfo("className的定位方式");
//		driver.findElement(By.className("login_tj_btn")).click();
//		
//		 testThreds(3);
//		logTest.logInfo("linkText的定位方式");
//		 testThreds(3);
//		WebElement  productMannager=driver.findElement(By.linkText("产品管理"));
//		Actions action=new Actions(driver);//		
//		action.moveToElement(productMannager).build().perform();
//		 //testThreds(10);
//		
//		logTest.logInfo("partialLinkText的定位方式");
//		WebElement  productAdd=driver.findElement(By.partialLinkText("添加产品"));
//		//Actions action=new Actions(driver);//	
//		action.moveToElement(productAdd).click().build().perform();;
//
//		logTest.logInfo("iframe定位");
//		driver.switchTo().frame("main_frame");
//		
//		logTest.logInfo("xpath的定位方式");
//		WebElement	 types = null;
//		try {
//			types=driver.findElement(By.xpath("//span[@class='radio-inline'][2]/label/input[@class='js_goods_type']"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		 if(types.isSelected()==false){
//			 logTest.logInfo("你没有被选择");
//			 types.click();
//		 }
//	   /* driver.switchTo().defaultContent();
//	    driver.findElement(By.cssSelector("#js_siteTitle > span:nth-child(9) > label"))*/
//		}
//	
//	
//	
//	public void testThreds(int number){
//		try {
//			Thread.sleep(number*1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	/**
//	 * 
//	* @测试点: PDM创建产品
//	* @验证点: TODO(这里用一句话描述这个方法的作用) 
//	* @使用环境：     测试环境，正式环境
//	* @备注： void    
//	* @author zhangjun 
//	  @修改说明
//	 */
//	
//	//@Test
//	public void APItest(){
//		logTest.logInfo("API的运用");	
//		driver.manage().window().maximize();//设置浏览器最大化
//		logTest.logInfo("获取的title:"+driver.getTitle());
//		logTest.logInfo("获取访问的url:"+driver.getCurrentUrl());
//		driver.switchTo().frame("main_frame");
//		//下拉框的选择
//		
//		Select selectset =new Select(driver.findElement(By.xpath("//select[@name='category[1]']")));
//		selectset.selectByVisibleText("消费电子类");//获取它的文本
//		try {
//			Thread.sleep(3);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		Select selectset2 =new Select(driver.findElement(By.xpath("//select[@name='category[2]']")));
//		selectset2.selectByIndex(1);//获取下拉框的索引
//		
//		//driver.findElement(By.xpath("//input[@name='label_code[]' and @value='000003']")).click();//产品标签
//		String  productNumber=driver.findElement(By.xpath("//input[@name='product_sn' and @class='form-control required']")).getText();//商品编号	
//	    logTest.logInfo("获取的商品编号为:"+productNumber);
//
//	   WebElement szware=driver.findElement(By.xpath("//input[@id='check_whcodeSZ'][@value='SZ']"));
//	   
//	   boolean  warehouse=szware.isSelected();//是否被选择
//	    if(warehouse==false){
//	    	szware.click();
//	    }
//	    
//	    driver.findElement(By.xpath("//input[@name='product_name']")).sendKeys("自动化测试脚本填写中文名称");;
//	    driver.findElement(By.xpath("//input[@name='title'][@class='form-control required']")).sendKeys("自动化测试脚本填写标题123");;
//	    driver.findElement(By.xpath("//input[@name='goods_name']")).sendKeys("自动化测试脚本填写产品型号");;
//
//		WebElement element = driver.findElement(By.xpath("//input[@name='supplier_name'][@id='js_productSupplier']"));
//		element.click();
//	
//		WebElement element2 = driver.findElement(By.xpath("//input[@name='supplier_name'][@id='js_productSupplier']"));
//		element2.sendKeys("11服饰(GZSSH0093)(wanglu)");	
//			
//		Actions action=new Actions(driver);
//		action.sendKeys(element2,Keys.ENTER).build().perform();
//		
//		//调研员
//		Select selectsetName =new Select(driver.findElement(By.xpath("//select[@name='researcher']")));
//		selectsetName.selectByIndex(2);
//		
//		driver.findElement(By.cssSelector("#js_upForm > div.box-footer.text-center > button")).click();//保存进入下一步
//		
//
//	}
//	
//	
//	
//	
//	
//	@AfterClass
//	public void  afterClass(){
//		//driver.quit();
//	}
//	
//}

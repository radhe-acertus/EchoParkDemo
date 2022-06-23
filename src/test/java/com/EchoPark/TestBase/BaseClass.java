package com.EchoPark.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;  //Log4j2
//import org.apache.logging.log4j.Logger;      //Log4j2
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	public Properties configPropObj;
	
	
	//public Logger logger=LogManager.getLogger(this.getClass());
	
	@BeforeClass   //To execute this method before class
	@Parameters({"browser"})
	public void setup(String Br) throws IOException, InterruptedException
	{
		
		//Loading config.properties file
		
		configPropObj= new Properties();
		FileInputStream configFile=new FileInputStream(System.getProperty("user.dir")+"//Resources//config.properties");
		System.out.println(configFile);
		configPropObj.load(configFile);
		
		if(Br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
			
			/*ChromeOptions options = new ChromeOptions();
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--headless");*/
			
			//ChromeOptions options = new ChromeOptions();
	        //options.setHeadless(true);
	        
	        //options.addArguments('--no-proxy-server');
	        //options.addArguments("--start-maximized");
	        //options.addArguments("--window-size=1200,800");

	        driver=new ChromeDriver(options);
		}
		
		else if(Br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		else if(Br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(Br.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
			
			//String IEDriver_Path= "C:\\Users\\radhe.shyam\\eclipse-workspace\\EchoParkV001\\Drivers\\IEDriverServer.exe";
			//System.setProperty("webdriver.ie.driver","C:\\Users\\radhe.shyam\\eclipse-workspace\\EchoParkV001\\Drivers\\IEDriverServer.exe");
			
			//driver=new InternetExplorerDriver();
			
			
			Thread.sleep(5000);
			
		
		}
		
		/*else if(Br.equals("safari"))
		{
			WebDriverManager.safaridriver.setup();
			driver=new SafariDriver();
		}
		*/
		
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}	

}

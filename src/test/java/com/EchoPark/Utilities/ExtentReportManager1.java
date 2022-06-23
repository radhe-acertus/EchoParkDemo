package com.EchoPark.Utilities;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager1 implements ITestListener
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{	/*	
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		repName="Test-"+timeStamp+"Report"+".html";
				
		htmlReporter=new ExtentHtmlReporter(".\\Reports\\"+repName);//specify location of the report
				
		htmlReporter.config().setDocumentTitle("EchoPark_Login Automation Report"); // Tile of report
		htmlReporter.config().setReportName("EchoPark  Functional Testing"); // name of the report
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.start();
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Application", "EchoPark");
		extent.setSystemInfo("Module", "LoginPage");
		extent.setSystemInfo("Sub Module", "LoginPage");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Radhe");*/
			
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		
		/*
		 *test=extent.createTest(result.getTestContext().getName());
		test.assignCategory(result.getMethod().getMethodName());
		
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
		*/
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		/*
		test=extent.createTest(result.getTestContext().getName());
		test.assignCategory(result.getMethod().getMethodName());
			
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.DEBUG, result.getThrowable().getMessage());
			
		String screenshotPath=System.getProperty("user.dir")+"\\ScreenShots\\"+result.getName()+".png";
		
		try {
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
			//test.addScreenCaptureFromBase64String(screenshotPath); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/	
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		/*
		test=extent.createTest(result.getTestContext().getName());
		test.assignCategory(result.getMethod().getMethodName());
		test.createNode(result.getName());
		
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		*/
	}
	
	@SuppressWarnings("deprecation")
	public void onFinish(ITestContext testContext)
	{
		/*
		extent.flush();
		
		try 
		{
			URL url = new URL("file:///"+System.getProperty("user.dir")+"\\Reports\\"+repName);
			
			System.out.println(url);
			 // Create the email message
			  ImageHtmlEmail email = new ImageHtmlEmail();
			  email.setDataSourceResolver(new DataSourceUrlResolver(url));
			  email.setHostName("outlook.office365.com");
			  email.setSmtpPort(587);
			  email.setAuthenticator(new DefaultAuthenticator("Radhe.Shyam@acertusdelivers.com", "Moni050585"));
			  email.setTLS(true);
			  email.setSSLOnConnect(false);
			  email.setFrom("Radhe.Shyam@acertusdelivers.com");   //Sender
			  email.setSubject("Test Results");
			  email.setMsg("Please find Attached Report....");
			  email.addTo("Radhe.Shyam@acertusdelivers.com");   //Receiver
			  //email.addTo("Sharon.Putman@acertusdelivers.com");   //Receiver
			  //email.addTo("James.Sears@acertusdelivers.com");   //Receiver
			  email.attach(url, "extent report", "please check report...");
			  email.send();   // send the email
		}
		
		catch(Exception e)
			{
				e.printStackTrace();
			}
			*/
		
	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	
	
}

package com.EchoPark.TestCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EchoPark.PageObjects.LoginPage;
import com.EchoPark.TestBase.BaseClass;

public class TC_LoginTest0001 extends BaseClass {
	
	
			
	
	
	
			@Test(priority=7)
			public void loginTest_loginFrameFoot() throws InterruptedException, IOException
			{
				//logger.info("********** Starting loginTest_loginFrameFoot **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				LoginPage lp=new LoginPage(driver);
				
				String lFrameFoottxt=lp.LoginFrameFooter();
				String exp_lFrameFoottxt="For help with your account, please call 1 855-521-0303";
				
				if(lFrameFoottxt.equals(exp_lFrameFoottxt))
				{
					System.out.println(lFrameFoottxt);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"loginTest_loginFrameFoot");
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed loginTest_loginFrameFoot **********");
				
			}
	
	
	
	
	
			@Test(priority=6)
			public void loginTest_loginFrameVerbiage() throws InterruptedException, IOException
			{
				//logger.info("********** Starting loginTest_loginFrameVerbiage **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				LoginPage lp=new LoginPage(driver);
				String lFrameVtxt=lp.LoginFrameHeader();
				String exp_lFrametxt= "Welcome to the Ship With Echopark Portal.";
				
				if(lFrameVtxt.equals(exp_lFrametxt))
				{
					System.out.println(lFrameVtxt);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"loginTest_loginFrameVerbiage");
					Assert.assertTrue(false);
				}
				
				//logger.info("********** Completed loginTest_loginFrameVerbiage **********");
				
			}
	
	
	
			@Test(priority=5)
			public void loginTest_InvalidIdPwd() throws InterruptedException, IOException
			{
				
				//logger.info("********** Starting loginTest_InvalidIdPwd **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				LoginPage lp=new LoginPage(driver);
				lp.setUserName(configPropObj.getProperty("useremail"));
				lp.setPassword(configPropObj.getProperty("invalidpassword"));
				lp.clicklogin();
				
				String act_Alertmsg="These credentials do not match our records.";
				String exp_Alertmsg= lp.LoginError();
				
				
				
				String exp_title="Ship With Echopark - Login";
				String act_title= driver.getTitle();
				
				if(exp_Alertmsg.equals(act_Alertmsg))
				{
					System.out.println(exp_Alertmsg);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"loginTest_InvalidIdPwd");
					Assert.assertTrue(false);
				}
				
				//logger.info("********** Completed loginTest_InvalidIdPwd **********");
				
			}	
	
	
	
	
			@Test(priority=4)
			public void loginTest_InvalidUname() throws InterruptedException, IOException
			{
				//logger.info("********** Starting loginTest_InvalidUname **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				LoginPage lp=new LoginPage(driver);
				lp.setUserName(configPropObj.getProperty("invalidusername"));
				lp.setPassword(configPropObj.getProperty("password"));
				lp.clicklogin();
				
				String LogInerror=lp.InvalidID();
				System.out.println(LogInerror);
				
				
				
				//Thread.sleep(2000);
				String exp_title="Ship With Echopark - Login";
				String act_title= driver.getTitle();
				
				if(exp_title.equals(act_title))
				{
					System.out.println(act_title);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"loginTest_InvalidUname");
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed loginTest_InvalidUname **********");
			}	
	
	
	
			@Test(priority=3)
			public void loginTest_NoPwd() throws InterruptedException, IOException
			{
				//logger.info("********** Starting loginTest_NoPwd **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
				
				LoginPage lp=new LoginPage(driver);
				lp.setUserName(configPropObj.getProperty("useremail"));
				lp.clicklogin();
				String error_msg=lp.getPwdfieldAttribute();
				System.out.println(error_msg);
				//Thread.sleep(2000);
				String exp_title="Ship With Echopark - Login";
				String act_title= driver.getTitle();
				
				if(exp_title.equals(act_title))
				{
					System.out.println(act_title);
					System.out.println(error_msg);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"loginTest_NoPwd");
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed loginTest_NoPwd **********");
			}
			
			
			
				
				@Test(priority=2)
				public void loginTest_NoUname() throws InterruptedException, IOException
				{
					
					//logger.info("********** Starting loginTest_NoUname **********");
					
					driver.get(configPropObj.getProperty("baseURL"));
					driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
					
					LoginPage lp=new LoginPage(driver);
					lp.setPassword(configPropObj.getProperty("password"));
					lp.clicklogin();
					String error_msg=lp.getIDfieldAttribute();
					System.out.println(error_msg);
					//Thread.sleep(2000);
					String exp_title="Ship With Echopark - Login";
					String act_title= driver.getTitle();
					
					if(exp_title.equals(act_title))
					{
						System.out.println(act_title);
						Assert.assertTrue(true);
					}
					
					else
					{
						
						captureScreen(driver,"loginTest_NoUname");
						Assert.assertTrue(false);
					}
					
					
					//logger.info("********** Completed loginTest_NoUname **********");					
				
				}
			
	
		
			@Test(priority=8)
			public void loginTest_Happypath() throws InterruptedException, IOException
			{
				//logger.info("********** Starting loginTest_Happypath **********");
				
				driver.get(configPropObj.getProperty("baseURL")); //launching application
				driver.manage().window().maximize();
				LoginPage lp=new LoginPage(driver);
				
				
				lp.setUserName(configPropObj.getProperty("useremail"));
				lp.setPassword(configPropObj.getProperty("password"));
				String act_PwdMasked=lp.Password_Masked();
				String exp_PWDMasked="password";
				lp.clicklogin();
				//Thread.sleep(3000);
				
				String exp_title="Driversselect :: Home";
				String act_title=driver.getTitle();
				
				//lp.Click_LogOut();
				

				
				//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
				if(exp_title.equals(act_title))
				{
					//logger.info("********** loginTest_Happypath Passed **********");
					System.out.println("Title matching");
					System.out.println(act_title);
					lp.Click_LogOut();
					Assert.assertTrue(true);
				}
				
				else
				{
					//logger.info("********** loginTest_Happypath Failed **********");
					captureScreen(driver,"loginTest_Happypath");
					System.out.println("Title Not Matching");
					System.out.println(act_title);
					Assert.assertTrue(false);
					tearDown();
				}
				
				if(act_PwdMasked.equals(exp_PWDMasked))
				{
					//logger.info("********** loginTest_Happypath Password masked **********");
					System.out.println("Password is masked");
				}
				
				else
				{
					//logger.info("********** loginTest_Happypath Password not masked **********");
					captureScreen(driver,"loginTest_Happypath");
					System.out.println("Password is not masked");
				}
				
				//logger.info("**********Completed loginTest_Happypath **********");
				
			}
			
			
			
			@Test(priority=9)
			public void LoginTest_ForgotPwd() throws IOException
			{
				
				//logger.info("********** Starting LoginTest_ForgotPwd **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				LoginPage lp= new LoginPage(driver);
				
				String act_txtForgot= lp.LoginFrame_ForgotPwd();
				String exp_txtForgot="Forgot your password?";
				
				
				if(act_txtForgot.equals(exp_txtForgot))
				{
					System.out.println(act_txtForgot);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_ForgotPwd");
					Assert.assertTrue(false);
				}
				
				
				String act_txtResetPwd= lp.Reset_Pwd();
				String exp_txtResetPwd="Reset Password";
				
				if(act_txtResetPwd.equals(exp_txtResetPwd))
				{
					System.out.println(act_txtResetPwd);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_ForgotPwd");
					Assert.assertTrue(false);
				}
				
				
				String act_txtPwdResetEmail= lp.PwdResetEmail();
				String exp_txtPwdResetEmail="E-Mail Address";
				
				if(act_txtPwdResetEmail.equals(exp_txtPwdResetEmail))
				{
					System.out.println(act_txtPwdResetEmail);
					Assert.assertTrue(true);
				}	
				
				else
				{
					captureScreen(driver,"LoginTest_ForgotPwd");
					Assert.assertTrue(false);
				}
				
				
				String act_btnPwdtxt=lp.btnPwdRestLink();
				String exp_btnPwdtxt="Send Password Reset Link";
				
				if(act_btnPwdtxt.equals(exp_btnPwdtxt))
				{
					System.out.println(act_btnPwdtxt);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_ForgotPwd");
					Assert.assertTrue(false);
				}
				
				
				
				//logger.info("********** Completed LoginTest_ForgotPwd **********");
				
			}					
				
		
			
		
	/*	
			
			@Test(priority=10)
			public void RestPwd_EmailValidation() throws InterruptedException, IOException
			{
				//logger.info("********** Starting RestPwd_EmailValidation **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				LoginPage lp= new LoginPage(driver);
				
				String act_Msg_InvalidEmail=lp.ResetPwdEmail_Validation(configPropObj.getProperty("resetEmail"));
				String exp_Msg_invalidEmail="×\n"
						+ "Invalid Email Address - This email address does not exist in our system."; 
				
				System.out.println("Actual Message for Invalid Email");
				System.out.println(act_Msg_InvalidEmail);
				
				//Thread.sleep(3000);
				if(act_Msg_InvalidEmail.equals(exp_Msg_invalidEmail))
				{
					System.out.println(act_Msg_InvalidEmail);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"RestPwd_EmailValidation");
					System.out.println(act_Msg_InvalidEmail);
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed RestPwd_EmailValidation **********");
				
				
			}
			
	*/	
	/*		
		
			
			@Test(priority=21)
			public void Login_ContactNum_Validation() throws InterruptedException, AWTException
			{
				
				//logger.info("********** Starting Login_ContactNum_Validation **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp=new LoginPage(driver);
				
				lp.Login_PhNumber_Validation();
				
				
				//logger.info("********** Completed Login_ContactNum_Validation **********");
				
			}
			
			
	*/	
	
		
			@Test(priority=12)
			public void LoginTest_Validate_PhNumber() throws IOException
			{
				
				//logger.info("********** Starting LoginTest_Validate_PhNumber **********");
				
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp= new LoginPage(driver);
				boolean Contact_Num_Matching=lp.Login_ContactNum_Validation();
				
				
				if(Contact_Num_Matching==true)
				{
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_Validate_PhNumber");
					Assert.assertTrue(false);
				}
					
					
				//logger.info("********** Completed LoginTest_Validate_PhNumber **********");
			}
			
			
			@Test(priority=13)
			public void LoginTest_WeekInfo_Banner() throws IOException
			{
				
				//logger.info("********** Starting LoginTest_WeekInfo_Banner **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp=new LoginPage(driver);
				
				String exp_txt_weekInfo="7 DAYS A WEEK";
				String act_txt_weekInfo=lp.ContactInfoBanner_WeekInfo();
				

				
				if(act_txt_weekInfo.equals(exp_txt_weekInfo))
				{
					System.out.println(act_txt_weekInfo);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_WeekInfo_Banner");
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed LoginTest_WeekInfo_Banner **********");
				
			}
				
			
			@Test(priority=14)
			public void LoginTest_TimingInfo_Banner() throws IOException
			{
				
				//logger.info("********** Starting LoginTest_TimingInfo_Banner **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp=new LoginPage(driver);
				String exp_txt_timingInfo="7:30AM - 9PM CT";
				String act_txt_timingInfo=lp.ContactinfoBanner_TimingInfo();
				
				if(act_txt_timingInfo.equals(exp_txt_timingInfo))
				{
					System.out.println(act_txt_timingInfo);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginTest_TimingInfo_Banner");
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed LoginTest_TimingInfo_Banner **********");
				
			}
			
			
			@Test(priority=11)
			public void ForgotPwd_ValidEmail_validatation() throws IOException
			{
				//logger.info("********** Starting ForgotPwd_ValidEmail_validatation **********");
				
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp= new LoginPage(driver);
				
				String act_txtEmailSent= lp.Pwd_reset_ValidEmail(configPropObj.getProperty("useremail"));
				//System.out.println(act_txtEmailSent);
				String exp_txtEmailSent="Check your email for a password reset link. If you do not receive the link, contact Technical Support at 1 855-521-0303 or send an email to EPTransport@acertusdelivers.com. We may also be able to help you with our live chat feature.";
				
				String act_txt_ChkYourEmail= lp.Reset_ChkYourEmail_txt();
				String exp_txt_ChkYourEmail="Check your email";
				String act_txt_EmailSent= lp.Reset_EmailSent_Msg();
				String exp_txt_EmailSent="Sent!";
				
				if((act_txtEmailSent.equals(exp_txtEmailSent)) && (act_txt_ChkYourEmail.equals(exp_txt_ChkYourEmail)) && (act_txt_EmailSent.equals(exp_txt_EmailSent)))
				{
					System.out.println(act_txt_ChkYourEmail);
					System.out.println(act_txt_EmailSent);
					System.out.println(act_txtEmailSent);
					
					lp.Click_btnHome();
					
										
					driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
					String exp_title="Ship With Echopark - Login";
					String act_title= driver.getTitle();
					
					if(act_title.equals(exp_title))
					{
						System.out.println("Login Page Title::"+act_title);
						Assert.assertTrue(true);
					}
					
					else
					{
						captureScreen(driver,"ForgotPwd_ValidEmail_validatation");
						Assert.assertTrue(false);
					}
					
				}
				
				else
				{
					captureScreen(driver,"ForgotPwd_ValidEmail_validatation");
					Assert.assertTrue(false);
				}
				
				
				
				//logger.info("********** Completed ForgotPwd_ValidEmail_validatation **********");
			}
			

			
			@Test(priority=17)
			public void LoginTest_InvalidPwd() throws IOException, InterruptedException
			{
				
			    //logger.info("********** Starting LoginTest_InvalidPwd **********");
				
				
				//ExcelFile-->WorkBook-->Sheet-->Rows-->Cell
				//WorkBook--XSSFWorkbook Sheet--XSSFSheet Row--XSSFRow Cell--XSSFCell
				
				FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//TestData//Invalid_PWD1.xlsx");
				
				XSSFWorkbook Workbook=new XSSFWorkbook(file);
				XSSFSheet sheet=Workbook.getSheet("Sheet1");
				
				int rowNum=sheet.getLastRowNum();
				int colNum=sheet.getRow(0).getLastCellNum();
				
				System.out.println(rowNum);
				System.out.println(colNum);
				
				
				for(int r=1;r<=rowNum;r++)
				{
				
					driver.get(configPropObj.getProperty("baseURL"));
					driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
					
					LoginPage lp=new LoginPage(driver);
					
					XSSFRow row=sheet.getRow(r);
					System.out.println(r);
					
					for(int c=0;c<=1;c++)
					{
						DataFormatter formater=new DataFormatter();
						
						XSSFCell cell=row.getCell(c);
						
						
						if(c==0)
						{
							String cellValue1=formater.formatCellValue(cell);
							System.out.println(c);
							System.out.println(cellValue1);
							lp.setUserName(cellValue1);
						}
						
						else
						{
							String cellValue2=formater.formatCellValue(cell);
							System.out.println(c);
							System.out.println(cellValue2);
							lp.setPassword(cellValue2);
							//Thread.sleep(5000);
							lp.clicklogin();
							String txt_LoginCrential=lp.Login_CrentialsInvalid_Msg();
							System.out.println(txt_LoginCrential);
						}
						
												
					}
					
					driver.navigate().refresh();
					Thread.sleep(3000);
					
				}
				
				
				
				//logger.info("********** Completed LoginTest_InvalidPwd **********");
				
				
			}
			
		
			
			@Test(priority=18)
			public void ResetPwdLink_Mailtrap() throws InterruptedException
			{
				
				//logger.info("********** Starting ResetPwdLink_Mailtrap **********");
				
				driver.get(configPropObj.getProperty("mailtrapURL"));
				driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
				
				LoginPage lp= new LoginPage(driver);
				String act_email_from=lp.Login_MailTrap(configPropObj.getProperty("mailtrapEmail"), configPropObj.getProperty("mailtrapPwd"));
				String exp_email_From="EPTransport@acertusdelivers.com";
				
				
				//logger.info("********** Completed ResetPwdLink_Mailtrap **********");
				
			}
					
			
		
			@Test(priority=19)
			public void LoginPage_logo_comparison() throws IOException
			{
				
				//logger.info("********** Starting LoginPage_logo_comparison **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp=new LoginPage(driver);
				
				lp.Login_EPLogo();
				lp.Login_VinlocityLogo();
				
				
				//logger.info("********** Completed LoginPage_logo_comparison **********");
			}
						
			
			@Test(priority=20)
			public void LoginPage_ContactUS_Email() throws IOException
			{
				
				//logger.info("********** Starting LoginPage_ContactUS_Email **********");
				
				driver.get(configPropObj.getProperty("baseURL"));
				
				LoginPage lp= new LoginPage(driver);
				
				String act_ContactUs_Email= lp.Login_ContactEmail();
				String exp_ContactUS_Email="mailto:EPTransport@acertusdelivers.com";
				
				if(act_ContactUs_Email.equals(exp_ContactUS_Email))
				{
					System.out.println(act_ContactUs_Email);
					Assert.assertTrue(true);
				}
				
				else
				{
					captureScreen(driver,"LoginPage_ContactUS_Email");
					System.out.println(act_ContactUs_Email);
					Assert.assertTrue(false);
				}
				
				
				//logger.info("********** Completed LoginPage_ContactUS_Email **********");
				
			}
			
			
}

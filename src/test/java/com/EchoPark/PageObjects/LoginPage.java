package com.EchoPark.PageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class LoginPage {
	
	public  WebDriver driver; 
	
			public LoginPage(WebDriver driver) //constructor to initiate webDriver
			{
				this.driver=driver;
				PageFactory.initElements(this.driver, this); 
			}
			
			@FindBy(id="email")
			WebElement txtEmail;			
			
			@FindBy(id="password")
			WebElement txtPassword;
			
			@FindBy(xpath="//button[contains(text(),'LOG IN')]")
			@CacheLookup
			WebElement btnLogin;
			
			@FindBy(xpath="//a[contains(text(),'LOGOUT')]")
			WebElement clk_logout;
			
			@FindBy(xpath="//strong[contains(text(),'These credentials do not match our records.')]")
			WebElement txt_CredentialsInvalid;
			
			@FindBy(xpath="//div[@id='message_div']")
			WebElement LogIn_Error;
			
			@FindBy(xpath="//h2[contains(text(),'Welcome to the Ship With Echopark Portal.')]")
			WebElement txtLoginFrame;
			
			@FindBy(xpath="//p[contains(text(),'For help with your account, please call 1 855-521-')]")
			WebElement txtLoginFrameFoot;
			
			@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
			WebElement txtForgotPwd;
			
			@FindBy(xpath="//div[contains(text(),'Reset Password')]")
			WebElement txtResetPwd;
			
			@FindBy(xpath="//label[contains(text(),'E-Mail Address')]")
			WebElement txtPwdReset;
			
			@FindBy(xpath="//button[contains(text(),'Send Password Reset Link')]")
			WebElement btn_SendPwdLink;
			
			@FindBy(name="email")
			WebElement txtbox_emailReset;
			
			@FindBy(xpath="//div[@id='message_div']")
			WebElement msg_InvalidEmailID;
			
			@FindBy(partialLinkText="1 855-521-03")
			WebElement txt_Phone;
			
			@FindBy(xpath="//span[contains(text(),'7 DAYS A WEEK')]")
			WebElement txt_WeekInfo_Banner;
			
			@FindBy(xpath="//span[contains(text(),'7:30AM - 9PM CT')]")
			WebElement txt_TimingInfo_Banner;
			
			@FindBy(xpath="//a[contains(text(),'EMAIL US')]")
			WebElement txt_ContactUSEmail;
			
			@FindBy(xpath="//p[contains(text(),' If y')]")
			WebElement txt_EmailSentMsg;
			
			//@FindBy(xpath="//a[contains(text(),'HOME')]")
			@FindBy(linkText="HOME")
			WebElement btn_home_AfterEmailsent;
			
			@FindBy(xpath="//div[contains(text(),'Check your email')]")
			WebElement txt_CheckYourEmail;
			
			@FindBy(xpath="//h1[contains(text(),'Sent!')]")
			WebElement txt_Sent;
			
			@FindBy(xpath="//body/div[@id='wrap']/nav[1]/div[1]/div[1]/a[1]/img[1]")
			WebElement Img_EPLogo;
			
			@FindBy(xpath="//body/div[3]")
			WebElement Img_VinlocityLogo;
			
		//**********MailTrap WebElements***********//
			@FindBy(id="user_email")
			WebElement txt_mailTrapEmail;
			
			@FindBy(id="user_password")
			WebElement txt_mailTrapPwd;
			
			@FindBy(xpath="//body/main[1]/div[1]/div[1]/form[1]/div[4]/input[1]")
			WebElement btnLogin_MailTrap;
			
			@FindBy(xpath="//span[contains(text(),'Vinlocity-Client (Whitelabel)')]")
			WebElement Lnk_WLInbox;
			
			@FindBy(xpath="//body/div[@id='falconApp']/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]")
			List <WebElement> mailTrap_inbox;
			
		//**************End***********************//	
			
			
			public void setUserName(String Uname)
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtEmail.clear();
				txtEmail.click();
				txtEmail.sendKeys(Uname);
				
			}
			
			public void setPassword(String Upassword)
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtPassword.clear();
				txtPassword.click();
				txtPassword.sendKeys(Upassword);
			}
			
			public String Password_Masked()
			{
				
				String pwd_mask=txtPassword.getAttribute("type");
				System.out.println(pwd_mask);
				if(pwd_mask=="password") 
				{
					return pwd_mask;
				}
				
				else
					return pwd_mask;
			}
			
			public void clicklogin()
			{
				
				btnLogin.click();
			}
			
			public void Click_LogOut()
			{
				clk_logout.click();
			}
			
			public String Login_CrentialsInvalid_Msg()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String txt_credentialError=txt_CredentialsInvalid.getText();
				return txt_credentialError;
			}
			
			public String getIDfieldAttribute()
			{
							
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String msg=txtEmail.getAttribute("validationMessage");
				return msg;
			}
			
			public String getPwdfieldAttribute()
			{
							
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String msg=txtPassword.getAttribute("validationMessage");
				System.out.println(msg);
				return msg;
			}
			
			public String InvalidID()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String msg=txtEmail.getAttribute("validationMessage");
				return msg;
				
			}
			
			public String LoginError()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String Error_Msg= LogIn_Error.getText();
				return Error_Msg;
			}
			
			public String LoginFrameHeader()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String lFrametxt=txtLoginFrame.getText();
				return lFrametxt;
			}
			
			public String LoginFrameFooter()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String lFrameFoottxt=txtLoginFrameFoot.getText();
				return lFrameFoottxt;
			}
			
			public String LoginFrame_ForgotPwd()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String txtForgot=txtForgotPwd.getText();				
				txtForgotPwd.click();
				return txtForgot;
			}
			
			public String Reset_Pwd()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String txtReset=txtResetPwd.getText();				
				return txtReset;
			}
			
			public String PwdResetEmail()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String PREmail= txtPwdReset.getText();
				return PREmail;

			}
			
			public String btnPwdRestLink()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String btn_Pwdtxt=btn_SendPwdLink.getText();
				return btn_Pwdtxt;
			}
			
			public String txtBox_PwdRest(String ResetEmail)
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtbox_emailReset.clear();
				txtbox_emailReset.sendKeys(ResetEmail);
				btn_SendPwdLink.click();
				
				String wrongEmail_error=txtbox_emailReset.getAttribute("validationMessage");
				return wrongEmail_error;
			}
			
			public String Reset_InvalidEmail(String EmailID)
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtbox_emailReset.clear();
				txtbox_emailReset.sendKeys(EmailID);
				btn_SendPwdLink.click();

				String Invalid_email_alert= driver.switchTo().alert().getText();
				
				return Invalid_email_alert;
			}
			
			public String ResetPwdEmail_Validation(String EmailID)
			{
				
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtForgotPwd.click();
				txtbox_emailReset.clear();
				txtbox_emailReset.sendKeys(EmailID);
				btn_SendPwdLink.click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				
				
				String msg_InvalidEmail= msg_InvalidEmailID.getText();
				return msg_InvalidEmail;
				
			}
			
			public void Login_PhNumber_Validation() throws InterruptedException, AWTException
			{
				//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txt_Phone.click();
				Thread.sleep(4000);				
				
				Robot robot=new Robot();
				//robot.toString().
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(2000);
				
				robot.keyPress(KeyEvent.VK_ENTER);
				//Thread.sleep(3000);

			}
			
			public boolean Login_ContactNum_Validation()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String Ph1=txt_Phone.getText();
				String Ph2=txtLoginFrameFoot.getText();
				
				String Ph_NumbersOnly1=Ph1.replaceAll("\\D+", "");
				String Ph_NumbersOnly2=Ph_NumbersOnly1.trim();
				String NumbersOnly1=Ph2.replaceAll("\\D+", "");
				String NumbersOnly2=NumbersOnly1.trim();
				
				if(Ph_NumbersOnly2.equals(NumbersOnly2))
				{
					System.out.println(NumbersOnly2);
					System.out.println(Ph_NumbersOnly2);
					return true;
				}
				
				else
				{
					System.out.println(NumbersOnly2);
					System.out.println(Ph_NumbersOnly2);
					return false;
				}
				
			}
			
			public String ContactInfoBanner_WeekInfo()
			{
				
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				String weekInfo=txt_WeekInfo_Banner.getText();
				return weekInfo;
			}
			
			public String ContactinfoBanner_TimingInfo()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				String timingInfo=txt_TimingInfo_Banner.getText();
				return timingInfo;
			}
			
			public String Login_ContactEmail()
			{
				String contactUS_Email= txt_ContactUSEmail.getAttribute("href");
				return contactUS_Email;
				
			}
			
			public String Pwd_reset_ValidEmail(String Email)
			{
				
				txtForgotPwd.click();
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txtbox_emailReset.clear();
				txtbox_emailReset.sendKeys(Email);
				System.out.println(Email);
				btn_SendPwdLink.click();
				
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String txt_EmailSent= txt_EmailSentMsg.getText();
				
				return txt_EmailSent;

			}
			
			public String Reset_ChkYourEmail_txt()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				String txt_Chk_Email=txt_CheckYourEmail.getText();
				return txt_Chk_Email;
			}
			
			
			public String Reset_EmailSent_Msg()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				String txt_EmailSent_msg=txt_Sent.getText();
				return txt_EmailSent_msg;
			}
			
			
			public void Click_btnHome()
			{
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				btn_home_AfterEmailsent.click();
				
			}
			
			
			//********MailTrapMethods***********//
			
			public String Login_MailTrap(String email, String Pwd) throws InterruptedException
			{
				
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				
				txt_mailTrapEmail.clear();
				txt_mailTrapEmail.sendKeys(email);
				
				txt_mailTrapPwd.clear();
				txt_mailTrapPwd.sendKeys(Pwd);
				
				btnLogin_MailTrap.click();
				
				Thread.sleep(10000);
				
				Lnk_WLInbox.click();
				
				//boolean Email_Received=mailTrap_inbox.contains("(no subject)");
				String exp_email_From="to: <wl-sales@metrogistics.com>";
				String act_email_From="";
				for(WebElement ele:mailTrap_inbox)
				{
					 act_email_From=ele.getText();
					System.out.println(act_email_From);
					if(act_email_From.equals(exp_email_From))
					break;
				}
				
				return act_email_From;
				
				
				
			}
			
			
			
		public void Login_EPLogo() throws IOException
		{
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			//new AShot takeScreenShot method will need two parameter 1 driver 2 WebElement locating logo//
			// Screenshot will store actual logo from WebElement//
			//ImageIO write method will store the logo at  given location//
			//File F will validate if logo exist at given location//
			
			Screenshot EPLogo_ScreenShot=new AShot().takeScreenshot(driver, Img_EPLogo);
			
			ImageIO.write(EPLogo_ScreenShot.getImage(),"png",new File(System.getProperty("user.dir")+"//TestData//EP_logo.png"));
			
			File F=new File(System.getProperty("user.dir")+"//TestData//EP_logo.png");
			
			if(F.exists())
			{
				System.out.println("EP_Logo exist");
			}
			
			else
			{
				System.out.println("EP_Logo does not exist");
			}
		
		
		}
		
		public void Login_VinlocityLogo() throws IOException
		{
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			Screenshot VinlocityLogo_screenShot=new AShot().takeScreenshot(driver, Img_VinlocityLogo);
			
			//Screenshot VinlocityLogo_screenShot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver,Img_VinlocityLogo);
			ImageIO.write(VinlocityLogo_screenShot.getImage(),"png",new File(System.getProperty("user.dir")+"//TestData//Vinlocity_logo.png"));
			
			File F=new File(System.getProperty("user.dir")+"//TestData//Vinlocity_logo.png");
			
			if(F.exists())
			{
				System.out.println("Vinlocity Logo exist");
			}
			
			else
			{
				System.out.println("Vinlocity Logo does not exist");
			}
			
						
		}
			
			
			
			
			

}

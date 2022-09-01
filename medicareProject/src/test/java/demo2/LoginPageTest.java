package demo2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import demo1.BrowserDriver;
import demo1.LoginPage;

public class LoginPageTest {

	WebDriver driver;
	LoginPage loginpage;
	@BeforeTest
	public void openBrowser() throws InterruptedException {
	//	BrowserDriver browserdriver = new BrowserDriver();
		//driver = browserdriver.getDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		System.out.println("chrome started");
		Thread.sleep(5000);
		loginpage = new LoginPage(driver);
		loginpage.nevigate();
		System.out.println("medicare started");
		
	}
	
	@Test
	public void byingItem() {
		
		loginpage.loginUser("Kn@gmail.com" ,"12345" );
		loginpage.selectMedicine();
		loginpage.addingAddress1("Flat No. 102, Bhavani Parisar", "BHEL Road ,Near BHEL Gate No. 1","Bhopal");
		loginpage.addingAddress2("111111","Madhya Pradesh","India");
		loginpage.clickOnPay("123456","05","2025","333");
		String exp_mssg = loginpage.varifyPayment();
		System.out.println(exp_mssg);
		Assert.assertEquals(exp_mssg, "Your Order is Confirmed!!");
		loginpage.returnhomePage();
		
		
	}
	
	@Test
	public void varifyMethod() {
		loginpage.varifyMedicinename();
		loginpage.logoutClick();
	}
	
	@AfterTest
	public void closingBrowser() {
		driver.quit();
	}
}

package demo1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	String url = "http://localhost:8081/medicare";
	//http://localhost:8081/medicare/
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	}
	
	public void nevigate() {
		driver.get(url);
	}
	
	By link_login = By.linkText("Login");
	By login_user = By.id("username");
	By login_pass = By.id("password");
	By login_click =By.xpath("//input[contains(@value,'Login')]");
	
	public void loginUser(String username, String pass) {
		driver.findElement(link_login).click();
		driver.findElement(login_user).sendKeys(username);
		driver.findElement(login_pass).sendKeys(pass);
		driver.findElement(login_click).click();
		
	}
	
	By medi_name1 = By.linkText("Antipyretics");
//	By info_btn = By.xpath("(//a[contains(@class, 'btn btn-primary')])[1]");
	By cart_btn = By.xpath("//a[contains(@class, 'btn btn-success')]");
	By cekout_btn = By.xpath("//a[contains(@class ,'btn btn-success btn-block')]");
	
	public void selectMedicine() {
		driver.findElement(medi_name1).click();
	//	driver.findElement(info_btn).click();
		driver.findElement(cart_btn).click();
		driver.findElement(cekout_btn).click();
	}
	
	By line1 = By.id("addressLineOne");
	By line2 = By.id("addressLineTwo");
	By area= By.id("city");
	By pincode = By.id("postalCode");
	By State = By.id("state");
	By Country = By.id("country");
	By addres_btn =By.xpath("//button[contains(@type,'submit')]");
	
	public void addingAddress1(String add1, String add2, String place) {
		driver.findElement(line1).sendKeys(add1);
		driver.findElement(line2).sendKeys(add2);
		driver.findElement(area).sendKeys(place);
		}
	public void addingAddress2(String PinCode, String State_name, String country_name ) {
		driver.findElement(pincode).sendKeys(PinCode);
		driver.findElement(State).sendKeys(State_name);
		driver.findElement(Country).sendKeys(country_name);
		driver.findElement(addres_btn).click();
	}
	//By select_btn = By.xpath("//a[contains(@class ,'btn btn-primary')]");
	By Pat_btn = By.xpath("//a[contains(@role,'button')]");
	By card_no= By.id("cardNumber");
	By exp_month= By.id("expityMonth");
	By exp_year= By.id("expityYear");
	By cvv= By.id("cvCode");
	public void clickOnPay(String Card_no,String Exp_month,String Exp_year,String Cvv) {
		driver.findElement(card_no).sendKeys(Card_no);;
		driver.findElement(exp_month).sendKeys(Exp_month);;
		driver.findElement(exp_year).sendKeys(Exp_year);;
		driver.findElement(cvv).sendKeys(Cvv);;
		driver.findElement(Pat_btn).click();
	}
	
//a[contains(@role,'button')]
	By cofm_mess = By.xpath("//h3[contains(@class,'text-center')]");
	public String varifyPayment() {
		
		return driver.findElement(cofm_mess).getText();
	}

	By con_btn = By.linkText("Continue Shopping");
	//a[contains(@class,'btn btn-lg btn-warning')]
	public void returnhomePage() {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		driver.findElement(con_btn).click();
	}
	
	By medi_name2 = By.linkText("Antibiotics");
	By table_list = By.id("productListTable");
	By row_list   =By.tagName("tr");
	By column_list = By.tagName("td");
	public void varifyMedicinename() {
    WebElement table = driver.findElement(table_list);
    List<WebElement> rows= table.findElements(row_list);
    boolean valuefound = false;
    for(int i=1;i<rows.size();i++) {
    	WebElement row=rows.get(i);
    	List<WebElement> columns = row.findElements(column_list);
    	for(WebElement x :columns) {
    		if(x.getText().equals("Amoxicillin")) {
    			System.out.println("Test Case is Passed");
    			valuefound =true;
    			break;
    		}
    	} 
    	if(valuefound ==true) {
    		break;
    	}
    } 
  
	}

	 By toddle= By.id("dropdownMenu1");
	 By log_btn= By.id("logout");
	 
	 public void logoutClick() {
		 driver.findElement(toddle).click();
		 driver.findElement(log_btn).click();
	 }




}

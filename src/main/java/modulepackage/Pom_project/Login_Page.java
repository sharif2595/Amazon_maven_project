package modulepackage.Pom_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	
	 WebDriver driver;
		
		@FindBy (id="ap_email_login")
		WebElement email_component;
		
		@FindBy (xpath="//input[@class='a-button-input']")
		WebElement Continue_button_loginpage;

		@FindBy (id="ap_password")
		WebElement password_component;
		
		@FindBy (id="signInSubmit")
		WebElement signin_button_from_login_page;
		
		
		public void input(String mobnumber)
		{
			email_component.sendKeys(mobnumber);
		}
		
		public void Click_on_continue_button()
		{
			Continue_button_loginpage.click();
		}
		
		public void input_password(String pass)
		{
			password_component.sendKeys(pass);
		}
		
		public void click_on_sign_button()
		{
			signin_button_from_login_page.click();
		}
		
		public Login_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

}

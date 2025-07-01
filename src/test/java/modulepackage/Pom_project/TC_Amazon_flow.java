package modulepackage.Pom_project;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_flow extends BaseClass {
	
	@Test(priority = 0)
	public void hover_element() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Thread.sleep(2000);
		Home_Page.hover_on_element(driver);
		Home_Page.click_on_signin_homepage();
		Thread.sleep(2000);
		Reporter.log("Hover on the element and click on sign in button");
	}
	
	@Test(priority = 1)
	public void enter_vaild_cred() throws InterruptedException
	{
		Login_Page Login_Page=new Login_Page(driver);
		Thread.sleep(2000);
		Login_Page.input("9131899877");
		Thread.sleep(2000);
		Login_Page.Click_on_continue_button();
		Thread.sleep(2000);
		Login_Page.input_password("9131899877");
		Thread.sleep(2000);
		Login_Page.click_on_sign_button();
		Thread.sleep(5000);
		Reporter.log("Enter vaild cred");
		
	}
	

	@Test(priority = 2)
	public void search_product() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Thread.sleep(2000);
		Home_Page.search_product("toy");
		Thread.sleep(2000);
		Reporter.log("Search the prodduct");
		
	
	}
	
	
	@Test(priority = 3)
	public void click_on_first_product() throws InterruptedException
	{
		Thread.sleep(3000);
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Thread.sleep(4000);
		Reporter.log("Cllick on the first product");
	
	}
	
	@Test(priority = 4)
	public void click_on_add_to_cart_proceed_to_buy() throws InterruptedException
	{
		Thread.sleep(3000);
		Product_detail_page Product_detail_page= new Product_detail_page(driver);
		Product_detail_page.click_on_add_to_cart_button();
		Thread.sleep(3000);
		Product_detail_page.click_on_proced_to_buy();
		Thread.sleep(3000);
		Reporter.log("click on add to cart icons and click on proceed to buy button");
	}

	
	@Test(priority = 5)
	public void select_creditcard_option() throws InterruptedException
	{
		Thread.sleep(3000);
		Check_out_page Check_out_page= new Check_out_page(driver);
		Check_out_page.select_credit_card_options("SelectableAddCreditCard");
		Thread.sleep(10000);
		Reporter.log("Select the payment option as creditcard");
		
	}
	
	

}

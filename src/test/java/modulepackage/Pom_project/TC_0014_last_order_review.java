package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_0014_last_order_review extends BaseClass{
	
	@DataProvider(name="get_vaild_cred")
	public static Object[][] testdata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fn = new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb=WorkbookFactory.create(fn);
		Sheet sh_name = wb.getSheet("Login");
		
		String name=wb.getSheet("Login").getRow(0).getCell(2).getStringCellValue();
		String username=NumberToTextConverter.toText(sh_name.getRow(0).getCell(0).getNumericCellValue());
		String password=NumberToTextConverter.toText(sh_name.getRow(0).getCell(1).getNumericCellValue());
	
		Object[][] d1=new Object[1][3];
		d1[0][0]=username;
		d1[0][1]=password;
		d1[0][2]=name;
		
		return d1;
	}
	
	
	
	
	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void hover_element() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Thread.sleep(2000);
		Home_Page.hover_on_element(driver);
		Home_Page.click_on_signin_homepage();
		Thread.sleep(2000);
		Reporter.log("Hover on the element and click on sign in button");
	}
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class, dataProvider = "get_vaild_cred")
	public void enter_vaild_cred_and_validate_username(String username, String password, String name) throws InterruptedException
	{
		Login_Page Login_Page=new Login_Page(driver);
		Thread.sleep(2000);
		Login_Page.input(username);
		String get_phone_number=Login_Page.get_number();
		sa.assertEquals(get_phone_number, username, "something wrong in the username");
		Thread.sleep(2000);
		Login_Page.Click_on_continue_button();
		Thread.sleep(2000);
		Login_Page.input_password(password);
		String get_password=Login_Page.get_password();
		sa.assertEquals(get_password, password, "something wrong in the password");
		Thread.sleep(2000);
		Login_Page.click_on_sign_button();
		Thread.sleep(5000);
		Reporter.log("Enter vaild cred");
		sa.assertAll();
		
		//verify username after login
		Home_Page Home_Page=new Home_Page(driver);
		String fetch_username=Home_Page.verfiy_user_name();
		sa.assertTrue(fetch_username.contains(name), name);
		sa.assertAll();
		Reporter.log("verfiy the name of the login user"); 
		
	}

	
	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void navigat_to_order_page() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		boolean signin_is_displayed=Home_Page.sign_in_xpath();
		sa.assertEquals(signin_is_displayed, true);
		Boolean hyper_link_isdisplayed=Home_Page.order_hyper_link_click();
		sa.assertEquals(hyper_link_isdisplayed, true);
		boolean order_tab_displayed=Home_Page.order_tab_displayed();
		sa.assertEquals(order_tab_displayed, true);

		Past_order_page Past_order_page= new Past_order_page(driver);
		boolean time_filter_isdisplayed=Past_order_page.select_timefilter("year-2025");
		sa.assertEquals(time_filter_isdisplayed, true);
		sa.assertAll();
		
		Reporter.log("navigate to order page and select year");
		
	}
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void select_product_review_first_element() throws InterruptedException
	{
		Past_order_page Past_order_page= new Past_order_page(driver);
		boolean first_element_is_displayed=Past_order_page.first_element_displayed();
		sa.assertEquals(first_element_is_displayed, true);
		Past_order_page.click_on_review_button();
		sa.assertAll();
		Reporter.log("past order is displayed or not and click it on write Product review");
	}
	
	
	@Test(priority = 4, retryAnalyzer = utils.Irety_analyzer.class)
	public void give_star_rating() throws InterruptedException
	{
		write_product_review write_product_review=new write_product_review(driver);
		write_product_review.star_displayed(4);
		Reporter.log("past order is displayed or not and click it on write Product review");
	}
	
	
	@Test(priority = 6, retryAnalyzer = utils.Irety_analyzer.class)
	public void Write_review_descrption() throws InterruptedException
	{
		write_product_review write_product_review=new write_product_review(driver);
		boolean decription=write_product_review.review_input("test review");
		sa.assertEquals(decription, true);
		sa.assertAll();
		Reporter.log("Enter review descrption");
	}
	
	@Test(priority = 7, retryAnalyzer = utils.Irety_analyzer.class)
	public void Write_review_title() throws InterruptedException
	{
		write_product_review write_product_review=new write_product_review(driver);
		boolean title_displayed=write_product_review.review_title_input("test title review");
		sa.assertEquals(title_displayed, true);
		sa.assertAll();
		Reporter.log("Enter review title");
		
	}
	
	@Test(priority = 8, retryAnalyzer = utils.Irety_analyzer.class)
	public void Write_review_submit() throws InterruptedException
	{
		write_product_review write_product_review=new write_product_review(driver);
		boolean submit_displayed=write_product_review.review_submitt();
		Thread.sleep(2000);
		sa.assertEquals(submit_displayed, true);
		sa.assertAll();
		Reporter.log("Submit button is displayed or not");
		
	}
	
	
	@Test(priority = 9, retryAnalyzer = utils.Irety_analyzer.class)
	public void check_review_submitted_sucessfully() throws InterruptedException
	{
		write_product_review write_product_review=new write_product_review(driver);
		String alert_value=write_product_review.verfiy_review_text();

		sa.assertEquals(alert_value, "Awesome! Thank you for helping other shoppers!",
				"Something worng with review description text submission");
		sa.assertAll();
		
		Reporter.log("check_review_submitted_sucessfully");
		
	}
	
}

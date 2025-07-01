package modulepackage.Pom_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_detail_page {
	
	
	WebDriver driver;
	
	@FindBy (xpath="(//input[@type='submit'])[2]")
	WebElement Add_to_Cart_button;
	
	@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
	WebElement proceed_To_buy;
	
	
	public void click_on_add_to_cart_button()
	{
		Add_to_Cart_button.click();
	}
	
	public void click_on_proced_to_buy()
	{
		proceed_To_buy.click();
	}
	
	
	public Product_detail_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}

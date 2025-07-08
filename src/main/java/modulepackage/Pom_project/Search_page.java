package modulepackage.Pom_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Search_page {
	
	WebDriver driver;
	WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	WebElement search_box;
	
	@FindBy (xpath = "//div[@role='listitem']")
	List<WebElement> search_option_list;
	
	@FindBy (xpath="(//div[@role='listitem']//a[@class='a-link-normal s-no-outline'])[1]")
	WebElement first_product;
	
	@FindBy (xpath="//span[@id='nav-cart-count']")
	WebElement fetch_cart_count;
	
	@FindBy (xpath="(//div[@role='listitem']//div[@class='a-section a-spacing-none a-spacing-top-mini']//button[@name='submit.addToCart'])[1]")
	WebElement click_on_first_product_add_to_cart_button;
	
	@FindBy (xpath="//button[@data-a-selector='decrement']")
	WebElement delete_button;
	
	
	@FindBy (xpath="//div[@class='a-section ewc-item-remove-msg']/span")
	WebElement remove_msg;
	
	public String fetch_remove_msg()
	{
		Wait.until(ExpectedConditions.visibilityOf(remove_msg));
		String value=remove_msg.getText();
		return value;
	}
	
	
	
	public void click_delete_button()
	{
		Wait.until(ExpectedConditions.visibilityOf(delete_button));
		delete_button.click();
	}
	
	public void click_on_first_add_to_cart_button()
	{
		Wait.until(ExpectedConditions.visibilityOf(click_on_first_product_add_to_cart_button));
		click_on_first_product_add_to_cart_button.click();
	}
	
	public String fetch_cart_count()
	{
		Wait.until(ExpectedConditions.visibilityOf(fetch_cart_count));
		String value=fetch_cart_count.getText();
		return value;
	}
	
	
	public String fetch_input()
	{
		Wait.until(ExpectedConditions.visibilityOf(search_box));
		String search_value=search_box.getAttribute("value");
		return search_value;
		
	}
	
	public int get_search_result_count()
	{
		Wait.until(ExpectedConditions.visibilityOfAllElements(search_option_list));
		int get_count=search_option_list.size();
		return get_count;
	}
	
	public void click_on_first_product()
	{
		Wait.until(ExpectedConditions.visibilityOf(first_product));
		first_product.click();
	}
	
	
	public Search_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
}

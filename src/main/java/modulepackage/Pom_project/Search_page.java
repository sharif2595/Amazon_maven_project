package modulepackage.Pom_project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Search_page {
	WebDriver driver;
	
	@FindBy (xpath = "//div[@role='listitem']")
	List<WebElement> search_option_list;
	
	@FindBy (xpath="(//div[@role='listitem']//a[@class='a-link-normal s-no-outline'])[1]")
	WebElement first_product;
	
	
	public int get_search_result_count()
	{
		int get_count=search_option_list.size();
		return get_count;
	}
	
	public void click_on_first_product()
	{
		first_product.click();
	}
	
	
	public Search_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
}

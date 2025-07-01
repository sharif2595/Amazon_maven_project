package modulepackage.Pom_project;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	
    WebDriver driver;
	
	@FindBy (xpath="//div[@id='nav-link-accountList']/a")
	WebElement hover;
	
	@FindBy (xpath="//a[@class='nav-action-signin-button']")
	WebElement Signin_button_from_hompage;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	WebElement search_box;

	
	public void hover_on_element(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveToElement(hover).perform();
	}
	
	public void click_on_signin_homepage()
	{
		Signin_button_from_hompage.click();
	}
	
	public void search_product(String product_name )
	{
		search_box.sendKeys(product_name+ Keys.ENTER);
	}
	
	public String vaildate_product_name()
	{
		String value=search_box.getDomAttribute("value");
		return value;
	}
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

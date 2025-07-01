package modulepackage.Pom_project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Check_out_page {

    WebDriver driver;
    String  attribute_value;
	//input[@value='SelectableAddCreditCard']
	@FindBy (xpath="//input[@type='radio']")
	List<WebElement> options_of_radio_button;
	
	public void select_credit_card_options(String payment_method)
	{
		for(int i=0; i<=options_of_radio_button.size()-1; i++)
		{
		attribute_value =options_of_radio_button.get(i).getDomAttribute("value");
		System.out.println(attribute_value);
		if (attribute_value.equals(payment_method)) 
		{
			options_of_radio_button.get(i).click();
			break;
		}
	}
	
	}
		
		
		public Check_out_page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	}

	
	
	

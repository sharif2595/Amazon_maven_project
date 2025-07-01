package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.Itest_listener_logic;


public class BaseClass extends Itest_listener_logic {

	String given_url = "https://www.amazon.in/";
	
	@BeforeClass
	public void launch_browser() throws InterruptedException
	{
		driver= new EdgeDriver();
		driver.get(given_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}

	@AfterClass
	public void close_brower() {
		driver.close();
	}

}

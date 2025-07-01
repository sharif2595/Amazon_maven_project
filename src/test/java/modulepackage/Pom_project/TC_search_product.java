package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(utils.Itest_listener_logic.class)
public class TC_search_product extends BaseClass {
	
	SoftAssert sa=new SoftAssert();
	
	@DataProvider(name="search_data")
	public Object[][] testdata() throws EncryptedDocumentException, IOException
	{
		Object[][]data=new Object[1][1];
		
		FileInputStream fn=new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb= WorkbookFactory.create(fn);
		String search_product_value=wb.getSheet("search_product").getRow(0).getCell(0).getStringCellValue();
		System.out.println(search_product_value);
		data[0][0]=search_product_value;
		return data;
	}
	
	@Test(priority = 0,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class)
	public void  Search_Product_And_vaildate_Search_product(String search_product_value)
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.search_product(search_product_value);
		String actual_value=Home_Page.vaildate_product_name();
		System.out.println(actual_value);
		sa.assertEquals(actual_value, "toy", "Wrong input value");
		sa.assertAll();
		Reporter.log("Search the product and validate the search product");
	}
	

	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class)
	public void  Vaildate_The_Count_Of_Search_Product()
	{
		Search_page Search_page=new Search_page(driver);
		int search_result_count=Search_page.get_search_result_count();
		sa.assertEquals(search_result_count>3, true, "result count is wrong");
		sa.assertAll();
		Reporter.log("validate the search result count should be greater than 3");
	}
	

}

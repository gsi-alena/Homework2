package testRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.GoogleSearchPage;


//This class contains Test cases methods
public class GoogleSearchTest {
	
	public GoogleSearchPage lp; 
	public WebDriver driver;
	//Locators
	By googleSearchCriteria = By.name("q");
	//This methods has driver instance and displays the page contained in the driver and executes before test cases as precondition	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	    lp = new GoogleSearchPage();// Instance of POM Page to use WebElements methods
	  
	}
    //This method executes after test cases as postcondition
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
    //This method is a test cases scenario 1 
	@Test
	public void testGoogleSearch() throws InterruptedException {
		if(driver.getTitle().equalsIgnoreCase("Google"))
		{
			lp.setGoogleSearchCriteria("Page Object Model");//Writes search criteria in the search text field
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			//lp.clikOnSearchCriteria();//It is needed because test case rises  element not interactable exception
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			lp.clickBtnGoogleSearch();//Click on Search button
		    
			//When click go to Search results page
			//Capture search results elements list. All result elements has h3 tag
			List<WebElement> list = driver.findElements(By.tagName("h3"));
			
			//Validate driver is in the right page by checking if list element 0 text contains introduced search criteria text
			if(list.get(0).getText().contains("Page Object Model"))
				System.out.print(list.get(0).getText());//Print first element text
			//Click on the first element found
			list.get(0).click();//When click go to first search result page
			
			
			//Capture all elements on this page that have tag h1. First one is first search result element's title.  
			List<WebElement> list2 = driver.findElements(By.tagName("h1"));
			//Validate driver is in the right page by checking if list2 element 0 text matches with first list element 
			if(list2.get(0).getText().equalsIgnoreCase("Page Object Model (POM) & Page Factory in Selenium Tutorial"))
				System.out.print("Element 1 confirmed");
		} else {
			System.out.print("Google Search Page not found");
		}
	}
	 
	

}

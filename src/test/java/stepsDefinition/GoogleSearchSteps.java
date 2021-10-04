package stepsDefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.GoogleSearchPage;



public class GoogleSearchSteps {
	
	public GoogleSearchPage googlepage; 
	public String criteria;
	public List<WebElement> list1,list2;
	
	public GoogleSearchSteps() {
		googlepage = new GoogleSearchPage();
	}
	public void openGoogleSearch() {
		googlepage.getOpenedGoogleSearchUrl("https://www.google.com/");
	}	
	public void setSearchCriteria(String psearchcriteria) {
		criteria=psearchcriteria;
		googlepage.setGoogleSearchCriteria(psearchcriteria);
	}
	public void clickOnSearchButton() {
		googlepage.clickBtnGoogleSearch();
	}
	public void validateSearchresults () {
		list1 = googlepage.getAllSearchResults("h3");
		Assert.assertTrue("There are results for the specied search criteria", list1.size() > 0);;
		//Validate driver is in the right page by checking if list element 0 text contains introduced search criteria text
		if(list1.get(0).getText().contains("Page Object Model"))
			System.out.print(list1.get(0).getText());//Print first element text
	}
	public void clickFirstSearchResultElement(){
		list1.get(0).click();	
	}
	public void validateSearchResult_Firstelement() {
		list2 = googlepage.getAllSearchResults("h1");
		//Validate driver is in the right page by checking if list2 element 0 text matches with first list element 
		if(list2.get(0).getText().equalsIgnoreCase("Page Object Model (POM) & Page Factory in Selenium Tutorial"))
			System.out.print("Element 1 confirmed");
	}
	public void close_browser() {
		 googlepage.closeGooglePage();
	}
}

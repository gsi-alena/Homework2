package stepsDefinition;


import org.junit.Test;
import cucumber.api.java.*;
import cucumber.api.java.en.*;

public class GoogleStepsDefinition {
	
	public GoogleSearchSteps steps;
	
	public GoogleStepsDefinition() {
		steps = new GoogleSearchSteps();
	}
	@Before
		@Given("User opens Chrome browser")
		public void user_opens_Chrome_browser() throws Exception {
		   steps.openGoogleSearch();
		}
	@Test
		@When("User enters SearchCriteria as {String}")
		public void user_enters_Search_Criteria_as(String psearchcriteria) {
			steps.setSearchCriteria(psearchcriteria);
		}
		@When("Click on Search button")
		public void click_on_Search_button() {
		    steps.clickOnSearchButton();
		}
		@Then("Validate Search results")
		public void validate_Search_results () {
			steps.validateSearchresults();
		}
		@When("User click on the First Search result element")
		public void user_click_on_the_First_Search_result_element(){
			steps.clickFirstSearchResultElement();
		}
		@Then("Validate Search result First element")
		public void validate_Search_result_First_element() {
			steps.validateSearchResult_Firstelement();
		}
	@After
		@Then("close browser")
		public void close_browser() {
			 steps.close_browser();
		}
}

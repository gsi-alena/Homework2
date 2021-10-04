package pageObjects;

import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.By;


//This class contains Google Search Page WebElements
public class GoogleSearchPage extends MainPageObject {
 
	public GoogleSearchPage() {
		super();
	}
	public String getGoogleSearchCriteria() {
		return this.getElement(By.name("q")).getText();
	}
	public void setGoogleSearchCriteria(String gcriteria) {
		getElement(By.name("q")).clear();
		getElement(By.name("q")).sendKeys(gcriteria);
	}
	public void clickBtnGoogleSearch() {
		clickOnElement(By.name("btnK"));
	}
	public void clickBtnFeelLucky() {
		clickOnElement(By.name("btnI"));
	}
	public void clickEnglishLink() {
		clickOnElement(By.linkText("English"));
	}
	public void clickSpanishLink() {
		clickOnElement(By.linkText("Español (Latinoamérica)"));
	}
	public void clikOnSearchCriteria() {
		clickOnElement(By.name("q"));
	}
	public List<WebElement> getAllSearchResults(String tag){
		return getAllElements(By.tagName(tag));
	}
	public void closeGooglePage() {
		closeDriver();
	}
	public void getOpenedGoogleSearchUrl(String purl) {
		getDriverUrl(purl);
	}

}

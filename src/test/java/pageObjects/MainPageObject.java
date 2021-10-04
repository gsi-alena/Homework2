package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPageObject {
private WebDriver ldriver;

  public MainPageObject() {
	System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver.exe");
	ldriver = new ChromeDriver();
	ldriver.manage().window().maximize();
	PageFactory.initElements(this.ldriver,this);//Initialize driver
  }
  protected WebElement getElement(By bycriteria) {
	return this.ldriver.findElement(bycriteria);
  }
  protected List<WebElement> getAllElements(By bylistcriteria){
	 return this.ldriver.findElements(bylistcriteria); 
  }
  protected void clickOnElement(By elementname)
  {
	  getElement(elementname).click();
	  driverWait();
  }
  protected void driverWait() {
	  ldriver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
  }
  protected void getDriverUrl(String url) {
	  ldriver.get(url);
  }
  protected void closeDriver() {
	  ldriver.close();
  }
}

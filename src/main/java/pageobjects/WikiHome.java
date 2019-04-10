package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHome {

	@FindBy(id="searchInput")
	@CacheLookup
	private WebElement searchBox;
	
	@FindBy(xpath="//*[@id='search-form']/fieldset/button/i")
	@CacheLookup
	private WebElement searchIcon;
	
	public WikiHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
	
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	
	public WikiHome enterSearchWord(String text){
		this.searchBox.sendKeys(text);
		return this;
	}
	
	public WikiHome clickSearchIcon() {
		this.searchIcon.click();
		return this;
	}
}

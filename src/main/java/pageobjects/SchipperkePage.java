package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchipperkePage {

	@FindBy(xpath="//*[@id='mw-content-text']/div/table[2]/tbody/tr[1]/td/a/img")
	@CacheLookup
	private WebElement dogImage;
	
	public SchipperkePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDogImage() {
		return dogImage;
	}
	
	public boolean isDogImageVisible() {
		return this.dogImage.isDisplayed();
	}
	
}	

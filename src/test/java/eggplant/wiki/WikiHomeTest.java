package eggplant.wiki;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.DriverManager;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

import pageobjects.SchipperkePage;
import pageobjects.WikiHome;

public class WikiHomeTest {
	
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(WikiHomeTest.class);

	@BeforeClass
	public void init() {
		driver = DriverManager.getDriver();
		logger.info("Open Browser");
		driver.get("https://www.wikipedia.org");
		String url = driver.getCurrentUrl();
		logger.info("Current url is:" + url);
	}
	
	@Test 
	public void searchText() {
		WikiHome wiki = new WikiHome(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wiki.enterSearchWord("schipperke").clickSearchIcon();
		logger.info("Entered the search word and clicked the search icon");
		String url = driver.getCurrentUrl();
		logger.info("Current url is:" + url);
		Boolean verify = url.contains("/Schipperke");
		Assert.assertTrue(verify);
		SchipperkePage schipperkePage = new SchipperkePage(driver);
		Assert.assertTrue(schipperkePage.isDogImageVisible(), "Dog image not visible");		
	}	
	
	@AfterClass
	public void closeBrowser() {
		logger.info("Close browser");
		driver.close();
		//driver = null;
	}

}

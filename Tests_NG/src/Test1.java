import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1{	
	// Create webDriver reference
    private WebDriver driver;
    private static String SEARCH_TEXT = "gleise";
    private static String SEARCH_PAGE = "https://www.google.com.br";
    
	@BeforeTest(alwaysRun = true)
	// Launch Chrome
	public void setup () {	
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gleis\\Downloads\\chromedriver_win32/chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SEARCH_PAGE);
	}
		
	@Test (priority=1)
	//Do search using google page
	public void search () throws InterruptedException {	                      		 
         try {
	            new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lst-ib']"))).sendKeys(SEARCH_TEXT, Keys.ENTER);
	          } catch (Exception e) {
	          e.printStackTrace();
	         }	
         Thread.sleep(500);

	}
	
	@Test (priority=2)
	//Delete search done before
	public void search1 () throws InterruptedException {	                      		 
        try {
	          new WebDriverWait(driver,15).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='lst-ib']"))).clear();
	        } catch (Exception e) {
	          e.printStackTrace();
	         }	
        
        Thread.sleep(500);

	}
	
	@AfterTest
	//Close the driver
	public void close () {              
	       driver.quit();	   
	}	    
}	


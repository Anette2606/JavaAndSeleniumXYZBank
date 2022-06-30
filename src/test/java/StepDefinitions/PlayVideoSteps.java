package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;		
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PlayVideoSteps {
	
	WebDriver driver;
	

	@Given("I navigate to youtube")
	public void i_navigate_to_youtube() {

		System.setProperty("webdriver.chrome.driver", "C:\\DiversA\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();
		
		//Mazimize current window
		driver.manage().window().maximize();
		
		//Go to youtube
		driver.get("https://www.youtube.com/");

		//Delay execution for 5 seconds to view the maximize operation
		//Thread.sleep(5000);
		
	}

	@And("I search for \"([^\"]*)\"$")
	public void i_search_for(String videoname) {
		driver.findElement(By.cssSelector("ytd-searchbox")).click();
		driver.findElement(By.cssSelector("ytd-searchbox")).sendKeys(videoname);
		driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/button")).click();	
		
	}

	@When("I click the video")
	public void i_click_the_video() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]")));
		

		WebElement videosearch = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]"));
		videosearch.click();
		
	    
	}

	@Then("The video should be played")
	public void the_video_should_be_played() {
	    WebElement video = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-watch-flexy/div[5]/div[1]/div/div[1]/div/div/div/ytd-player/div/div/div[1]/video"));
	    assert video.isDisplayed()==true;
	    driver.close();
	}

}

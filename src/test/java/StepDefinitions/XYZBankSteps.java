package StepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;		
import java.util.List;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.*;
import java.lang.Thread;

import dev.failsafe.internal.util.Assert;

public class XYZBankSteps {
	
	WebDriver driver;
	
	
	@Given("I go to Bankin Project")
	public void i_go_to_Bankin_Project() {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\DiversA\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();
		//Mazimize current window
				driver.manage().window().maximize();
				
		//Go to XYZBank
				driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@When("I click in Bank Manger Login")
	public void i_click_in_bank_manger_login() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button"))).click();
	   }
	
	@And("I click in Add customer")
	public void i_click_in_add_customer() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]"))).click();
	}


	@And("I fill the firstname with \"([^\"]*)\"$")
	public void i_fill_the_firstname_with(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input"))).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input")).sendKeys(firstname);
		
	}
	
	@And("I fill the lastname with \"([^\"]*)\"$")
	public void i_fill_the_lastname_with(String lastname) {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input")).sendKeys(lastname);
	}
	
	@And("I fill the postalcode with \"([^\"]*)\"$")
	public void i_fill_the_postalcode_with(String postalcode) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input")).sendKeys(postalcode);
		Thread.sleep(3000);
		
	}
	
	@And("I click in Add customer2")
	public void i_click_in_add_customer2() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button")).click();
		Thread.sleep(3000);
	}
	

	@Then("The popup Customer added successfully with customer should be displayed")
	public void the_popup_customer_added_successfully_with_customer_should_be_displayed() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//driver.close();
	}
	

	@And("I click in Customers4")
	public void i_click_in_customers4() {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]"))).click();
	   
	}
	
	@And("I search for the name \"([^\"]*)\"$")
	public void i_search_for_the_name(String firstname) {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input"))).click();
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div/div/input")).sendKeys(firstname);
	    
	}

	@Then("I validate the customer exists4")
	public void i_validate_the_customer_exists() {
		
		WebElement findelement = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr/td[1]"));
		assert findelement.isDisplayed()==true;
		 
		
	}

}

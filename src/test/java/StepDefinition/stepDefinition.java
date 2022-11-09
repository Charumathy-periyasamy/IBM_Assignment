package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class stepDefinition {
	
	
public static	WebDriver driver ;
  String userName = "charu10";	
  String password = "ASDFGHhgfdsa98*" ;
  
  
@Given("I want to lauch the course website")	
public void I_want_to_lauch_the_course_website()
{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\ELCOT\\Documents\\Grid\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.get("http://elearningm1.upskills.in/index.php");


}

@When("Click the Sign Up link")
public void Click_the_Sign_Up_link()
{
	driver.findElement(By.xpath("//ul[@class='nav nav-pills nav-stacked']/li/a[1]")).click();
	driver.manage().window().maximize();
	
}

@And("Enter the mandatory values in the Registration form")
public void Enter_the_mandatory_values_in_the_Registration_form()
{
	driver.findElement(By.name("firstname")).sendKeys("Charumathy");
	driver.findElement(By.name("lastname")).sendKeys("Periyasamy");
	driver.findElement(By.name("email")).sendKeys("charuperiyasamy@gmail.com");
	driver.findElement(By.name("username")).sendKeys(userName);
	driver.findElement(By.name("pass1")).sendKeys(password);
	driver.findElement(By.name("pass2")).sendKeys(password);
	
}

@Then("Click the Register button")
public void Click_the_Register_button()
{
	driver.findElement(By.xpath("//button[@name='submit']")).click();
}

@And("Logout form the website")
public void Logout_form_the_website()
{
	driver.findElement(By.xpath("//a[@title='Logout']")).click();
}

@Given("Enter the sign in credentials")
public void Enter_the_sign_in_credentials()

{
	driver.findElement(By.cssSelector("input#login")).sendKeys(userName);
	driver.findElement(By.cssSelector("input#password")).sendKeys(password);
	
}

@When("Click the sign in button")
public void Click_the_sign_in_button()
{
	driver.findElement(By.xpath("//button[@name='submitAuth']")).click();
}

@And("Enter into the message page and send the email")
public void Enter_into_the_message_page_and_send_the_email() throws InterruptedException
{
	Actions a = new Actions(driver);
	driver.findElement(By.xpath("//li[@class='inbox-message-social']/a")).click();
	driver.findElement(By.xpath("//div[@class='col-md-6']/a[1]")).click();
WebElement sendToBox =	driver.findElement(By.xpath("//input[@placeholder='Please select an option']"));

a.moveToElement(sendToBox).click().sendKeys("abc").build().perform();
Thread.sleep(3000);
WebElement emailOption = driver.findElement(By.xpath("//ul[@class='select2-results__options']/li[1]"));

a.moveToElement(emailOption).click().build().perform();
driver.findElement(By.xpath("//input[@type='text'][1]")).sendKeys("testemail");
driver.findElement(By.xpath("//button[@name='compose']")).click();

}

@Then("validate the success message")
public void validate_the_success_message()
{
	String expectedmessage = "The message has been sent";
String actualmessage = driver.findElement(By.xpath("//div[@class='alert alert-success'][contains(text(),'The message has been sent')]")).getText();	
	
if(actualmessage.contains(expectedmessage)){
	Assert.assertTrue(true);
}
else
{
	Assert.assertTrue(false);
}
	
}
}

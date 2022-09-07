package Steps;



import static org.junit.Assert.assertEquals;

import java.io.ObjectInputFilter.Config;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class loginSteps extends BaseTest {

	
	
	@Before
	public void LoadTestEnviorment() throws Exception 
	{
		BaseTest objbaseTest = new BaseTest();
		objbaseTest.setEnviorment();
		
	}
	@After
	public void quitBrowser() throws Exception 
	{
		driver.quit();
		
	}
	@Given("Browser is Open")	
	public void browser_is_open() throws Exception{

		System.out.println("Inside the Browser");
		
		/*String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();*/
	}

	@And("user is on email page")
	public void user_is_on_email_page() throws InterruptedException{
		
	
		System.out.println("User is on Email Page");
		Thread.sleep(1000);
		String expectedUrl=ConfigProperties.getProperty("EmailPageURL");
		String actURL = driver.getCurrentUrl(); 
		assertEquals(expectedUrl, actURL);

	}

	@When("user enter <username>")
	public void user_enter_username() throws InterruptedException{
		
		WebElement emailtext=driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_TEXT")));
		emailtext.sendKeys(ConfigProperties.getProperty("platformAdminMailID"));
		

	}

	@When("clicks on next button")
	public void clicks_on_next_button() throws InterruptedException{

		driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAILNEXT_BUTTON"))).click();

	}


	@Then("user is on password page")
	public void user_is_on_password_page() throws InterruptedException {
		Thread.sleep(1000);
		String expectedUrl=ConfigProperties.getProperty("PasswordPageURL");
		Thread.sleep(1000);
		String actURL = driver.getCurrentUrl(); 
		assertEquals(expectedUrl, actURL);
		
	
	}

	@When("user enter <password>")
	public void user_enter_password() throws InterruptedException {
		Thread.sleep(1000);
		WebElement passtext=driver.findElement(By.xpath(ConfigObj.getProperty("BY_PASSWORD_TEXT")));
		passtext.sendKeys(ConfigProperties.getProperty("platformAdminPwd"));
		//driver.findElement(By.id("auth_password")).sendKeys("Juntodev@1");//input[@id='auth_password']
		
	}

	@When("clicks on logIn button")
	public void clicks_on_log_in_button()throws InterruptedException {
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAILNEXT_BUTTON"))).click();
		//driver.findElement(By.xpath("//*[@class='primary loginButton']")).click();
		
	}

	@Then("user is navigated to overview  page")
	public void user_is_navigated_to_overview_page()throws InterruptedException {
		Thread.sleep(1000);
		String expectedUrl=ConfigProperties.getProperty("OverviewPageUrl");
		Thread.sleep(2000);
		String actURL = driver.getCurrentUrl(); 
		assertEquals(expectedUrl, actURL);
		Thread.sleep(2000);
	}

	@Then("logout from application")
	public void logout_and_close_the_browser()  throws InterruptedException{

		Thread.sleep(1000);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_LOGOUT_CLASS_BTN"))).click();
		Thread.sleep(1000);
		
	}
	@Then("close the browser")
	public void close_the_browser() throws InterruptedException{
		// Write code here that turns the phrase above into concrete actions
		driver.close();
	}

	@When("user enter invalid <username>")
	public void user_enter_invalid_username()throws InterruptedException {
		
		WebElement emailtext=driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_TEXT")));
		emailtext.sendKeys(ConfigProperties.getProperty("incorrectPlatformAdminMailID"));
		
		
	}
	@When("user enter invalid <password>")
	public void user_enter_invalid_password() throws InterruptedException{
		Thread.sleep(1000);
		WebElement emailtext=driver.findElement(By.xpath(ConfigObj.getProperty("BY_PASSWORD_TEXT")));
		emailtext.sendKeys(ConfigProperties.getProperty("incorrectPlatformAdminPwd"));
		
		
	}
	@Then("user should get error message for Password")
	public void user_should_get_error_message_Password() throws InterruptedException{
	
		String expErrorMsg = "Username or Password not found. Please try again."; //Username or Password not found. Please try again.";
		Thread.sleep(2000);
		String actErrorMsg = driver.findElement(By.xpath(ConfigObj.getProperty("BY_PASSWORD_FIELD_ERROR_MESSAGES"))).getText();//driver.findElement(By.xpath("BY_FIELD_ERROR_MESSAGES")).getText();
		assertEquals(expErrorMsg, actErrorMsg);
		Thread.sleep(1000);
		

	}
	@Then("user should get error message username")
	public void user_should_get_error_message_username() throws InterruptedException{
	
		String expErrorMsg = "User not found. Please try again";
		Thread.sleep(1000);
		String actErrorMsg = driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_FIELD_ERROR_MESSAGES"))).getText();
		assertEquals(expErrorMsg, actErrorMsg);
		Thread.sleep(1000);
	}
	
	
	@When("user does not enter any email address")
	public void blank_user_email_login() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_TEXT"))).sendKeys("");
		Thread.sleep(1000);
	}
	
	@When("user does not enter any password")
	public void blank_password_login() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_PASSWORD_TEXT"))).sendKeys("");
		Thread.sleep(1000);
	}
	
	@Then("user should get an error message for blank email address")
	public void error_for_blank_email_address() throws InterruptedException{
		String expectedError = ConfigProperties.getProperty("BlankEmailError");
		Thread.sleep(1000);
		String actualError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_FIELD_ERROR_MESSAGES_BLANK"))).getText();
		assertEquals(expectedError, actualError);
		Thread.sleep(1000);
	}
	
	@Then("user should get an error message for blank password")
	public void error_for_blank_password() throws InterruptedException{
		String expectedError = ConfigProperties.getProperty("BlankPasswordError");
		Thread.sleep(1000);
		String actualError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_PASSWORD_BLANK_ERROR_MESSAGE"))).getText();
		assertEquals(expectedError, actualError);
		Thread.sleep(1000);
	}

	@When("Clicks on Forgot Password Link")
	public void click_on_forgot_password_link() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_FORGOT_LINK"))).click();
		Thread.sleep(2000);
	}
	
	@Then("User navigates to Forgot Password Page")
	public void user_navigates_to_forgot_password_page() throws InterruptedException{
		String expectedURL = ConfigProperties.getProperty("ForgotPasswordURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@When("User clicks on Back button")
	public void user_clicks_on_back_button() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BACK_IMAGE_BUTTON"))).click();
		Thread.sleep(2000);
	}
	
	@Then("User navigates back to Password Page")
	public void navigate_back_to_password_page() throws InterruptedException{
		String expectedURL = ConfigProperties.getProperty("PasswordPageURL");
		Thread.sleep(1000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);

	}
	
	@Then("User sets an email address")
	public void user_set_an_email() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_FORGOTPASSWORD_TEXT"))).clear();
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_FORGOTPASSWORD_TEXT"))).sendKeys("platformAdminMailID");
		Thread.sleep(1000);
	}
	
	@When("User clicks on Send Reset Link Btn")
	public void user_clicks_on_reset_link_button() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_FORGOTPASSWORD_BUTTON"))).click();
		Thread.sleep(1000);
	}
	
	@Then("User receives a pop up message for sending email")
	public void validate_email_sent_notification() throws InterruptedException{
		String ExpectedNotification = ConfigProperties.getProperty("ForgotPasswordResetNotification");
		WebElement VerifyNotification = driver.findElement(By.xpath(ConfigObj.getProperty("BY_SENT_SUCCESSFULLY")));
		Thread.sleep(1000);
		String ActualNotification = VerifyNotification.getText();
		assertEquals(ExpectedNotification, ActualNotification);
	}


}

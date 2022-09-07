package Steps;

import static org.junit.Assert.assertEquals;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Utils.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.hssf.extractor.ExcelExtractor;

public class PlatformUser extends BaseTest{
	
	
	@When("user click on BibliothecaUser")
	public void user_click_on_bibliotheca_user() throws InterruptedException{		
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIBLIOTHECAUSER_LINK_ClASS"))).click();
		
		
	}

	@Then("user is navigated to UserList page")
	public void user_is_navigated_to_user_list_page()throws InterruptedException {
		Thread.sleep(1000);
		String expectedUrl=ConfigProperties.getProperty("UserListURL");
		String actURL = driver.getCurrentUrl(); 
		assertEquals(expectedUrl, actURL);

	}
	@Then("click on Add user")
	public void click_on_add_user() throws InterruptedException{
		Thread.sleep(1000);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIB_ADDUSER_BTN"))).click();
		
	}

	@Then("user is navigated to AddUser page")
	public void user_is_navigated_to_add_user_page() throws InterruptedException{
		Thread.sleep(1000);
		String expectedUrl=ConfigProperties.getProperty("AddUserURL");
		String actURL = driver.getCurrentUrl(); 
		System.out.println(actURL);
		assertEquals(expectedUrl, actURL);
		Thread.sleep(1000);
	}
	
	@Then("User Data to Page")
	public void data_to_page() throws InterruptedException {
		
		String Fullname = ConfigProperties.getProperty("Fullname");
		String email = ConfigProperties.getProperty("email");
		String ContactNumber = ConfigProperties.getProperty("ContactNumber");
		
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_FULLNAME_TEXT"))).sendKeys(Fullname);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_USEREMAIL_TEXT"))).sendKeys(email);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_PHONE_TEXT"))).sendKeys(ContactNumber);
		Thread.sleep(2000);
		
		WebElement objWebElementRole =  driver.findElement(By.xpath(ConfigObj.getProperty("BY_ROLE_DROPDOWN")));
		Thread.sleep(2000);
		objWebElementRole.sendKeys("Bibliotheca User");
		objWebElementRole.sendKeys(Keys.ARROW_DOWN);
		objWebElementRole.sendKeys(Keys.ENTER);
		objWebElementRole.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		
		//location Selection
		WebElement objWebElementLoc =  driver.findElement(By.xpath(ConfigObj.getProperty("BY_LOC_SELECT")));
		Thread.sleep(1000);
		objWebElementLoc.sendKeys(Keys.SPACE);
		Thread.sleep(1000);
				
		
		
	}

	@Then("Click on Save")
	public void click_on_save() throws InterruptedException{
	   
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_ADDUSER_BTN"))).click();
		Thread.sleep(1000);
		
	}

	@Then("User is navigated to UserList")
	public void user_is_navigated_to_user_list() throws InterruptedException {
		Thread.sleep(1000);
		
		String expectedUrl=ConfigProperties.getProperty("UserListURL");
		String actURL = driver.getCurrentUrl(); 
		System.out.println(actURL);
		assertEquals(expectedUrl, actURL);
		Thread.sleep(1000);
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("click on Search Icon")
	public void click_on_search_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendsssingException();
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIBUSER_SEARCH_BTN"))).click();
	}
	
	@And("Enter Search Text")
	public void Enter_Search_Text() throws InterruptedException{
		
				
		
		WebElement searchText =  driver.findElement(By.xpath(ConfigObj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(ConfigProperties.getProperty("validBibUserSearch"));
		
				
	}
	@And("Enter invalid Search Text")
public void Enter_invalid_Search_Text() throws InterruptedException{
		
				
		
		WebElement searchText =  driver.findElement(By.xpath(ConfigObj.getProperty("BY_SEARCH_TEXT")));
		searchText.sendKeys(ConfigProperties.getProperty("invalidBibUserSearch"));
		
				
	}

	    
	@Then("Result Not found Based on Search Criteria")
	public void result_not_found_based_on_search_criteria() throws InterruptedException{
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(1000);
	    String expectedSearchVal=ConfigProperties.getProperty("invalidBibUserSearch").toUpperCase();
		String strresult = "Fail";
		Thread.sleep(3000);
		String actualSearchText = driver.findElement(By.xpath(ConfigObj.getProperty("BY_NOUSER_FOUND"))).getText();
		Thread.sleep(1000);
		actualSearchText = actualSearchText.toUpperCase();
		expectedSearchVal = expectedSearchVal.toUpperCase();
		if(!actualSearchText.contains(expectedSearchVal))
			{
				strresult = "Pass";
			}
			assertEquals(strresult,"Pass");
			Thread.sleep(1000);
	}

	@Then("Result is Displayed Based on Search Criteria")
	public void result_is_displayed_based_on_search_criteria() throws InterruptedException{
		String expectedSearchVal=ConfigProperties.getProperty("validBibUserSearch").toUpperCase();
		String strresult = "Fail";
		Thread.sleep(2000);
		String actualSearchText = driver.findElement(By.xpath(ConfigObj.getProperty("BY_SEARCHED_USER"))).getText();
		actualSearchText = actualSearchText.toUpperCase();
		expectedSearchVal = expectedSearchVal.toUpperCase();
		System.out.println(expectedSearchVal);
		System.out.println("Actual: "+actualSearchText);
		if(actualSearchText.contains(expectedSearchVal))
				{
				strresult = "Pass";
				
				}
		
			assertEquals(strresult,"Pass");
			Thread.sleep(1000);
	    // Write code here that turns the phrase above into concrete actions
	    //
}

	@Then("Validate Full Name TextField")
	public void blank_full_name_text() throws InterruptedException{
		WebElement FullNameError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_FULLNAME_ERROR_MSG")));
		String ExpectedFullNameError = ConfigProperties.getProperty("ExpectedFullNameBlankError");
		Thread.sleep(1000);
		String ActualFullNameError = FullNameError.getText();
		assertEquals(ExpectedFullNameError, ActualFullNameError);
	}
	
	@Then("Validate Email Textfield")
	public void blank_email_text() throws InterruptedException{
		WebElement EmailError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_EMAIL_REQ_ERROR_MSG")));
		String ExpectedEmailError = ConfigProperties.getProperty("ExpectedEmailBlankError");
		Thread.sleep(1000);
		String ActualEmailError = EmailError.getText();
		assertEquals(ExpectedEmailError, ActualEmailError);
	}
	
	@Then("Validate Phone Textfield")
	public void blank_phone_text() throws InterruptedException{
		WebElement PhoneError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_PHONE_REQ_ERROR_MSG")));
		String ExpectedPhoneError = ConfigProperties.getProperty("ExpectedPhoneBlankError");
		Thread.sleep(1000);
		String ActualPhoneError = PhoneError.getText();
		assertEquals(ExpectedPhoneError, ActualPhoneError);
	}
	
	@Then("Validate Role Drop Down")
	public void blank_role_drop_down() throws InterruptedException{
		WebElement RoleError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_ROLE_ERROR_MSG")));
		String ExpectedRoleError = ConfigProperties.getProperty("ExpectedRoleBlankError");
		Thread.sleep(1000);
		String ActualRoleError = RoleError.getText();
		assertEquals(ExpectedRoleError, ActualRoleError);
	}
	
	@Then("Validate Location Textfield")
	public void blank_role_text() throws InterruptedException{
		WebElement LocError = driver.findElement(By.xpath(ConfigObj.getProperty("BY_LOC_ERROR_MSG")));
		String ExpectedLocError = ConfigProperties.getProperty("ExpectedLocBlankError");
		Thread.sleep(1000);
		String ActualLocError = LocError.getText();
		assertEquals(ExpectedLocError, ActualLocError);
	}
	
	@When("User selects a user card")
	public void user_selects_a_user_card() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIBUSER_CARDVIEW"))).click();
		Thread.sleep(2000);
	}
	
	@Then("User navigates to User Profile")
	public void navigation_to_user_profile() throws InterruptedException{
		Thread.sleep(1000);
		String expectedURL = ConfigProperties.getProperty("EditUserURL");
		Thread.sleep(1000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@Then("User edits Full Name")
	public void edit_user_name() throws InterruptedException{
		WebElement ChangeUserName = driver.findElement(By.xpath(ConfigObj.getProperty("BY_USERNAME_TEXT")));
		ChangeUserName.sendKeys(Keys.CONTROL+"a");
		ChangeUserName.sendKeys(Keys.DELETE);
		ChangeUserName.sendKeys(ConfigProperties.getProperty("EditUserName"));
		Thread.sleep(1000);
	}
	
	@Then("User edits Phone Number")
	public void edit_user_phone() throws InterruptedException{
		WebElement ChangeUserPhone = driver.findElement(By.xpath(ConfigObj.getProperty("BY_USERPHONE_TEXT")));
		ChangeUserPhone.sendKeys(Keys.CONTROL+"a");
		ChangeUserPhone.sendKeys(Keys.DELETE);
		ChangeUserPhone.sendKeys(ConfigProperties.getProperty("EditUserPhone"));
		Thread.sleep(1000);
	}
	
	@When("User clicks on Apply Changes")
	public void ClickOnApplyChangesButton() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_APPLY_CHANGES_BUTTON"))).click();
	}
	
	@Then("Verify navigation for valid edit")
	public void ValidateRedirectiononValidEditing() throws InterruptedException{
		Thread.sleep(2000);
		String expectedURL = ConfigProperties.getProperty("UserListURL");
		Thread.sleep(1000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@Then("Verify navigation for invalid edit")
	public void ValidateRedirectiononInvalidEdit() throws InterruptedException{
		String expectedURL = ConfigProperties.getProperty("EditUserURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@When("User clicks on a user card to cancel remove")
	public void user_clicks_on_a_user_card_to_remove() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_USER_CARD_TEXT"))).click();
		Thread.sleep(1000);
	}
	
	@When("Users clicks on invited user card")
	public void ClickOnInvitedUserCard() throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIB_INVITED_USER_CARD"))).click();
		String expectedURL = ConfigProperties.getProperty("EditUserURL");
		Thread.sleep(2000);
		String actualURL =  driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@When("User clicks on Invited User Delete icon")
	public void ClickOnInvitedDeleteIcon() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIB_INVITED_USER_DELETE_ICON"))).click();
		WebElement RemoveModalText = driver.findElement(By.xpath(ConfigObj.getProperty("BY_REM_USER_TEXT")));
		String expectedRemoveText = ConfigProperties.getProperty("removeUserText");
		Thread.sleep(2000);
		String actualRemoveText = RemoveModalText.getText();
		assertEquals(expectedRemoveText, actualRemoveText);
	}
	
	@When("User clicks on Active User Delete icon")
	public void ClickonDeleteIcon() throws InterruptedException{
		driver.findElement(By.xpath(ConfigObj.getProperty("BY_BIB_USER_DELETE_ICON"))).click();
		WebElement RemoveModalText = driver.findElement(By.xpath(ConfigObj.getProperty("BY_REM_USER_TEXT")));
		String expectedRemoveText = ConfigProperties.getProperty("removeUserText");
		Thread.sleep(2000);
		String actualRemoveText = RemoveModalText.getText();
		assertEquals(expectedRemoveText, actualRemoveText);
	}
	
	@When("User clicks on confirm button")
	public void ClickonConfirmButton() throws InterruptedException{
		WebElement ConfirmButton = driver.findElement(By.xpath(ConfigObj.getProperty("BY_CONFIRM_BUTTON")));
		ConfirmButton.click();
		String expectedURL = ConfigProperties.getProperty("UserListURL");
		Thread.sleep(2000);
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
	@When("User clicks on cancel button")
	public void ClickonCancelButton() throws InterruptedException{
		WebElement CancelButton = driver.findElement(By.xpath(ConfigObj.getProperty("BY_CANCEL_BUTTON")));
		CancelButton.click();
		String expectedURL = ConfigProperties.getProperty("EditUserURL");
		String actualURL = driver.getCurrentUrl();
		assertEquals(expectedURL, actualURL);
	}
	
}
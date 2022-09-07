Feature: To test login functionality

 @validLogin
 Scenario: User is  able login with valid credentials
 		Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    Then logout from application
    Then close the browser
    
  
    
   @invalidemail 
  Scenario: User is  able login with invalid email
 		Given Browser is Open
    And user is on email page
    When user enter invalid <username>
    And clicks on next button
    Then user should get error message username
    Then close the browser
    
  @invalidPassword
  Scenario: User is  able login with invalid password
 		Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter invalid <password>
    And clicks on logIn button
    Then user should get error message for Password
    Then close the browser
  
  @blankEmail
  Scenario: User is able to logn with blank email
  	Given Browser is Open
  	And user is on email page
  	When user does not enter any email address
  	And clicks on next button
  	Then user should get an error message for blank email address
  	Then close the browser
  
  @blankPassword
  Scenario: User is able to login with blank password
  	Given Browser is Open
  	And user is on email page
  	When user enter <username>
  	And clicks on next button
  	And user is on password page
  	When user does not enter any password
  	And clicks on logIn button
  	Then user should get an error message for blank password
  	Then close the browser
  
  @backbuttononforgotpassword
  Scenario: User is able to navigate back from forgot password screen
  	Given Browser is Open
  	And user is on email page
  	When user enter <username>
  	And clicks on next button
  	And user is on password page
  	When Clicks on Forgot Password Link
  	Then User navigates to Forgot Password Page
  	When User clicks on Back button
  	Then close the browser
  	
  @sendpasswordresetlink
  Scenario: User is able to send password reset link
  	Given Browser is Open
  	And user is on email page
  	When user enter <username>
  	And clicks on next button
  	And user is on password page
  	When Clicks on Forgot Password Link
  	Then User navigates to Forgot Password Page
  	When User clicks on Send Reset Link Btn
  	Then User receives a pop up message for sending email
  	Then close the browser
  #
  #
  #
  #

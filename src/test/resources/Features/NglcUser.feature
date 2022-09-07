Feature: To test user functionality

 		@UserList
    Scenario: user click on BibliothecaUser
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    Then logout from application
    Then close the browser
    
    @ClickAddUserButton
    Scenario: User is not able Click on AddUser
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    Then click on Add user
    Then user is navigated to AddUser page
    Then logout from application
    Then close the browser 
    
    @AddNewUser
    Scenario: User is able Add on AddUserDeatils
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    Then click on Add user
    Then user is navigated to AddUser page
    And User Data to Page     
  	Then Click on Save
    Then User is navigated to UserList
    Then logout from application
    Then close the browser
    
  
    @UserSearch
    Scenario: User is able to Search Users from UserList
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    And click on Search Icon 
    Then Enter Search Text
    And Result is Displayed Based on Search Criteria
    Then logout from application
    Then close the browser  
    
    @InvalidUserSearch
    Scenario: User is not able to Search Users from UserList
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    And click on Search Icon 
    Then Enter invalid Search Text
    And Result Not found Based on Search Criteria
    Then logout from application
    Then close the browser  
 
 
    @AddUserRequiredFieldsValidation
    Scenario: User does not enter any required data
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    Then click on Add user
    Then Click on Save
    Then Validate Full Name TextField
    Then Validate Email Textfield
    Then Validate Phone Textfield
    Then Validate Role Drop Down
    Then Validate Location Textfield
    Then logout from application
    Then close the browser
    
    @EditUserVerification
    Scenario: User is able to edit other user details
    Given Browser is Open
    And user is on email page
    When user enter <username>
    And clicks on next button
    And user is on password page
    When user enter <password>
    And clicks on logIn button
    Then user is navigated to overview  page
    When user click on BibliothecaUser
    Then user is navigated to UserList page
    When User selects a user card
    Then User navigates to User Profile
    Then User edits Full Name
    Then User edits Phone Number
    When User clicks on Apply Changes
    Then Verify navigation for valid edit
    Then logout from application
    Then close the browser
    
    @ConfirmRemoveUser
    Scenario: User is able to remove a user
      Given Browser is Open
    	And user is on email page
    	When user enter <username>
    	And clicks on next button
    	And user is on password page
    	When user enter <password>
    	And clicks on logIn button
    	Then user is navigated to overview  page
    	When user click on BibliothecaUser
    	Then user is navigated to UserList page
    	Then Users clicks on invited user card
    	Then User clicks on Invited User Delete icon
    	When User clicks on confirm button
    	Then logout from application
    	
    @CancelRemoveUser
    Scenario: User is able to cancel the removal a user
      Given Browser is Open
    	And user is on email page
    	When user enter <username>
    	And clicks on next button
    	And user is on password page
    	When user enter <password>
    	And clicks on logIn button
    	Then user is navigated to overview  page
    	When user click on BibliothecaUser
    	Then user is navigated to UserList page
    	Then User clicks on a user card to cancel remove
    	Then User navigates to User Profile
    	Then User clicks on Active User Delete icon
    	When User clicks on cancel button
    	Then logout from application
    
    
    
    
    
    
    
    
    
    
    #
   #
   
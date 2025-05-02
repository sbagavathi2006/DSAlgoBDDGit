
@afterSignIn
Feature: Lougout

 Background: 
 Given user is on the graph page after clicks Get Started button on Graph panel
   
 Scenario: Verify that user is able to navigate to Signout button 
	Given The user is in the Graph page 
	When The user clicks on Signout	
	Then The user be directed to Home page
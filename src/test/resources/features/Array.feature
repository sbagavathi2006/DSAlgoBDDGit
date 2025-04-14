Feature: ArrayLanding
Background:
	Given User is on array page after clicks on Get Started button on Array flex
	
  Scenario: User lands on Arrays in Python page
  	When User clicks on Arrays in Python link
    Then User redirected on arrays in python page
       
  Scenario: User lands on Arrays Using List page
  	When User clicks on Arrays Using List link
    Then User redirected on arrays using list page
    
  Scenario: User lands on Basic Operations in Lists page
  	When User clicks on Basic Operations in Lists link
    Then User redirected on basic operations in lists page
       
  Scenario: User lands on Applications of Array page
  	When User clicks on Applications of Array link 
    Then User redirected on applications of array page
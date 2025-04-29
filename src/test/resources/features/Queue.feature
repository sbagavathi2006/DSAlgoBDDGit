
@afterSignIn
Feature: Queue

Background:
Given User is on Queue page after clicks on Get Started button on Queue flex

   Scenario Outline: User lands on "<pages>" page for Queue
   	When User clicks on "<links>" link for Queue
    Then User redirected to "<pages>" page for Queue
    Examples:
    | links                                  | pages                     |
    | Implementation of Queue in Python      |implementation-lists    	 |
    | Implementation using collections.deque |implementation-collections |
    |Implementation using array              |Implementation-array       |
    |Queue Operations                        |QueueOp                    |
@DSAlgoPortal
Feature: DSAlgoPortal

  Scenario: User is able to open the dsAlgo Portal
    Given User has browser open
    When User enter correct dsAlgo portal URL
    Then User is redirected to dsAlgo portal with Get Started button enabled
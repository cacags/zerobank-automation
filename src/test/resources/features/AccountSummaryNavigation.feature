Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user is logged in

  Scenario: Savings	account	redirect
    When the user clicks on "Savings" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Savings" selected

  Scenario: Brokerage account redirect
    When the user clicks on "Brokerage" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    When the user clicks on "Checking" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    When the user clicks on "Credit Card" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Credit Card" selected

  Scenario: Loan Card account redirect
    When the user clicks on "Loan" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "Loan" selected

  #Data driven test is implemented. Added on 25th October 2020.
  #Instead of the above scenarios the following DDT scenario can be used.

  Scenario Outline: "<accountTypes>" account redirect
    When the user clicks on "<accountTypes>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<accountTypes>" selected
    Examples:

      | accountTypes |
      | Savings      |
      | Brokerage    |
      | Checking     |
      | Credit Card  |
      | Loan         |




Feature: Pay Bills

  Background:
    Given the user is logged in
    Then the user click the "Pay Bills" tab

  Scenario: Successful payment
    Then the user choose "Bank of America" as a Payee from dropdown options
    Then the user choose "Loan" as an Account from dropdown options
    Then the user enters "100" as an amount of payment
    Then the user enters "2020-10-26" as a date
    Then user enters "Car Repair" as a description
    When the user enter the pay button
    Then the user should see "The payment was successfully submitted." message
  @wip
  Scenario: Unsuccessful payment without amount
    Then the user choose "Bank of America" as a Payee from dropdown options
    Then the user choose "Loan" as an Account from dropdown options
    Then the user enters "2020-10-26" as a date
    Then user enters "Car Repair" as a description
    When the user enter the pay button
    Then "Please fill out this field." message in amount box should pop-up

  Scenario: Unsuccessful payment without date
    Then the user choose "Bank of America" as a Payee from dropdown options
    Then the user choose "Loan" as an Account from dropdown options
    Then the user enters "100" as an amount of payment
    Then user enters "Car Repair" as a description
    When the user enter the pay button
    Then "Please fill out this field." in date box message should pop-up

  Scenario: Date field should not accept alphabetical characters
    Then the user enters "TEST_DATA" as a date
    Then in data field there should't be any alphabetical characters
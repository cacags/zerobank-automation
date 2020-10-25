@wip
Feature: Login

  Scenario: Only authorized users should login
    Given the user is on the Login Page
    When the user enters "username" and "password"
    Then the "Account Summary" page should be displayed

  Scenario: User with wrong username should not login
    Given the user is on the Login Page
    When the user enters "asd" and "password"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with wrong password should not login
    Given the user is on the Login Page
    When the user enters "username" and "asd"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with blank username should not login
    Given the user is on the Login Page
    When the user enters "" and "password"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with blank password should not login
    Given the user is on the Login Page
    When the user enters "username" and ""
    Then Error message "Login and/or password are wrong." should be displayed

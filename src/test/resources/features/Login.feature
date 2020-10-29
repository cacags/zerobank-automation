Feature: Login

  Background:
    Given the user is on the Login Page

  Scenario: Only authorized users should login
    When the user enters "username" and "password"
    Then the "Account Summary" page should be displayed

  Scenario: User with wrong username should not login
    When the user enters "asd" and "password"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with wrong password should not login
    When the user enters "username" and "asd"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with blank username should not login
    When the user enters "" and "password"
    Then Error message "Login and/or password are wrong." should be displayed

  Scenario: User with blank password should not login
    When the user enters "username" and ""
    Then Error message "Login and/or password are wrong." should be displayed

  #Data driven test is implemented. Added on 29th October 2020.
  #Instead of the above scenarios the following DDT scenario can be used.

  Scenario Outline: User shouldn't be able to login with wrong  credentials <username>
    When the user enters "<username>" and "<password>"
    Then Error message "<message>" should be displayed

    Examples:
      | username | password | message                          |
      | asd      | password | Login and/or password are wrong. |
      | username | asd      | Login and/or password are wrong. |
      | asd      | asd      | Login and/or password are wrong. |
      |          | password | Login and/or password are wrong. |
      | username |          | Login and/or password are wrong. |
      |          |          | Login and/or password are wrong. |


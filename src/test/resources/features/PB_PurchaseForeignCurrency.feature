Feature: Purchase Foreign Currency

  Background:
    Given the user is logged in
    Then the user click the "Pay Bills" tab

  Scenario: Available currencies
    Given "Purchase Foreign Currency" tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |

  Scenario Outline: Error message for not selecting currency
    Given "Purchase Foreign Currency" tab
    When user tries to calculate cost without selecting a currency
    Then error message "<errorMessage>" should be displayed
    Examples:
      | errorMessage                                                                   |
      | Please, ensure that you have filled all the required fields with valid values. |


  Scenario Outline: Error message for not entering value
    Given "Purchase Foreign Currency" tab
    When user tries to calculate cost without entering a value
    Then error message "<errorMessage>" should be displayed
    Examples:
      | errorMessage                                                                   |
      | Please, ensure that you have filled all the required fields with valid values. |
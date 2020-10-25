Feature: Purchase Foreign Currency

  Background:
    Given the user is logged in
    Then the user click the "Pay Bills" tab

  Scenario: Available currencies
    Given "Purchase Foreign Currency" tab
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland(franc)    |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |


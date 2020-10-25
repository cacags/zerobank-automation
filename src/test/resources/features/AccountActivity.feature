Feature: Account Activity
  @wip
  Scenario: Account activity page title and dropdown box
    Given the user is logged in
    Then the user accesses the "Account Activity" tab
    Then the page should have the title "Zero - Account Activity"
    Then the account dropdown should see the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then Transactions table should have column names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


@accountSummary @test
Feature: Account Summary

  Scenario: Account Summary title and account types
    Given the user is logged in
    Then the user click the "Account Summary" tab
    Then the page should have the title "Zero - Account Summary"
    Then the user should see following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And "Credit Accounts" table must have following columns
      | Account     |
      | Credit Card |
      | Balance     |

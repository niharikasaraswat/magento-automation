Feature: Magento Sign Up Flow

  Background:
    Given I am on the Magento sign-up page

  Scenario: Submit form with all fields blank
    When I click on the Create an Account button
    Then I should see validation messages for required fields

  Scenario: Sign up with invalid email
    When I fill the sign-up form with "Niharika" "Test" "invalidemail" "Test@123" "Test@123"
    And I click on the Create an Account button
    Then I should see an email validation error

  Scenario: Password and Confirm Password do not match
    When I fill the sign-up form with "Niharika" "Test" "niharika@example.com" "Test@123" "Wrong@123"
    And I click on the Create an Account button
    Then I should see password mismatch error

  Scenario: Successful Sign Up
    When I fill the sign-up form with "Niharika" "Test" "niharika<timestamp>@example.com" "Test@123" "Test@123"
    And I click on the Create an Account button
    Then I should be redirected to the dashboard

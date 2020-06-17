Feature: Free Car Check website - Any user can Free Car Check from Website

  Scenario: Browse Free Car tax Check website
    Given I have registration numbers from a file
    And I navigate to "https://cartaxcheck.co.uk/" website
    When I check registration numbers
    Then Vehicle identity results are as expected
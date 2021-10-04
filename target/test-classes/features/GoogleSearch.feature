Feature: Google Search by any search criteria
    Existing search
  Scenario: Google Search with go to first result element
    Given User opens Chrome browser
    When User enters Search criteria as <criteria>
    And Click on Search button
    Then Validate Search results
    When User click on the First Search result element
    Then Validate Search result First element
    And close browser


    |criteria         |
    |Page Object Model|
    
    
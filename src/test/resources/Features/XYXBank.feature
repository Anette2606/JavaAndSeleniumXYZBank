Feature: XYZ Steps

  Scenario Outline: XYZBankSteps
    Given I go to Bankin Project
    When I click in Bank Manger Login
    And I click in Add customer
    And I fill the firstname with "<firstname>"
    And I fill the lastname with "<lastname>"
    And I fill the postalcode with "<postalcode>"
    And I click in Add customer2
    Then The popup Customer added successfully with customer should be displayed
    And I click in Customers4
    And I search for the name "<firstname>"
    Then I validate the customer exists4

    Examples: 
      | firstname | lastname | postalcode |
      | Anette    | Avila    |      20000 |
      | Fernanda  | Silva    |      30000 |

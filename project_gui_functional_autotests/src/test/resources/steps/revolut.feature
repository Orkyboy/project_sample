@Inbox @Batch1
Feature: Inbox feature

  Scenario: Check log in
    Given I skip login info
    And I log in as default user
    And I enter SMS code
    And I skip all info by 'Not now' button
    Then Main Page is displayed

    Scenario: Check add a new beneficiary flow
      Given I am on the Main Page
      When I click transfer button
      When I select "To bank account" option
      When I skip login info
      When I press on 'Add a new beneficiary' button
      #Then 'Add a new beneficiary' button is displayed


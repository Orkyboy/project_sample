@Batch1
Feature: Adding of beneficiary checking

  @TestCaseId("1") @SeverityLevel.BLOCKER @LoginComponent
  Scenario: Check log in
    Given I skip login info
    And I log in as default user
    And I enter SMS code
    And I skip all info by 'Not now' button
    Then Main Page is displayed

  @TestCaseId("2") @SeverityLevel.BLOCKER @Beneficiary @PressDoneIfNot
  Scenario: Check add a new beneficiary flow
    Given I am on the Main Page
    When I click transfer button
    When I select "To bank account" option
    When I skip login info
    When I press on 'Add a new beneficiary' button
    #Then 'Add a new beneficiary' button is displayed - no btn found
    When I choose "To myself" transfer type
    When I click 'Next' button
    #TODO more logic for next two steps required (eg. BIC/SWIFT code typing)
    #When I select random country
    #When I select random currency
    When I click 'Next' button
    When I type random first name
    When I type random last name
    When I type random account number
    When I type random sort code
    When I click 'Next' button
    When I type security code
    When I enter SMS code
    Then 'Successfully Created' message is displayed with right name
    And I click 'Done' button
    Then first beneficiary item contains newly created information

  @TestCaseId("2") @SeverityLevel.BLOCKER
  Scenario: fail
    Given fail
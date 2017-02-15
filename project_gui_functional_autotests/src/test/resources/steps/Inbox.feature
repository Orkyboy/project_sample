@Inbox @Batch1
Feature: Inbox feature

  @LogoutFromMailPageHeaderAfter
  Scenario: Check that letter in inbox with selected name is displayed
    Given I am on the mail page
    When I login as "yatestexample@yandex.ru" user from mail page
    When I open letter with title "Как читать почту с мобильного"
    Then Letter title is displayed and valid
    And Letter body is displayed

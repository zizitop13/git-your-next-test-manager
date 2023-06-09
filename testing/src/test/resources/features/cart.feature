@issue=2
Feature: Cart Management
  As a user, I want to have the ability to reset the entire cart with a single button press.

  Scenario: Resetting the cart for four items
    Given I have filled the cart with all available items
    When I click the "reset" button
    Then the quantity of items in the cart will be 0
    And the quantity of units for all items will be 0
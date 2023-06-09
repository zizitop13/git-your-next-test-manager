@issue=1
Feature: Management of item quantity
  As a user, I want to be able to add, decrease, and remove items,
  see the quantity of items in the cart, and the quantity of units for each added item.

  Scenario: Adding an item
    When I add the 1st item 3 times
    Then the quantity of units for the 1st item is 3
    And the quantity of items in the cart is 1

  Scenario: Adding two items
    When I click the plus button for the 1st item 3 times
    And I click the plus button for the 2nd item 5 times
    Then the quantity of items in the cart is 2

  Scenario: Decreasing item quantity
    When I click the plus button for the 1st item 3 times
    And I click the minus button for the 1st item 2 times
    Then the quantity of units for the 1st item is 1
    And the quantity of items in the cart is 1

  Scenario: Removing an item
    When I click the plus button for the 1st item 1 time
    And I click the minus button for the 1st item 1 time
    Then the quantity of items in the cart is 0
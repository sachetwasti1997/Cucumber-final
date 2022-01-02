Feature: feature for adding item to cart
  Scenario Outline: product is added to cart and the cart shows product name and quantity
    Given I'm on the Store page
    When I add a "<product_name>" in the cart
    Then I see 1 "<product_name>" in the cart

    Examples:
      | product_name |
      | Blue Shoes   |
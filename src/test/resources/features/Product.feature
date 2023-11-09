@Product
Feature: Product feature

  Background: User successfully login
    Given user is in Login page
    When user input the valid credentials and click login button
    Then user can successfully login

  Scenario: User can successfully add product to the cart
    When user click Add to cart button in the homepage
    Then user successfully added the product to the cart

  Scenario: User can successfully remove product from the cart
    When user click Add to cart button in the homepage
    And user click Remove button in the homepage
    Then user successfully remove the product from the cart

  Scenario: User can go to product detail page
    When user click one of the product in the homepage
    Then user can go to product detail page
    
  Scenario: User can filter product
  	When user click filter button and select one of the filter
  	Then user can see the homepage filtered by the selected filter
  	
  Scenario: User can compare the product image
  	Then user see the product image and can compare the image

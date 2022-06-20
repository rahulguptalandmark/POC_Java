Feature: Electricity Meter Registration

  Scenario: 1 : Creating a electricity meter
    Given I have a Meter Point Number
    When I call the Electricity meter creation service
    Then New Meter is created
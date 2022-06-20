Feature: Electricity Meter Registration

  Scenario: 1 : Register a electricity meter
    Given I have a Meter Point Number
    When I call the Electricity meter registration service
    Then New Meter is register
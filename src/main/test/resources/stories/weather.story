Scenario: Check weather in a specific city.
Given I am going to request the weather temperature in a specific city.
When I request current weather in London.
Then I should receive a successful response.
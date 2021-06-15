Feature: Delete Pet

  Background:
    Given a existing pet
      | id   | name     | categoryId | categoryName | photoUrls | tagId | tagName  | status    |
      | 1234 | demo-pet | 1          | demo-name    | some-url  | 1     | demo-tag | available |

  Scenario: Delete existing pet
    When I request to delete pet with id 1234
    Then I should get status as 200
  # Not possible due to mock server   Then I should get status as 404
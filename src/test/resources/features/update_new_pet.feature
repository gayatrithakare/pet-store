Feature: Update Pet

  Background:
    Given a existing pet
      | id   | name     | categoryId | categoryName | photoUrls | tagId | tagName  | status    |
      | 1234 | demo-pet | 1          | demo-name    | some-url  | 1     | demo-tag | available |

  Scenario: Update existing pet's name
    When I request to update name to "updated-name"
    Then pet should have new name "updated-name"

  Scenario: Update existing pet's category
    When I request to update category to 2 and category name to "updated-category-name"
    Then pet should have new category id 2 and category name "updated-category-name"

  Scenario: Update existing pet's tags
    When I request to add below tags to pet
      | 1,tag1 |
      | 2,tag2 |
      | 3,tag3 |
      | 4,tag4 |
    Then pet should have new 5 number of tags

  Scenario: Update existing pet's photo urls
    When I request to add below photo urls to pet
      | url1 |
      | url2 |
      | url3 |
      | url4 |
    Then pet should have new 5 number of photoUrls

  Scenario: Update existing pet's status
    When I request to update status to "not available"
    Then pet should have status as  "not available"

  Scenario: Update existing pet's status
    When I request to update status to "not available"
    Then pet should have status as  "not available"
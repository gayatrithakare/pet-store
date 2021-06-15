Feature: Create new pet

  Scenario Outline: Create new pet
    Given A valid pet
      | id   | name   | categoryId    | categoryName    | photoUrls    | tagId    | tagName    | status   |
      | <ID> | <NAME> | <CATEGORY_ID> | <CATEGORY_NAME> | <PHOTO_URLS> | <TAG_ID> | <TAG_NAME> | <STATUS> |
    When I request to create pet resource
    Then i should find new pet resource
    Examples:
      | ID | NAME   | CATEGORY_ID | CATEGORY_NAME | PHOTO_URLS | TAG_ID | TAG_NAME | STATUS    |
      | 12 |        |             |               |            |        |          |           |
      | 12 | doggie |             |               |            |        |          |           |
      | 12 | doggie | 1           |               |            |        |          |           |
      | 12 | doggie | 1           | available     |            |        |          |           |
      | 12 | doggie | 1           | available     |            |        |          |           |
      | 12 | doggie | 1           | available     | string     |        |          |           |
      | 12 | doggie | 1           | available     | string     | 0      |          |           |
      | 12 | doggie | 1           | available     | string     | 0      | string   |           |
      | 12 | doggie | 1           | available     | string     | 0      | string   | available |

  Scenario Outline: Create new pet with multiple photo urls
    Given A valid pet
      | id   | name   | categoryId    | categoryName    | photoUrls    | tagId    | tagName    | status   |
      | <ID> | <NAME> | <CATEGORY_ID> | <CATEGORY_NAME> | <PHOTO_URLS> | <TAG_ID> | <TAG_NAME> | <STATUS> |
    When I request to create pet resource
    Then newly created resource should have photo-url size have <SIZE>
    Examples:
      | ID | NAME   | CATEGORY_ID | CATEGORY_NAME | PHOTO_URLS                       | TAG_ID | TAG_NAME | STATUS    | SIZE |
      | 12 | doggie | 1           | available     | photo-url2,photo-url2,photo-url3 | 0      | string   | available | 3    |
      | 12 | doggie | 1           | available     | photo-url2,photo-url2            | 0      | string   | available | 2    |




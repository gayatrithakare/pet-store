Feature: Search existing pet

  Scenario Outline: Search pet by status
    Given I search pet with status "<PET_STATUS>"
    Then  I should find total <NUMBER> of pets
    Examples:
      | PET_STATUS | NUMBER |
      | available  | 8      |
      | pending    | 2      |
      | sold       | 1      |

  Scenario Outline: Search pet by Tags
    Given I search pet with tag "<TAGS>"
    Then  I should find <NUMBER> pets with tags
    Examples:
      | TAGS | NUMBER |
      | tag1 | 3      |
      | tag2 | 6      |
      | tag3 | 7      |
      | XXXX | 0      |







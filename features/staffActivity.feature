#Feature: Staff activity
#  Description: A user staffs an activity
#  Actors: User
#
#  Scenario: A user staffs an activity succesfully
#    Given that the user with the initials "ABCD" is the manager of the project
#    And the activity named "testing" is not staffed
#    And the given employee named "POPO" is available
#    When the user "ABCD" staffs the employee "POPO" to the activity "testing"
#    Then the employee "POPO" is staffed to the activity "testing"
#
#  Scenario: A user staffs an activity when the user is not the projectmanager
#    Given that the user with the initials "ABCD" is not the manager of the project
#    And the activity named "testing" is not staffed
#    And the given employee named "POPO" is available
#    When the user staffs the employee to the activity
#    Then the error message "You'are not authorised for this action" is given
#
#  Scenario: A user staffs an activity when the given employee is not available
#    Given that the user with the initials "ABCD" is the manager of the project
#    And the activity named "testing" is not staffed
#    And the given employee named "POPO" is not available
#    When the user staffs the employee to the activity
#    Then the error message "Employee is not available" is given
#
#  Scenario: A user staffs an activity when the activity is already staffed
#    Given that the user with the initials "ABCD" is the manager of the project
#    And the activity named "testing" is already staffed
#    And the given employee named "POPO" is available
#    When the user staffs the employee to the activity
#    Then the error message "Activity is already staffed" is given

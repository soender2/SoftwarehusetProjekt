#Feature: Delete activity
#  Description: A user deletes an activity
#  Actors: User
#
#  Scenario: A user delete an activity succesfully
#    Given that the user with the initials "ABCD" is the manager of the project
#    And the project have an activity named "testing"
#    When the user deletes the activity
#    Then the activity named "testing" is deleted from the project
#
#  Scenario: Deleting an activity when the user is not the projectmanager
#    Given that the user with the initials "ABCD" is not the manager of the project
#    And the project have an activity named "testing"
#    When the user deletes the activity
#    Then the error message "You'are not authorised for this action" is given
#
#  Scenario: Deleting an activity when the project contains zero activities
#    Given that the user with the initials "ABCD" is the manager of the project
#    And the project contains zero activities
#    When the user deletes the activity
#    Then the error message "No activities available for deleting" is given
#

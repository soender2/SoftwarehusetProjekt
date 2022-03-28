
Feature: Add an activity
	Description: An activity is added to the project
	Actors: Project manager, Employee

Scenario: Add an activity successfully
	Given there is a project with project name "Project 1"
 	And the user with initials "name" is the manager of the project
 	And the activity with the name "activity" is not in the project
 	When the activity is added to the project
 	Then the activity with title "activity" is added to the project

#Scenario: Add an activity as a manager/employee of another project
#	Given that the user is not manager of the project, with the initials "name"
#	And there is a project called "project", with project number "20"
#	When the activity is added to the project
#	Then the error message "Requires project manager" is given
#
#Scenario: An activity that already exist within the project, is added to the project
#	Given that the user is project manager with the initials "name" and id number "69"
#	And there is a project called "Intro til software", with project number "420"
#	And the activity with the name "HDL-kode-kursus" is added to the project
#	When the activity is added to the project
#	Then the error message "Activity already exists" is given


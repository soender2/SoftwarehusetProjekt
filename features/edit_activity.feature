
Feature: Edit activity
	Description: An activity in the project is edited
	Actors: Project manager, Employee

#Scenario: Edit the name of an activity successfully
#	Given that the user is project manager with the initials "MOHE"
 #	And there is a project called "clean", with project number "20"
#	And the project contains an activity with the name "spillMilk"
#	And there is a name "mopFloor"
#	When the name is edited
#	Then the name of the activity is "mopFloor"
#
#Scenario: Edit the employee working on the activity successfully
#	Given that the user is project manager with the initials "MOHE"
#	And there is a project called "clean", with project number "20"
#	And the project contains an activity with the name "vaccum"
#	And an employee with the initials "OSMA"
#	And an employee with the initials "RASØ"
#	When the employee with the initials "OSMA" is replaced by the employee with the initials "RASØ"
#	Then the activity has the employee with the initials "RASØ"
#
#Scenario: Edit the name of an activity without being project manager
#	Given that the user with the initials "MOHE" is not manager of the project
#	And there is a project called "clean"
#	And there is an activity with the name "vaccum"
#	When the name of the activity is edited to "spillMilk"
#	Then the error message "Requires project manager" is given
#
#Scenario: Edit the employee working on the activity without being project manager
#	Given that the user with the initials "MOHE" is not manager of the project
#	And there is a project called "clean"
#	And there is an activity called "vaccum"
#	And there is an employee with the initials "RASØ"
#	When the employee of the activity is replaced by the employee with the initials "RASØ"
#	Then the error message "Requires project manager" is given
Feature: Add Project manager
	Description: A project manager is added to the project
	Actors: user

Scenario: Add a project manager successfully
 	Given there is a project with title "project name"
 	And the project does not contain a project manager
 	When the user is added to the project
 	Then the user is added as project manager succesfully 
 	
Scenario: Add a project manager failed
	Given there is a project with title "project name"
 	And the project contains a project manager
	When the user is added to the project
	Then the error message "project already has a project manager" is given
	
	


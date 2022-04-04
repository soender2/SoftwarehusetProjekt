Feature: Add Project manager
	Description: A project manager is added to the project
	Actors: user

Scenario: Add a project manager successfully
	Given there is a project with name "Software project" without a project manager
 	When the user with name "Name" is added to the project
 	Then the user is added as project manager successfully
 	
Scenario: Add a project manager failed
	Given there is a project with name "Software project" with a project manager
	When the user with name "Name" is added to the project
	Then the error message "project already has a project manager" is given
	
	


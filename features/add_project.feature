Feature: Add Project
	Description: A user adds a project
	Actors: user

Scenario: Add a project successfully
	Given a project with title "Software project"
 	And the project does not exist with title "Software project"
 	When the project is added with title "Software project"
 	Then the project is contained in PMA with title "Software project"
 	
Scenario: Add an existing project
	Given a project with title "Software project"
	When the project is added with title "Software project"
	Then the error message "project already exists" is given for all
	


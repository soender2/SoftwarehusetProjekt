package system.app;

import java.util.ArrayList;

public class PMA {
    ArrayList<Employee> employees;
    ArrayList<Project> projects;

    public PMA() {
        projects = new ArrayList<Project>();
        employees = new ArrayList<Employee>();
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void deleteProject(Project project) {
        projects.remove(project);
    }

    public boolean existProject(Project project) {
        return projects.contains(project);
    }

}

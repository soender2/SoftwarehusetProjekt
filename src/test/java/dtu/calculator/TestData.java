package dtu.calculator;

import system.app.Activity;
import system.app.Employee;
import system.app.PMA;
import system.app.Project;

public class TestData {
    public Project project;
    public PMA pma;
    public Activity activity;
    public Employee employee;

public TestData(PMA pma, Project project, Activity activity, Employee employee){
    this.pma = pma;
    this.project = project;
    this.activity = activity;
    this.employee = employee;

}


}

package WhiteBoxTest.Test3;

public class Project {
	Employee projectManager;
	Project(Employee projectManager){
		this.projectManager = projectManager;
	}
	
	public String isProjectManager(){
        if(this.projectManager == null) {
            return "No";
        } else {
            return "Yes";
        }
    }
}

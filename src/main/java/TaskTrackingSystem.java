import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskTrackingSystem {
    private List<Program> programs;

    TaskTrackingSystem(List<Program> programs) {
        this.programs = programs;
    }

    //Create functionality to find all the programs where a given Individual is enrolled in.
    public List<Program> hasIndividual(String name) {
        List<Program> filteredPrograms = new ArrayList<>();


        for (Program program : programs) {
            if(program.hasIndividual(name)) filteredPrograms.add(program);
        }
        return filteredPrograms;
    }

    public List<Project> projectEnrolledIndividual(String name ){
        List<Project> filteredProjects = new ArrayList<>();

        for(Program program: programs){
            for(Project project : program.getProjects()){
                if(project.hasIndividual(name)) filteredProjects.add(project);

            }
        }
        return filteredProjects;
    }

    public List<Task> getIndividualTask( String individualName , String status ){
        List<Task> taskList = new ArrayList<>();

        for(Program program: programs){
            for(Project project : program.getProjects()){
                if(project.hasIndividual(individualName)) {
                    taskList.addAll(project.getTask(individualName, status));
                }

            }
        }
        return taskList;
    }

//    Create functionality to identify total pending tasks for a given Individual and given program.

    public List<Task> getProgramAndIndividualTask(String individualName, String programName, String status) {

        List<Task> taskList = new ArrayList<>();
        for (Program program : programs) {
            if (program.getName().equals(programName)) {
                for (Project project : program.getProjects()) {
                    if (project.hasIndividual(individualName)) taskList = project.getTask(individualName,status);
                }
            }
        }
        return taskList;

    }

//    Create functionality to identify total pending tasks for a given project.

    public List<Task> getProjectTask(String projectName, String status) {

        List<Task> taskList = new ArrayList<>();
        for (Program program : programs) {
            for (Project project : program.getProjects()) {
                if (project.getName().equals(projectName)) {
                    taskList = project.getProjectTask(status);
                    break;
                   }
                }
            }
        return taskList;

    }

    // Create functionality to identify the program name for a given project.
    public String getProgram( String projectName){
        for(Program program: programs){
            if(program.hasProject(projectName)) return program.getName();
        }
        return "doesn't exist";
    }
}

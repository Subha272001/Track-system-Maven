import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Program {
    private String name ;
    private List<Project> projects;

    Program(){

    }
    @JsonCreator
    public Program(@JsonProperty("name") String name, @JsonProperty("projects") List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

//    Program(String name, List<Project> projects){
//        this.name = name;
//        this.projects = projects;
//    }

    public String getName(){
        return this.name;
    }

    public boolean hasIndividual(String individualName ){
        for(Project project: projects){
            if(project.hasIndividual(individualName)) return true;
        }
        return false;
    }

    public boolean hasProject(String projectName){
        for(Project project: projects){
            if(project.getName() == projectName) return true;
        }
        return false;
    }
    public List<Project> getProjects(){
        return projects;
    }
    public String toString(){
        return "Program: " + name;
    }
}

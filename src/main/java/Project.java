import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    private String name ;
    private List<Individual> individualList;

    Project(){

    }

    @JsonCreator
    public Project(@JsonProperty("name") String name,
                   @JsonProperty("individualList") List<Individual> individualList) {
        this.name = name;
        this.individualList = individualList;
    }


    public String getName(){
        return this.name;
    }

    public boolean hasIndividual(String individualName){
        for(Individual individual : individualList){
            if( individual.getName().equals(individualName)) return true;
        }
        return false;
    }

   public List<Task> getProjectTask(String status){
        List<Task> filteredTaskList = new ArrayList<>();
        for(Individual individual : individualList){
            filteredTaskList.addAll(individual.getIndividualTask(status));
        }
        return filteredTaskList;
   }

    public List<Task> getTask(String individualName, String status){
        List<Task> filteredTaskList = new ArrayList<>();
        for(Individual individual : individualList){
            if(individual.getName().equals(individualName)) filteredTaskList.addAll(individual.getIndividualTask(status));
        }
        return filteredTaskList;
    }
}


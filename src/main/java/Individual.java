import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Individual {
    private String name;
    private List<Task> taskList;

    Individual(){

    }
    @JsonCreator
    Individual(@JsonProperty("name") String name,@JsonProperty("taskList") List<Task>  taskList ){
        this.name = name;
        this.taskList= taskList;
    }

    public String getName(){
        return this.name;
    }


    public List<Task> getIndividualTask( String status){
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : taskList ){
            if(task.getStatus().equals(status)) filteredTasks.add(task);
        }
        return filteredTasks;
    }
}

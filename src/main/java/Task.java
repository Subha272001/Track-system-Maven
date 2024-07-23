import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Task {
    private String name;
    private String status;

    Task(){

    }

    @JsonCreator
    Task(@JsonProperty("name") String name, @JsonProperty("status") String  status){
        this.name = name;
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public String toString(){
        return "Task name: "+ this.name + " Status: " + this.status;
    }

}


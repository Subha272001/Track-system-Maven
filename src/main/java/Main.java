
import java.util.List;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            List<Program> programs = JsonUtils.readProgramsFromJson("programs.json");
            TaskTrackingSystem t = new TaskTrackingSystem(programs);

            JsonUtils.writeProgramsToJson(programs, "output.json");
            System.out.println(t.hasIndividual("Udit"));
            System.out.println(t.getIndividualTask("Udit","PENDING"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





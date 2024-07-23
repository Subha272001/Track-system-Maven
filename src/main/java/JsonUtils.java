import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {

    public static List<Program> readProgramsFromJson(String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Program> programs = mapper.readValue(new File(jsonFilePath), new TypeReference<List<Program>>(){});
        return programs;
    }

    public static void writeProgramsToJson(List<Program> programs, String jsonFilePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(jsonFilePath), programs);
    }
}

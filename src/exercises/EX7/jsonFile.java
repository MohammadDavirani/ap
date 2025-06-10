package exercises.EX7;

import Projects.Library.Library;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class jsonFile {
    public void saveJson(Library person) throws Exception {
        Gson gson = new Gson();
        try (
                PrintWriter pw=new PrintWriter(Files.newOutputStream(new File("jsonFile.json").toPath()))
        )
        {
            pw.println(gson.toJson(person));
        }
    }

    public ArrayList<Library> load() throws IOException {
        Gson gson = new Gson();
        return new ArrayList<>(Files.lines(Paths.get("jsonFile.json"))
                .map(line -> gson.fromJson(line, Library.class))
                .collect(Collectors.toList()));

    }

}

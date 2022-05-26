package reference1.StreamAPI.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static reference1.StreamAPI.ThreadColor.*;

public class StreamFile {
    public static void main(String[] args){
        String path = "src/reference1/StreamAPI/names";

        try {
            Stream<String> namesStream = Files.lines(Paths.get(path));
//            namesStream.forEach(System.out::println);
            List<String> names = namesStream.collect(Collectors.toList());
            names.stream().filter(x -> x.startsWith("S")).forEach(x -> System.out.println(ANSI_BLUE+x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

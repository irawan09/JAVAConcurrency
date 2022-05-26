package reference1.StreamAPI.Object;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static reference1.StreamAPI.ThreadColor.*;

public class StreamObject {

    public static void main(String[] args){

        List<Student> students = new ArrayList<>();
        students.add(new Student("Adam", true));
        students.add(new Student("Michaela", true));
        students.add(new Student("Kevin", true));
        students.add(new Student("Bejo", false));
        students.add(new Student("Natt", false));

        students.stream().map(Student::getName).sorted().forEach(System.out::println);

        int count = (int) students.stream().filter(s -> s.isLocal()==true).count();

        System.out.println(ANSI_BLUE+"Number of local students: "+count);
        String locals = students.stream().filter(s -> s.isLocal()).map(Student::getName).collect(Collectors.joining(" - "));
        System.out.println(locals);

        System.out.println(ANSI_RED+"Number of non-local students: "+count);
        String nonLocals = students.stream().filter(s -> !s.isLocal()).map(Student::getName).collect(Collectors.joining(" - "));
        System.out.println(nonLocals);
    }

}

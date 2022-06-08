package reference1.StreamAPI.Collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static reference1.StreamAPI.ThreadColor.*;

public class App {

    public static void main(String[] args){
        Path path = Paths.get("src/reference1/StreamAPI/Collectors/EmployeeData.txt");

        try(Stream<String> lines = Files.lines(path)) {

            Stream<String> words = lines.flatMap( line -> Arrays.stream(line.split(",")));
            Spliterator<String> wordSpliterator = words.spliterator();
            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            Stream<Employee> employeeStream = StreamSupport.stream(employeeSpliterator, false);
            List<Employee> employeeList = employeeStream.collect(Collectors.toList());

            List<String> employeeNames = employeeList.stream()
                    .map(Employee::getName)
                    .collect(Collectors.toList());

            employeeNames.forEach(System.out::println);
            System.out.println(ANSI_BLUE+"-----X-------LIST---------X---");

            Set<String> designations = employeeList.stream()
                    .map(Employee::getDesignation)
                    .collect(Collectors.toSet());

            designations.forEach(System.out::println);
            System.out.println(ANSI_RED+"-----X-------LIST---------X---");

            TreeSet<Employee> employeesSorted = employeeList.stream()
                    .collect(Collectors.toCollection(TreeSet :: new));

            employeesSorted.forEach(System.out::println);
            System.out.println(ANSI_GREEN+"-----X-------LIST---------X---");

            Map<Integer, String> getNameById = employeeList.stream()
                    .collect(Collectors.toMap(Employee::getId, Employee::getName));

            System.out.println(getNameById);

            Map<Boolean, List<Employee>> partitionedData = employeeList.stream()
                    .collect(Collectors.partitioningBy(e -> e.getGender() == 'M'));

            System.out.println(partitionedData);

//            List<Employee> maleEmployees = partitionedData.get(true);
//            List<Employee> femaleEmployees = partitionedData.get(false);

            Map<String, List<Employee>> getByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation));

            System.out.println(getByDesignation);

            Long collect = employeeList.stream()
                    .map(Employee::getSalary)
                    .collect(Collectors.counting());

            System.out.println(collect);
            System.out.println(ANSI_PURPLE+"-----X-------LIST---------X---");

            String employeeNamesString = employeeList.stream()
                    .map(Employee::getName)
                    .collect(Collectors.joining(", "));

            System.out.println(employeeNamesString);

            System.out.println(ANSI_CYAN+"-----X-------LIST---------X---");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

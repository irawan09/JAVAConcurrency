package reference1.StreamAPI.CascadingCollectors;

import java.util.function.Function;
import reference1.StreamAPI.Collectors.Employee;
import reference1.StreamAPI.Collectors.EmployeeSpliterator;

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


    public static void main(String[] args) {

        Path path = Paths.get("src/reference1/StreamAPI/CascadingCollectors/EmployeeData.txt");

        try (Stream<String> lines = Files.lines(path)) {

            Spliterator<String> wordSpliterator = lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .spliterator();

            Spliterator<Employee> employeeSpliterator = new EmployeeSpliterator(wordSpliterator);

            List<Employee> employeeList = StreamSupport.stream(employeeSpliterator, false)
                    .collect(Collectors.toList());

            Map<String, Long> countByDesignation = employeeList.stream()
                    .collect(Collectors.groupingBy(Employee::getDesignation, Collectors.counting()));

            System.out.println(ANSI_BLUE+"-----X-------LIST---------X---");
            System.out.println(countByDesignation);

            Map<String, Double> fundDistribution = employeeList.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDesignation,
                            Collectors.summingDouble(Employee::getSalary)));

            System.out.println(ANSI_RED+"-----X-------LIST---------X---");
            System.out.println(fundDistribution);

            Map<String, Optional<Employee>> maxSalaryEmployees = employeeList.stream()
                    .collect(
                            Collectors.groupingBy(
                                    Employee::getDesignation,
                                    Collectors.maxBy(
                                            Comparator.comparing(Employee::getSalary))
                            )
                    );

            System.out.println(ANSI_GREEN+"-----X-------LIST---------X---");
            System.out.println(maxSalaryEmployees);

            Map<String, Optional<Double>> maxSalaries =
                    employeeList.stream()
                            .collect(
                                    Collectors.groupingBy(
                                            Employee::getDesignation,
                                            Collectors.mapping(
                                                    Employee::getSalary,
                                                    Collectors.maxBy(Comparator.comparing(Function.identity()))
                                            )
                                    )
                            );

            System.out.println(ANSI_PURPLE+"-----X-------LIST---------X---");
            System.out.println(maxSalaries);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

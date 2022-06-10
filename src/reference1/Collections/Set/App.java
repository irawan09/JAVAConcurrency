package reference1.Collections.Set;

import java.util.*;
import java.util.stream.Collectors;

import static reference1.Collections.ThreadColor.*;

public class App {

    public static void main(String[] args){

        Set<Integer> set = new HashSet<>(Arrays.asList(3, 56, 7, 82, 39));

        // traversal

        set.forEach(System.out::println);
        System.out.println(ANSI_BLUE+"--------------------");

        // filter
        set.stream()
                .filter(e -> e%2 == 0)
                .forEach(System.out::println);

        System.out.println(ANSI_RED+"--------------------");

        // sorting
        set.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println(ANSI_GREEN+"--------------------");

        TreeSet<Integer> sortedSet = new TreeSet<>(set);

        sortedSet.forEach(System.out::println);
        System.out.println(ANSI_PURPLE+"--------------------");

        // map
        Set<Double> hashSet = set.stream()
                .map(Double::valueOf)
                .collect(Collectors.toSet());

        hashSet.forEach(System.out::println);
        System.out.println(ANSI_CYAN+"--------------------");

        // reduce
        int sum = set.stream()
                .mapToInt(e -> e)
                .sum();

        System.out.println(sum);

    }
}

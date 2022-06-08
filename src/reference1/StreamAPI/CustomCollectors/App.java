package reference1.StreamAPI.CustomCollectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static reference1.StreamAPI.ThreadColor.*;

public class App {

    public static void main(String[] args){

        List<Integer> numbers = new ArrayList<Integer>();
        Collections.addAll(numbers,2,6,8,9,0,1,52,5,61,8,9,96,0,18,23);

        Collector<Integer, List<Integer>, List<Integer>> toList =
                Collector.of(
                    ArrayList::new,             // supplier
                    (list, e) -> list.add(e),   // BiConsumer
                    (list1, list2) -> {
                        list1.addAll(list2);    // BiFunction
                        return list1;
                    },
                    Collector.Characteristics.IDENTITY_FINISH
                );

        List<Integer> evens = numbers.stream()
                .filter(e -> e%2 == 0)
                .collect(Collectors.toList());

        evens.forEach(System.out::println);

        System.out.println(ANSI_BLUE+"---------------------------");

        Collector<Integer, List<Integer>, List<Integer>> toSortedListCollector
                = Collector.of(
                ArrayList::new, //supplier
                (list, e) -> list.add(e) , //BiConsumer
                (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                },
                (list)->{
                    Collections.sort(list);
                    return list;
                },
                Collector.Characteristics.UNORDERED
        );

        List<Integer> sortedList = numbers.stream()
                .collect(toSortedListCollector);

        sortedList.forEach(System.out::println);

    }
 }


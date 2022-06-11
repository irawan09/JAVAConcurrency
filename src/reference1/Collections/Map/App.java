package reference1.Collections.Map;

import static reference1.Collections.ThreadColor.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args){

        Map<String, String> contacts = new HashMap<>();
        contacts.put("1237589020", "Raymond");
        contacts.put("1237009020", "Jonathan");
        contacts.put("7890291111", "Samuel");
        contacts.put("2647210290", "Arnold");
        contacts.put("9999999999", "Peter");
        contacts.put("9081234567", "Gabriel");

        // traversal

        for(Map.Entry<String, String> entry : contacts.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue());
        }
        System.out.println(ANSI_BLUE+"---------------------------");

        contacts.forEach((k, v) -> System.out.println(k +" - "+ v) );
        System.out.println(ANSI_RED+"---------------------------");

        // filter
        contacts.entrySet().stream()
                .filter(contact -> "Gabriel".equalsIgnoreCase(contact.getValue()))
                .forEach(System.out::println);

        Map<String, String> filteredContacts = contacts.entrySet().stream()
                .filter(contact -> "Samuel".equalsIgnoreCase(contact.getValue()))
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue()));

        System.out.println(ANSI_GREEN+"---------------------------");

        // map
        String contactNames = contacts.entrySet().stream()
                .map(c -> c.getValue())
                .distinct()
                .collect(Collectors.joining(" , "));

        System.out.println(contactNames);

        System.out.println(ANSI_CYAN+"---------------------------");

        // sorting
        LinkedHashMap<String, String> sortedMap = contacts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(c -> c.getKey(), c -> c.getValue(), (v1, v2) -> v1, LinkedHashMap::new));

        sortedMap.forEach((k, v)-> System.out.println(k +" - "+v));
        System.out.println(ANSI_PURPLE+"---------------------------");

        // reduce
        Map<String, Double> marks = new HashMap<>();
        marks.put("Science", 70.00);
        marks.put("Maths", 79.00);
        marks.put("English", 90.00);

        OptionalDouble average = marks.values().stream()
                .mapToDouble(m -> m)
                .average();

        System.out.println(average.getAsDouble());
    }
}

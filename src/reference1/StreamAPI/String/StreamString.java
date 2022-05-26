package reference1.StreamAPI.String;

import java.util.Comparator;
import java.util.stream.Stream;

import static reference1.StreamAPI.ThreadColor.*;

public class StreamString {

    public static void main(String[] args){
        String[] names = {"Adam", "Daniel", "Martha", "Kevin", "Ben", "Joe", "Brad", "Susan"};

        Stream.of(names).sorted().forEach(System.out::println);
        System.out.println(ANSI_BLUE+"---------------------------------------------------");
        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println(ANSI_RED+"---------------------------------------------------");
        Stream.of(names).filter(x -> x.startsWith("B")).forEach(System.out::println);
    }
}

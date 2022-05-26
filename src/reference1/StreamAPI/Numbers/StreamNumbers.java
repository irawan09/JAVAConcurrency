package reference1.StreamAPI.Numbers;

import static reference1.StreamAPI.ThreadColor.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamNumbers {

    public static void main(String[] args){
        int[] nums  = {1,5,3,-2,9,12};

        /* lambda expresssion
        *  :: operator or method reference
        *
        * */
        /* -------------------------Source of the Stream-------------------------*/
        Arrays.stream(nums).forEach(System.out::println);
        int sum = Arrays.stream(nums).sum();
        System.out.println(ANSI_BLUE+"Sum of the given data: "+sum);
        IntStream.range(0,10).forEach(x -> System.out.print(ANSI_RED+x+" "));
        System.out.println();
        /* -------------------------Intermediate Operation-------------------------*/
        IntStream.range(0,10).filter(x -> x%2==0).forEach(x -> System.out.print(ANSI_GREEN+x+" "));

    }
}

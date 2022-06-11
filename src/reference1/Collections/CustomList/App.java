package reference1.Collections.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static reference1.Collections.ThreadColor.*;

public class App {

    public static void main(String[] args){

        ListFun<Integer> list = ListFun.list(3, 5, 9, 18);
        System.out.println(ANSI_BLUE);
        list.forEach(System.out::println);

        ListFun<Integer> newList = list.addEle(69);
        System.out.println(ANSI_RED);
        newList.forEach(System.out::println);

        ListFun<Integer> removeEle = newList.removeEle(3);
        System.out.println(ANSI_CYAN);
        removeEle.forEach(System.out::println);

        System.out.println(ANSI_GREEN);
        ListFun<Integer> reverseList = newList.reverseList();
        reverseList.forEach(System.out::println);

        ListFun<Integer> list1 = ListFun.list(3, 6, 9, 8);
        ListFun<Integer> list2 = ListFun.list(35, 78, 90);

        System.out.println(ANSI_YELLOW);
        ListFun.concat(list1, list2).forEach(System.out::println);

        System.out.println(ANSI_PURPLE);

        List<Integer> l = new ArrayList<>();
        Collections.addAll(l,2, 5, 8, 6);
        list1.addAllEle(l).forEach(System.out::println);
    }
}

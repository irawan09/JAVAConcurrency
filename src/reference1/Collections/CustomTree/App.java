package reference1.Collections.CustomTree;

import static reference1.Collections.ThreadColor.*;

public class App {

    public static void main(String[] args) {

        TreeFun<Integer> t= TreeFun.tree(23, 5, 76, 10, 3, 45);
        System.out.println(ANSI_BLUE);
        System.out.println(t);
        TreeFun<Integer> tree = t.remove(10);
        System.out.println(ANSI_RED);
        System.out.println(tree);

        System.out.println(ANSI_GREEN);
        System.out.println(tree.isMember(50));
        System.out.println(ANSI_PURPLE);
        System.out.println(tree.max());
    }
}

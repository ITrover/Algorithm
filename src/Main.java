import sort.*;

import java.util.*;

public class Main {

    public interface Hello{
        void sayHello();
    }

    public void test(Hello hello){
        hello.sayHello();
    }

    public static void main(String[] args) {
//        BinSort <Comparable> sort = new BinSort <>();
        Integer[] integers = {1, 3, 2,7,9,20,1,0,4};
//        sort.insertSort(integers);
//        System.out.println(Arrays.asList(integers));
        Main main = new Main();

        // lambda表达式
        // 编译器会判断->后面是返回值，还是一个普通的表达式
        main.test(()-> System.out.println("nima"));

        Arrays.sort(integers,(x,y)->{
            System.out.println("这是表达式");
            return y-x;
        });


    }
}

import sort.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        BinSort <Comparable> sort = new BinSort <>();
        Integer[] integers = {1, 3, 2,7,9,20,1,0,4};
        sort.insertSort(integers);
        System.out.println(Arrays.asList(integers));

}
}

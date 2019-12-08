import sort.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HeapSort <Comparable> sort = new HeapSort <>();
        Integer[] integers = {1, 3, 2,7,9,20,1,0,4};
        sort.sort(integers);
        System.out.println(Arrays.asList(integers));
    }
}

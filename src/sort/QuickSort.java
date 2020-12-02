package sort;
/**
 * 快速排序
 * 1.将集合分成两部分，左边全部小于分割元素，右边全部大于分割元素，返回分割位置
 * 2.将分割的两部分分别进行1操作
 * 3.重复操作，直到不能分割。
 * @param <T>
 */
public class QuickSort <T extends  Comparable> {

    public void quickSort(T[] t){
        qSort(t,0,t.length-1);
     }

    /**
     * 递归排序
     * @param t
     * @param low
     * @param high
     */
     private void  qSort(T[] t,int low,int high){
         if(low<high){
             int pivotloc = position(t,low,high);
             qSort(t,low,pivotloc-1);
             qSort(t,pivotloc+1,high);
         }
    }
    /**
     * 将集合分为两部分，返回值为分割位置
     */
     private int position(T[] t,int low,int high){
         // 选取第一个元素作为轴
         T tmp = t[low];
         while (low<high){
             while (low<high&&t[high].compareTo(tmp)> 0 ) {
                 high--;
             }
             // 右边的比轴小，那么将high所在的元素赋给low位置
             t[low]=t[high];
             while (low<high&&t[low].compareTo(tmp)<=0) {
                 low++;
             }
             // 左边的比轴大，将low元素所在的赋给high位置
             t[high]=t[low];
         }
         // 当low == high时，tmp就处于列表中间。
         t[low] = tmp;
         return low;
     }


}

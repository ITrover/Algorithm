package sort;

import java.util.Collection;

/**
 * 归并排序
 * 通过一个辅助集合，将原来的集合逐步对半分成若干个小部分
 * 每个小部分通过比较合成一个有序序列
 * 逐步合并
 * @param <T>
 */
public class MergeSort <T extends Comparable>{

        public void mergeSort(T[] t){
            T[] tmpArray = (T[])new Comparable[t.length];
            mergeSort(t,tmpArray,0,t.length-1);
        }
        private void mergeSort(T[] t,T[] tmpArray,int left,int right){
            if(left<right){
                int center = (right + left)/2;
                mergeSort(t,tmpArray,left,center );
                mergeSort(t,tmpArray,center+1, right);
                merge(t,tmpArray,left,center+1,right);
            }
        }
    /**
     *
     * @param t  需要排序的集合
     * @param tmpArray 辅助集合
     * @param leftPos  左边开始点
     * @param rightPos  右边开始点
     * @param rightEnd  右边结束点
     */
        private void merge(T[] t,T[] tmpArray,int leftPos,int rightPos,int rightEnd){
            int leftEnd = rightPos -1;
            int temPos = leftPos;
            int numElements = rightEnd -leftPos+1;
            while (leftPos<=leftEnd && rightPos<= rightEnd){
                if(t[leftPos].compareTo(t[rightPos])<= 0) {
                    tmpArray[temPos++] =t[leftPos++];
                } else {
                    tmpArray[temPos++] =t[rightPos++];
                }
            }
            //合并剩下的部分
            while (leftPos<=leftEnd) {
                tmpArray[temPos++] =t[leftPos++];
            }
            while (rightPos<=rightEnd) {
                tmpArray[temPos++] =t[rightPos++];
            }
            //合并会原来的集合
            for (int i = 0; i <numElements ; i++,rightEnd--) {
                t[rightEnd] = tmpArray[rightEnd];
            }
        }
}

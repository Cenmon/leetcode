package 数据结构.排序算法.快排;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-17 2022-03-17
 */
public class 快排算法 {

    public void quickSort(int[] arr,int start,int end){
        if(start <= end) {
            int low=start,high=end;
            int pivot = arr[start];
            while (low<high){
                while(low < high && arr[high] >= pivot) high--;
                arr[low] = arr[high];
                while(low < high && arr[low] <= pivot) low++;
                arr[high] = arr[low];
            }
            arr[low] = pivot;

            quickSort(arr,start,low-1);
            quickSort(arr,low+1,end);
        }
    }

    public static void main(String[] args) {
        快排算法 main = new 快排算法();

        int[] ints = new int[] {2,6,8,3,4,1,9};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(ints);
        main.quickSort(ints,0,ints.length-1);
        arrayUtils.print(ints);
    }
}

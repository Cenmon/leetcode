package 二分;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-07 2022-03-07
 */
public class 数字在升序数组中出现的次数 {

    public int GetNumberOfK(int [] array , int k) {
//        if(array == null || array.length==0) return 0;
        int low=0,high=array.length-1;
        int mid;
        while(low < high){//寻找第一次出现的位置
            mid = (low+high)/2;
            if(k > array[mid]) low=mid+1;
            else{
                high = mid;
            }
        }
        int start=low;
        low=0;
        high=array.length-1;
        while(low < high){//寻找第一次出现的位置
            mid = (low+high+1)/2;
            if(k < array[mid]) high=mid-1;
            else{
                low = mid;
            }
        }
        System.out.println("start = " + start+" end= "+low);

        return low-start+1;
    }

    public static void main(String[] args) {
        数字在升序数组中出现的次数 main = new 数字在升序数组中出现的次数();

        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(arr);
        int res = main.GetNumberOfK(arr, 4);
        System.out.println("res = " + res);
    }
}

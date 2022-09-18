package 数据结构.数组;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 调整数组顺序使奇数位于偶数前面一 {

    public int[] reOrderArray0 (int[] array) { //不顾原序
        // write code here
        int low=0,high=array.length-1;
        int pivot=array[0];
        while(low < high){
            while(low < high && array[high]%2 == 0) high--;
            array[low] = array[high];
            while(low < high && array[low]%2 != 0) low++;
            array[high] = array[low];
        }
        array[low]=pivot;
        return array;
    }

    public int[] reOrderArray2 (int[] array) { // 时间：o(n) 空间：o(n)
        int len = array.length;
        int[] res = new int[len];
        int k=0;
        for(int i=0;i<len;i++){
            if(array[i] % 2 != 0)
                res[k++] = array[i];
        }
        for(int i=0;i<len;i++){
            if(array[i] % 2 == 0)
                res[k++] = array[i];
        }
        return res;
    }

    public int[] reOrderArray (int[] array) {
        int len = array.length;
        int index=0;
        for(int i=0;i<len;i++){
            if(array[i] % 2 != 0){
                int tmp = array[i];
                for(int j=i-1;j>=index;j--)
                    array[j+1] = array[j];
                array[index] = tmp;
                index++;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        调整数组顺序使奇数位于偶数前面一 main = new 调整数组顺序使奇数位于偶数前面一();

//        int[] arr = new int[] {1,2,3,4}; //[1,3,2,4]
//        int[] arr = new int[] {2,4,6,5,7}; //[5,7,2,4,6]
        int[] arr = new int[] {1,3,5,6,7}; //[1,3,5,7,6]
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(arr);
        int[] res = main.reOrderArray(arr);
        arrayUtils.print(res);


    }
}

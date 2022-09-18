package 双指针.对撞指针;

import Utils.ArrayUtils;

import java.util.Arrays;

public class 数组中的k个最强值1471M {

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        int left=0,right=arr.length-1,mid = (arr.length-1)/2;
        while(k > 0){
            if(arr[right]-arr[mid] >= arr[mid]-arr[left]){
                ans[--k] = arr[right--];
            }else{
                ans[--k] = arr[left++];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        数组中的k个最强值1471M main = new 数组中的k个最强值1471M();

        /**
         * 给定数组arr和k，返回前k个距离中位数最远的点
         */
        ArrayUtils.print(main.getStrongest(new int[]{1,2,3,4,5},2)); // 1,5
        ArrayUtils.print(main.getStrongest(new int[]{1,1,3,5,5},2)); // 5,5
        ArrayUtils.print(main.getStrongest(new int[]{6,7,11,7,6,8},5)); // 7,6,6,8,11
        ArrayUtils.print(main.getStrongest(new int[]{6,-3,7,2,11},3)); // 2,11,-3
        ArrayUtils.print(main.getStrongest(new int[]{-7,22,17,3},2)); // 17,22
        ArrayUtils.print(main.getStrongest(new int[]{513},1)); // 513
    }
}

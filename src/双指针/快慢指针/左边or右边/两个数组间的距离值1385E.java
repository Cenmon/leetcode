package 双指针.快慢指针.左边or右边;

import java.util.Arrays;

public class 两个数组间的距离值1385E {

     public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
         Arrays.sort(arr1);
         Arrays.sort(arr2);
         int ans = 0,m=arr1.length,n=arr2.length;
         int i=0,j=0;
         while(i<m){
             while(j<n && arr2[j]<arr1[i]) j++;

             if(0<j && j<n && arr1[i]-arr2[j-1] > d && arr2[j]-arr1[i]>d) ans++;
             else if(j == 0 && arr2[j] - arr1[i] > d) ans++;
             else if(j == n && arr1[i] - arr2[j-1] > d) ans++;

             i++;
         }
         return ans;
     }


    public static void main(String[] args) {
        两个数组间的距离值1385E main = new 两个数组间的距离值1385E();

        /**
         * 给定两个数组arr1,arr2和距离d，若arr1中某个元素与arr2中任一元素的距离都大于d，则满足条件
         * 返回arr1中满足条件的元素个数
         */

        System.out.println(main.findTheDistanceValue2(new int[]{4,5,8},new int[]{10,9,1,8},2)); // 2
        System.out.println(main.findTheDistanceValue2(new int[]{1,4,2,3},new int[]{-4,-3,6,10,20,30},3)); // 2
        System.out.println(main.findTheDistanceValue2(new int[]{2,1,100,3},new int[]{-5,-2,10,-3,7},6)); // 1
        System.out.println(main.findTheDistanceValue2(new int[]{-8,-7},new int[]{4,10,-4,5,2},55)); // 0
    }
}

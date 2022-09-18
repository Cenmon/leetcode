package 双指针.异地指针;

import Utils.ArrayUtils;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 数组交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0,j=0;
        int m=nums1.length,n=nums2.length;
        int[] ans = new int[m+n];
        int index=0;

        while(i<m && j<n){
            if(nums1[i] == nums2[j]){
                ans[index++] = nums1[i];
                while(i<m && nums1[i] == ans[index-1]) i++;
                while(j<n && nums2[j] == ans[index-1]) j++;
            }else if( nums1[i] < nums2[j] ){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(ans,0,index);
    }

    public static void main(String[] args) {
        数组交集 main = new 数组交集();

        ArrayUtils.print(main.intersection(new int[]{1,2,2,1},new int[]{2,2})); // 2
        ArrayUtils.print(main.intersection(new int[]{4,9,5},new int[]{9,4,9,8,4})); // 4,9
    }
}

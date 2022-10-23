package 二分.最左二分.第K小.二分搜值;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Cenmo
 * @Date 2022-10-23 21:06
 * @Description
 */
public class 查找和最小的K对数字373H {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int kthsum = kthSum(nums1,nums2,k);
        for(int n1 : nums1){
            for(int n2 : nums2){
                if(n1 + n2 < kthsum){ // 先放入小于kthsum的
                    ans.add( Arrays.asList(n1,n2) );
                }else{
                    break;
                }
            }
        }
        for(int n1 : nums1){
            for(int n2 : nums2){
                if(n1 + n2 == kthsum && ans.size()<k){ // 先放入小于kthsum的
                    ans.add( Arrays.asList(n1,n2) );
                }else if(n1 + n2 > kthsum){
                    break;
                }
            }
        }
        return ans;
    }

    private int kthSum(int[] n1,int[] n2,int k){
        int left=n1[0]+n2[0],right=n1[n1.length-1]+n2[n2.length-1];
        while(left <= right){
            int mid = left + (right-left)/2;
            if(countLessOrEqual(n1,n2,mid) >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private int countLessOrEqual(int[] n1,int[] n2,int value){
        int j=n2.length-1,count=0;
        for(int i=0,n=n1.length;i<n;i++){ // 入队
            while(j>=0 && n1[i] + n2[j] > value){ // 出队
                j--;
            }
            count += j+1;
        }
        return count;
    }


    public static void main(String[] args) {
        查找和最小的K对数字373H main = new 查找和最小的K对数字373H();
        /**
         * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
         *
         * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
         *
         * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
         */
        JavaUtils.print(main.kSmallestPairs(new int[]{1,7,11},new int[]{2,4,6},3));//[[1, 2], [1, 4], [1, 6]]
        JavaUtils.print(main.kSmallestPairs(new int[]{1,1,2},new int[]{1,2,3},2));//[[1, 1], [1, 1]]
        JavaUtils.print(main.kSmallestPairs(new int[]{1,2},new int[]{3},3));//[[1, 3], [2, 3]]
        JavaUtils.print(main.kSmallestPairs(new int[]{0,0,0,0,0},new int[]{-3,22,35,56,76},22));
    }
}

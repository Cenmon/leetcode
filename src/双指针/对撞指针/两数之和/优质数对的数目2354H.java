package 双指针.对撞指针.两数之和;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Cenmo
 * @Date 2022-10-09 16:05
 * @Description
 */
public class 优质数对的数目2354H {

    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num); // nums去重
        int[] arr = new int[set.size()];
        int n = 0;
        for(int num : set){
            arr[n++] = Integer.bitCount(num);// 获取nums未重复元素的比特位数
        }
        Arrays.sort(arr);
        long ans=0;
        for(int i=0,j=n-1;i<n;i++){
            if(arr[i]*2 >= k){ // 不重复元素自身可构成优质数对
                ans++;
            }
            while(j>=0 && arr[i]+arr[j] >= k) j--; // j右侧均满足条件
            //(a,b)、(b,a)均是优质数对
            if(j>=i) ans += 2L*(n-1-j); // i,j满足条件，增大i同样满足i+j>=k，即i+1时，j右侧同样满足条件
            else ans += 2L*(n-1-i);
        }
        return ans;
    }


    public static void main(String[] args) {
        优质数对的数目2354H main = new 优质数对的数目2354H();

        /**
         * 给定数组nums和目标值k，
         * 当数组内任一两数num1,num2满足nums1&num2和num1|num2的和大于等于k时，则(num1,num2)为优质数对
         * 当(num1,num2)为优质数对是，(num2,num1),(num1,num1)也可能为优质数对
         * 返回最大优质数对数目
         */
        System.out.println(main.countExcellentPairs(new int[]{1,2,3,1},3)); // 5
        System.out.println(main.countExcellentPairs(new int[]{5,1,1},10)); // 0
    }
}

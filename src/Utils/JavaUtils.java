package Utils;

import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-06-29 2022-06-29
 */
public class JavaUtils {

    public static void print(List list){
        System.out.println("java list:" + list.toString());
    }

    public static void swap(int[] nums,int i,int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void swap2(int[] nums,int i,int j){
        nums[i] ^= nums[j] ^ (nums[j] = nums[i]); // 也可用于字符数组
    }

    private int upper_search(int[] arr,double value){
        // 求小于等于value的最右下标：小于等于时往右走
        int left=0,right=arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(arr[mid] > value){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right; // 输出范围为[-1,n-1]
    }

    private int lower_search(int[] nums,double target){
        // 求大于等于value的最左下标:大于等于时往左走
        int left=0,right=nums.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;// 输出范围为[0,n]
    }
}

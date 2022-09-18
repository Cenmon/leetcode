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
}

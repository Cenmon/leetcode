package 数据结构.哈希;

import Utils.ArrayUtils;

import java.util.ArrayList;

/**
 * @author Cenmo
 * @Date 2022-03-28 2022-03-28
 */
public class 消失的两个数字 {

    public int[] missingTwo(int[] nums){ // Math.位运算
        int n = nums.length;
        // 两个缺失的数字的异或结果
        int misTwo = 0;
        for(int i=0;i<n;i++){
            misTwo ^= nums[i] ^ (i+1);
        }
        // 找到缺失数字的不同位,找到异或结果为1的位
        int div=1;
        while((misTwo & div) == 0) div = div << 1;
        // 分离缺失的数字
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            if((nums[i] & div) == 0) ans[0] ^= nums[i] ^ (i+1);
            else ans[1] ^= nums[i] ^ (i+1);
        }
        return ans;
    }

    public int[] missingTwo2(int[] nums) { // 添加两个未知，再原地哈希
        int n = nums.length;
        boolean n1Visit=false,n2Visit=false;
        for(int i=0;i<n;i++){
            int hash = Math.abs(nums[i])-1;
            if(hash < n){
                nums[hash] *= -1;
            }
            if(hash == n) n1Visit = true;
            if(hash == n+1) n2Visit = true;
        }
        int[] ans = new int[2];
        int id=0;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                ans[id++] = i+1;
            }
        }
        if(!n1Visit) ans[id++] = n+1;
        if(!n2Visit) ans[id++] = n+2;
        return ans;
    }

    /**
     * 给定数组，数组值为1-n，求缺失的两个值
     * 原地哈希之正负标志，此时数组值与数组大小有关
     */
    public static void main(String[] args) {
        消失的两个数字 main = new 消失的两个数字();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.print(main.missingTwo(new int[] {1})); // 原值为1-3 缺失2,3
        arrayUtils.print(main.missingTwo(new int[] {2,3})); // 原值为1,2,3,4 缺失1,4
    }
}

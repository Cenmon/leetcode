package 双指针.快慢指针.交叉重排;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-08-21 2022-08-21
 * @Description 交叉重排问题
 */
public class 按符号重排数组2149M {

    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i=0,j=1;
        for(int x : nums){
            if(x > 0){
                ans[i] = x;
                i+=2;
            }else{
                ans[j] = x;
                j+=2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        按符号重排数组2149M main = new 按符号重排数组2149M();

        /**
         * 给定包含正整数和负整数的偶数长度的数组，将数组正负交替重排，并保证原有元素的相对位置(稳定)
         *
         */

        ArrayUtils.print(main.rearrangeArray(new int[]{3,1,-2,-5,2,-4})); // 3,-2,1,-5,2,-4
        ArrayUtils.print(main.rearrangeArray(new int[]{-1,1})); // 1,-1
        // 28,-41,22,-8,46,-37,35,-9,18,-6,19,-26,15,-37,14,-10,31,-9
        ArrayUtils.print(main.rearrangeArray(new int[]{28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31}));
    }
}

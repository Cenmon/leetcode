package 双指针.对撞指针;

import Utils.ArrayUtils;

/**
 * @author Cenmo
 * @Date 2022-03-18 2022-03-18
 * https://www.bilibili.com/video/BV1TK411j7LP?spm_id_from=333.999.0.0
 */
public class 盛最多水的容器 {

    public int maxArea(int[] height){
        int left = 0,right = height.length-1;
        int max = 0;
        while(left < right){
            if(height[left] < height[right]){
                max = Math.max(max,(right-left)*height[left]); //
                left++; // 以该点为左端点的情况均枚举完毕
                // 一旦右移，则表示以该点为端点的所有情况均枚举完毕
                // 左指针高度较小，当左指针为容器左端点时，右端点可能比左端点高，比其低，或者相等
                // 但受左端点限制，求最大容积，故此时各种情况均枚举完毕
            }else{
                max = Math.max(max,(right-left)*height[right]); //
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        盛最多水的容器 main = new 盛最多水的容器();

        /**
         * 给出一排柱形图，选择两个柱子，使其围成的凹坑蓄水最多
         */
        int[] heights = {1,8,6,2,5,4,8,3,7}; // 最多盛水：左端点8，右端点7， 7*(8-1)=49
        new ArrayUtils().print(heights,"heights");
        System.out.println(main.maxArea(heights));
    }
}

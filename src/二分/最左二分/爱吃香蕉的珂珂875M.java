package 二分.最左二分;

import java.util.Stack;

/**
 * @Author Cenmo
 * @Date 2022-10-09 19:14
 * @Description 解空间是[1,max]的离散空间
 */
public class 爱吃香蕉的珂珂875M {

    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=piles[0];
        for(int pile : piles)
            if(pile > right) right=pile;
        // 最左二分
        while(left <= right){
            int mid = left + (right-left)/2;
            if(canEat(piles,mid,h)){ // mid速度能吃完，尝试更小速度
                right = mid-1;
            }else{ // mid速度不能吃完，尝试更大速度
                left = mid+1;
            }// }else{
            //     return mid;
            // }
        }
        Stack<int[]> stack = new Stack<>();
        return left;
    }

    private boolean canEat(int[] nums,long speed,int h){
        long hour = 0;
        for(int num : nums){
            hour += (num+speed-1)/speed;
        }
        return hour <= h;
    }


    public static void main(String[] args) {
        爱吃香蕉的珂珂875M main = new 爱吃香蕉的珂珂875M();

        /**
         * 给定n堆香蕉的数列数组piles和时间h,
         * 珂珂每个小时找一堆香蕉吃speed只香蕉，吃完后本小时不再吃，下一小时继续吃
         * 确定最小速度speed使得珂珂在h小时内吃完所有的香蕉
         */

        System.out.println(main.minEatingSpeed(new int[]{3,6,7,11},8)); // 4
        System.out.println(main.minEatingSpeed(new int[]{30,11,23,4,20},5)); // 30
        System.out.println(main.minEatingSpeed(new int[]{30,11,23,4,20},6)); // 23
        System.out.println(main.minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000)); // 3
    }
}

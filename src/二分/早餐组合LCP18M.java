package 二分;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-08-22 2022-08-22
 * @Description 两数组中的两数之和
 * 注：二分优化等待！！！
 */
public class 早餐组合LCP18M {

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int m=staple.length,ans=0;
        for(int s=0,d=drinks.length-1;s < m;s++){
            while(d>=0 && staple[s] + drinks[d] > x){
                d--;
            }
            ans = (ans+d+1) % 1000000007;
        }
        return ans;
    }

    // 有问题，不能通过
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int m=staple.length,ans=0;
        for(int s=0,d=drinks.length-1;s < m;s++){
            // while(d>=0 && staple[s] + drinks[d] > x){
            //     d--;
            // }
            d = BSearch(drinks,x-staple[s],0,d);
            ans = (ans+d) % 1000000007;
        }
        return ans;
    }

    // 取目标值下标的下一个位置
    private int BSearch(int[] nums,int target,int left,int right){
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        早餐组合LCP18M main = new 早餐组合LCP18M();

        /**
         * 给定主食价格数组staple，饮料价格数组drinks和限定花销x
         * 挑一份主食和一份饮料，价格之和小于等于x，返回选择的种数
         */
        System.out.println(main.breakfastNumber(new int[]{10,20,5},new int[]{5,5,2},15)); // 6
        System.out.println(main.breakfastNumber(new int[]{2,1,1},new int[]{8,9,5,1},9)); // 8
    }
}

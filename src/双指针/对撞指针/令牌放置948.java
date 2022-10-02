package 双指针.对撞指针;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-31 2022-07-31
 */
public class 令牌放置948 {

    /**
     * 主要思想：采用贪心，小能量值token翻正，减能量加分，大能量token翻反，加能量减分
     * 即顺序数组确定某个边界，边界左边减能量加分，右边加能量减分
     */
    public int bagOfTokensScore(int[] tokens, int power) { // 贪心
        Arrays.sort(tokens);
        int left=0,right=tokens.length-1;
        int ans = 0;
        while(left <= right){
            if(power - tokens[left] >= 0){ // 翻正减能量加分
                power -= tokens[left++];
                ans++;
                // left++;
            }else if(ans > 0){ // 翻反加能量减分
                power += tokens[right--];
                /**
                 * 分三个区间A,B,C,A区间减能量，B区间不用，C区间加能量
                 */
                if(left > right) break;
                ans--;// 还有令牌可以上翻
            }else{
                break;
            }
        }
        return ans;
    }

    private int func(int[] tokens,int power){
        Arrays.sort(tokens);
        int left=0,right=tokens.length-1;
        int ans = 0;
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left++];
                ans++;
            }else if(ans >= 1){
                power += tokens[right--];
                if(left > right) break;
                ans--;
            }else{
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        令牌放置948 main = new 令牌放置948();
        /**
         * 给定数组tokens代表每个令牌的能量值，以及初始能量值power
         * 若至少有token[i]点能量,则可以翻正令牌，能量减去tokens[i],得分加一
         * 若得分至少为1，则可以反转令牌，能量增加tokens[i],得分减一
         * 任意顺序确定令牌正反，且不必使用所有令牌，返回最大得分
         */

//        System.out.println(main.bagOfTokensScore(new int[]{100},50)); // 0
//        System.out.println(main.bagOfTokensScore(new int[]{100,200},150)); // 1
//        System.out.println(main.bagOfTokensScore(new int[]{100,200,300,400},200)); // 2
//        System.out.println(main.bagOfTokensScore(new int[]{71,55,82},54)); // 0

//        System.out.println(main.func(new int[]{100},50)); // 0
//        System.out.println(main.func(new int[]{100,200},150)); // 1
//        System.out.println(main.func(new int[]{100,200,300,400},200)); // 2
//        System.out.println(main.func(new int[]{71,55,82},54)); // 0
    }
}

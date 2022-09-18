package 双指针.对撞指针.两数之和;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-30 2022-07-30
 */
public class 救生艇881M {

    /**
     * 思想：两数之和小于等于limit的对数，大于limit的自成一队(right>limit)，最后不够分的自成一队(left=right)
     */
    public int numRescueBoats(int[] people, int limit) { // 贪心
        Arrays.sort(people);
        int ans=0;
        int left=0,right=people.length-1;
        while(left <= right){
            while(left <= right){
                if(people[left]+people[right] <= limit){
                    ans++;
                    right--; //最大体重和最小体重贪心共乘一艘船,right人已分配故人数减一
                    break;
                }else{
                    ans++;
                    right--; // 最大体重无法与人共乘，自身乘一艘船，分配完后人数减一
                }
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        救生艇881M main = new 救生艇881M();

        /**
         * 给定每个人的体重people[i]以及limit
         * 两两共乘一艘救生艇，两人体重和小于等于limit，返回最少救生艇数量
         */
        System.out.println(main.numRescueBoats(new int[]{1,2},3)); // 1
        System.out.println(main.numRescueBoats(new int[]{3,2,2,1},3)); // 3
        System.out.println(main.numRescueBoats(new int[]{3,5,3,4},5)); // 4
    }
}

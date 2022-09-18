package 双指针.对撞指针.两数之和;

import Utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class 和为S的连续正数序列acw {

    public List<List<Integer> > findContinuousSequence2(int sum) { // 求所有组合，滑动窗口
        int left=1,right=2,n=(sum+1)/2;
        List<List<Integer>> ans = new ArrayList<>();
        while(left <= n || right <= n){
            int plus = (left + right) * (right - left + 1) / 2;
            if(plus == sum){
                List<Integer> list = new ArrayList<>();
                for(int i=left;i<=right;i++){
                    list.add(i);
                }
                ans.add(list);
                right++;
            }else if(plus < sum){
                right++;
            }else{
                left++;
            }
        }
        return ans;
    }

    public int[][] findContinuousSequence(int target) {
        int left=1,right=2;
        int sum = left+right;
        List<int[]> ans = new ArrayList<>();
        while(left <= target/2 ){
            if(sum < target){
                right++;
                sum += right;
            }else if(sum > target){
                sum -= left;
                left++;
            }else{
                int[] tmp = new int[right-left+1];
                for(int i=left;i<=right;i++){
                    tmp[i-left] = i;
                }
                ans.add(tmp);
                sum -= left;
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        和为S的连续正数序列acw main = new 和为S的连续正数序列acw();

//        JavaUtils.print(main.findContinuousSequence2(15));
        ArrayUtils.print(main.findContinuousSequence(15)); // [[1,2,3,4,5],[4,5,6],[7,8]]
        ArrayUtils.print(main.findContinuousSequence(9)); // [[2,3,4],[4,5]]
    }
}

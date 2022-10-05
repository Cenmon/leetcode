package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

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

    public int[][] findContinuousSequence3(int target) { // 滑动窗口，固定右端点
        int i=1,sum=0;
        List<int[]> ans = new ArrayList<>();
        for(int j=1,n=target/2+1;j<=n;j++){
            sum += j;
            while(sum >= target){
                if( sum == target ){
                    int[] tmp = new int[j-i+1];
                    for(int k=i;k<=j;k++){
                        tmp[k-i] = k;
                    }
                    ans.add(tmp);
                }
                sum -= i++;
            }
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        和为S的连续正数序列acw main = new 和为S的连续正数序列acw();

//        JavaUtils.print(main.findContinuousSequence2(15));
        ArrayUtils.print(main.findContinuousSequence3(15)); // [[1,2,3,4,5],[4,5,6],[7,8]]
        ArrayUtils.print(main.findContinuousSequence3(9)); // [[2,3,4],[4,5]]
    }
}

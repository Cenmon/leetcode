package 双指针.窗口指针.计算边界;

import Utils.JavaUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cenmo
 * @Date 2022-07-11 2022-07-11
 */
public class 划分字母区间763 {

    public List<Integer> partitionLabels(String s) {
        int[] end = new int[128];
        char[] cs = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            end[ cs[i] ] = i;
        }
        int left=0,right=end[cs[left]];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(cs[i] != cs[left] && end[cs[i]] >= 0){
                if(end[cs[i]] < right){
                    end[cs[i]] = -1; // 已访问
                }else{
                    right = Math.max(right,end[cs[i]]);
                }
            }
            if(i == right){
                ans.add(right - left + 1);
                if(i+1 < n){ // 后面还需要遍历字符
                    left = i+1;
                    right = end[cs[left]];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        划分字母区间763 main = new 划分字母区间763();

        /**
         * 给定字符串，划分区间，区间尽可能短，但包含的字符仅在该区间内出现
         */
        JavaUtils.print(main.partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
    }
}

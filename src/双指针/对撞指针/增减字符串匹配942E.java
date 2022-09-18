package 双指针.对撞指针;

import Utils.ArrayUtils;

public class 增减字符串匹配942E {

    public int[] diStringMatch(String s) { // 贪心
        int n=s.length(),left=0,right=n;
        int[] ans = new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'I'){
                ans[i] = left++;
            }else{
                ans[i] = right--;
            }
        }
        ans[n] = left; // 此时left=right
        return ans;
    }


    public static void main(String[] args) {
        增减字符串匹配942E main = new 增减字符串匹配942E();

        /**
         * 给定由I,D组成的字符串s，返回一个数组ans
         * 当s.charAt(i)为I时，ans[i]<ans[i+1],当为D时，ans[i]>ans[i+1]
         */

        ArrayUtils.print(main.diStringMatch("IDID")); // [0,4,1,3,2]
        ArrayUtils.print(main.diStringMatch("III")); // [0,1,2,3]
        ArrayUtils.print(main.diStringMatch("DDI")); // [3,2,0,1]
    }
}

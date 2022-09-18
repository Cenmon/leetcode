package 数据结构.字符串;

import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-15 2022-03-15
 * 初闻噩耗，简单写了点，还有两个更高效的方法
 * https://www.bilibili.com/video/av541183309
 */
public class 最长有效括号 {

    public int longestValidParentheses_violence (String s) {
        // write code here
        char[] cs = s.toCharArray();
        int n = cs.length;
        for(int len=n%2==0?n:n-1;len>=0;len-=2){ // 最长有效括号长度必为偶数
            for(int j=0;j<n-len+1;j++){
                if(isValid(cs,j,j+len-1)) {
                    return len;
                }
            }
        }
        return 0;
    }

    public boolean isValid(char[] cs,int start,int end){
        Stack<Character> stack = new Stack<>();
        for(int i=start;i<=end;i++){
            if(cs[i] == '(') stack.push(cs[i]);
            if(stack.isEmpty()) return false; // 右括号多余(右括号还在遍历序列中，左括号栈已空)
            if(cs[i] == ')' && stack.peek()=='(') stack.pop(); // 栈非空，一个右括号对应一个左括号
        }
        return stack.isEmpty(); // 左括号多余（左括号栈未空，右括号序列已遍历完）
    }

    public int longestValidParentheses_dp (String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int[] dp = new int[n+1]; // dp[i]表示长度为i的最长有效括号的长度
        int max = 0;
        for(int i=1;i<=n;i++){
            int index = i-1;
//            if(cs[index] == '(') dp[i] = 0; //以左括号结尾的字符串最长有效括号长度为0
            if(cs[index] == ')' && index-dp[i-1]-1 >= 0 && cs[ index-dp[i-1]-1 ] == '(' ){
                // 状态方程：若i减去一个有效括号长度再减一的坐标（index-dp[i-1]-1）字符为左括号
                // 则最大有效括号长度为2 + 中间有效括号长度 + 左侧（i-dp[i-1]-2）有效括号长度
                // 有两种坐标越界的可能：字符数组越界和dp数组越界，前者要求index-dp[i-1]-1 >= 0，后者dp坐标整体右移1，用0表示-1
                dp[i] = 2 + dp[i-1] + dp[ i-dp[i-1]-2 ];
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        最长有效括号 main = new 最长有效括号();

//        int res = main.longestValidParentheses_violence("((()(()))("); //2
//        int res = main.longestValidParentheses_dp("((()(()))("); //2
        int res = main.longestValidParentheses_dp("())()"); //4
//        int res = main.longestValidParentheses_violence("(())"); //4
        System.out.println("res = " + res);
    }
}

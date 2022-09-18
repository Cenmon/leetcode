package 数据结构.字符串;

import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-15 2022-03-15
 */
public class 有效括号序列 {

    public boolean isValid (String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        int length = cs.length;
        for(int i=0;i<length;i++){
            if(cs[i] == '[' || cs[i] == '(' || cs[i] == '{'){ //左括号直接入栈
                stack.push(cs[i]);
            }
            if(stack.isEmpty()) return false;//匹配过程栈空则无效括号
            if((cs[i] == ']' && stack.peek()=='[')
                    || (cs[i] == ')' && stack.peek()=='(')
                    || (cs[i] == '}' && stack.peek()=='{')){
                stack.pop();
            }
        }
        if(stack.isEmpty()) return true;
        else return false;//括号序列匹配完毕栈非空则无效
//        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        有效括号序列 main = new 有效括号序列();
    }
}

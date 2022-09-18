package 数据结构.字符串;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Cenmo
 * @Date 2022-03-19 2022-03-19
 */
public class 大数加法 {

    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    public String solve (String s, String t) {
        // write code here
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for(int i=0;i<sc.length;i++) stack1.push(sc[i]);
        for(int i=0;i<tc.length;i++) stack2.push(tc[i]);

        ArrayList<Integer> list = new ArrayList<>();
        int carry=0;//进位
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int a=0,b=0;
            if(!stack1.isEmpty()) a = stack1.pop()-'0';
            if(!stack2.isEmpty()) b = stack2.pop()-'0';

            int ans = a + b + carry;
            carry = 0;
            if(ans >= 10){
                ans = ans % 10;
                carry = 1;
            }
            list.add(ans);//将结果
        }
        if(carry == 1) list.add(1);

        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1;i>=0;i--)
            sb.append(list.get(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        大数加法 main = new 大数加法();

        System.out.println(main.solve("1","99")); // 100
        System.out.println(main.solve("114514","")); // 114514
    }
}

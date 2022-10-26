package 数据结构.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Cenmo
 * @Date 2022-10-26 16:20
 * @Description
 */
public class 分数到小数166M {

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        long x = numerator,y = denominator;

        StringBuffer sb = new StringBuffer();
        // 处理符号
        int sign = 1;
        if(x < 0){
            x = -x;
            sign *= -1;
        }
        if(y < 0){
            y = -y;
            sign *= -1;
        }
        if(sign < 0) sb.append('-');
        // 处理整数部分
        sb.append(x/y);
        long c = x % y;
        if(c == 0) return sb.toString(); // 整除
        else sb.append('.');
        // 模拟手算除法
        // 记录每次除法的余数以及当前余数的sb.size()，便于加括号
        Map<Long,Integer> map = new HashMap<>();
        while(c!=0 && !map.containsKey(c)){ // 某次除完后的余数不能再出现
            map.put(c,sb.length());
            sb.append(c*10/y); // 乘10：借1进位，结果转化为字符串
            c = c*10 % y;
        }
        if(c == 0) return sb.toString(); // 小数能整除
        sb.insert((int)map.get(c),'('); // 循环体
        sb.append(')');
        return sb.toString();
    }


    public static void main(String[] args) {
        分数到小数166M main = new 分数到小数166M();

        /**
         * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
         *
         * 如果小数部分为循环小数，则将循环的部分括在括号内。
         *
         * 如果存在多个答案，只需返回 任意一个 。
         *
         * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
         */
        System.out.println(main.fractionToDecimal(1,2));//0.5
        System.out.println(main.fractionToDecimal(2,1));//2
        System.out.println(main.fractionToDecimal(4,333));//0.(012)
        System.out.println(main.fractionToDecimal(0,-5));//0
        System.out.println(main.fractionToDecimal(-2,-3));//0.(6)
        System.out.println(main.fractionToDecimal(-1,-2147483648));//0.0000000004656612873077392578125
    }
}

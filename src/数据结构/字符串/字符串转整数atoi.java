package 数据结构.字符串;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 字符串转整数atoi {

    public int AsciiToInteger(String s){
        s = s.trim();//处理空格，去除前后空格
        if(s == null || s.length()==0) return 0;
        int sign=1,index=0;
        // 处理正负号
        if(s.charAt(index) == '+'){
            sign=1;index++;
        }else if(s.charAt(index) == '-'){
            sign=-1;index++;
        }

        long sum=0;
        for(int i=index;i<s.length();i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9'){ //匹配到非数字，
                return sign * (int)sum;
            }
            sum = sum*10 + c-'0'; // 个位百位累加,处理当前位的数字
            if(sign == 1 && sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign == -1 && (-1)*sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return sign * (int)sum;
    }


    public static void main(String[] args) {

        字符串转整数atoi main = new 字符串转整数atoi();
//        int res = main.AsciiToInteger("82"); // 82
//        int res = main.AsciiToInteger("   -12  "); //-12
//        int res = main.AsciiToInteger("4396 clearlove"); // 4396
//        int res = main.AsciiToInteger("clearlove 4396"); // 0
        int res = main.AsciiToInteger("-987654321111"); // -2147483648

        System.out.println("res = " + res);
    }
}

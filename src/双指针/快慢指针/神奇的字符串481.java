package 双指针.快慢指针;

/**
 * @author Cenmo
 * @Date 2022-07-08 2022-07-08
 */
public class 神奇的字符串481 {

    /**
     * 纯模拟+计数
     * @param n ：字符串长度
     * @return ： n长度的神奇字符串中1的个数
     */
    public int magicalString(int n) {
        StringBuffer sb = new StringBuffer("122");
        int i=2,fast=3; // 慢指针i指向开头，快指针fast指向字符串末尾
        while(fast < n){
            if(sb.charAt(i) == '1'){
                if(sb.charAt(fast-1) == '1') sb.append('2');
                else sb.append('1');
                fast += 1;
            }else{
                if(sb.charAt(fast-1) == '1') {
                    sb.append('2');sb.append('2');
                }
                else {
                    sb.append("1");sb.append('1');
                }
                fast += 2;
            }
            i++;
        }
        //System.out.println(sb.toString());
        int count=0;
        for(i=0;i<n;i++){
            if(sb.charAt(i) == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        神奇的字符串481 main = new 神奇的字符串481();

        System.out.println(main.magicalString(10));
    }
}

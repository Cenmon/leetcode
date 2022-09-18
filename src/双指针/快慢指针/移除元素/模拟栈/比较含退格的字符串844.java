package 双指针.快慢指针.移除元素.模拟栈;

/**
 * @author Cenmo
 * @Date 2022-07-30 2022-07-30
 */
public class 比较含退格的字符串844 {

    public boolean backspaceCompare(String s, String t) {
        char[] cs = s.toCharArray(),ct = t.toCharArray();
        int tops = 0,topt = 0;
        for(int i=0;i < cs.length;i++){
            if(cs[i] != '#') cs[tops++] = cs[i]; // 入栈
            else if(tops > 0) tops--; // 栈非空出栈
        }
        for(int i=0;i < ct.length;i++){
            if(ct[i] != '#') ct[topt++] = ct[i];
            else if(topt > 0) topt--;
        }

        if(tops != topt) return false;
        for(int i=0;i<=tops;i++)
            if(cs[i] != ct[i]) return false;
        return true;
    }

    private int mockStack(char[] cs){
        int top = -1;
        for(int i=0;i < cs.length;i++){
         if(cs[i] != '#') cs[++top] = cs[i]; // 模拟入栈
         else if(top >= 0) top--; // 栈非空，模拟出栈
        }
        return top; // 返回长度
    }

    public static void main(String[] args) {
        比较含退格的字符串844 main = new 比较含退格的字符串844();

        /**
         * 给出两含特殊字符#的字母字符串，#表示退格，计算两字符串完成退格后是否相等
         */
        System.out.println(main.backspaceCompare("ab#c","ad#c"));// true
        System.out.println(main.backspaceCompare("ab##","c#d#"));// true
        System.out.println(main.backspaceCompare("a#c","b"));// false
        System.out.println(main.backspaceCompare("##","#"));// true
        System.out.println(main.backspaceCompare("xywrrmp","xywrrmu#p"));// true
        System.out.println(main.backspaceCompare("xywrrmp","xywrrm#p"));// false
    }
}

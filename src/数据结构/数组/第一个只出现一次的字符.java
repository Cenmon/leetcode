package 数据结构.数组;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        int[] map = new int[258];
        char[] arr = str.toCharArray();

        for(int i=0;i<arr.length;i++){
            map[ arr[i] ] ++;
        }
        for(int i=0;i<arr.length;i++){
            if(map[arr[i]] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        第一个只出现一次的字符 main = new 第一个只出现一次的字符();

        String s = new String("google"); // 4
//        String s = new String("aa"); // -1
        System.out.println("s = " + s);
        int firstIndex = main.FirstNotRepeatingChar(s);
        System.out.println("firstIndex = " + firstIndex);
    }
}

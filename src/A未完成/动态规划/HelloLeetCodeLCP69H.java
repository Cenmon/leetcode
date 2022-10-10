package A未完成.动态规划;

/**
 * @Author Cenmo
 * @Date 2022-10-10 16:31
 * @Description
 */
public class HelloLeetCodeLCP69H {

    public int Leetcode(String[] words) {
        int[] cnt = new int[]{0, 0, 1, 1, 4, 0, 0, 1, 0, 0, 0, 3, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};
        for(String word : words){
            int left=0,right=word.length()-1;
            while(left <= right){
                if(cnt[word.charAt(left)-'a'] > 0){
                    cnt[word.charAt(left++)-'a']--;
                }
                if(cnt[word.charAt(right)-'a'] > 0){
                    cnt[word.charAt(right--)-'a']--;
                }
            }
        }
        return 5;
    }


    public static void main(String[] args) {
        HelloLeetCodeLCP69H main = new HelloLeetCodeLCP69H();

        System.out.println(main);
    }
}

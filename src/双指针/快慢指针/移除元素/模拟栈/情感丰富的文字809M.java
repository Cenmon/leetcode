package 双指针.快慢指针.移除元素.模拟栈;

public class 情感丰富的文字809M {
    public int expressiveWords(String s, String[] words) {
        char[] cs = s.toCharArray();
        int[] times = new int[cs.length]; // 记录栈内元素的出现次数
        int n=cs.length,top=0; // 初始话即入栈，指向栈顶元素
        for(int i=0;i < n;i++){
            if(cs[i] != cs[top]){
                cs[++top] = cs[i];
            }
            times[top]++;
        }
        int ans = 0;
        for(String word : words){
            int left=0,right=0,idx=0,m=word.length();
            while(left < m){
                if(idx > top || word.charAt(left) != cs[idx]){
                    break;
                }
                while(right < m && word.charAt(right) == word.charAt(left)){
                    right++;
                }
                if(right-left > times[idx] || times[idx] < 3 && right-left != times[idx]){
                    break;
                }
                left = right;
                idx++;
            }
            if(idx == top+1 && left == m) ans++;
        }
        return ans;
    }


    public static void main(String[] args) {
        情感丰富的文字809M main = new 情感丰富的文字809M();

        /**
         * 给定模板字符串s和字符串数组words,word字符串的相同字符能翻倍，但翻倍后的字符必须大于三
         * 返回words中有多少word可形成s
         */

        System.out.println(main.expressiveWords("heeellooo",new String[]{"hello", "hi", "helo"})); // 1
        System.out.println(main.expressiveWords("heeelllooo",new String[]{"hello", "hi", "helo"})); // 2
        System.out.println(main.expressiveWords("aaa",new String[]{"aaaa"})); // 0
        System.out.println(main.expressiveWords("heeellooo",new String[]{"heeelloooworld"})); // 0
        System.out.println(main.expressiveWords("heeellooo",new String[]{"heeell"})); // 0
    }
}

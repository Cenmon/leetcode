package 双指针.窗口指针.滑动窗口.动态窗口.固定左端点;

/**
 * @Author Cenmo
 * @Date 2022-10-03 12:59
 * @Description
 */
public class 考试的最大困扰度2024M {

    // 思路：动态窗口内不一样的字符最多k个，其他都相同，返回最大窗口长度
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] cs = answerKey.toCharArray();
        int n = cs.length;
        int j=0,flip=0,ans=0;
        for(int i=0;i<n;i++){
            while(j<n && (cs[j]=='T' || flip<k) ){
                if(cs[j] == 'F') flip++;
                j++;
            }
            ans = Math.max(ans,j-i);
            if(j >= n) break;
            while(cs[i] == 'T') i++; // 跳过后续F之前的T
            flip--; // 跳过第一个F
        }

        flip = 0;j = 0;
        for(int i=0;i<n;i++){
            while(j<n && (cs[j]=='F' || flip<k) ){
                if(cs[j] == 'T') flip++;
                j++;
            }
            ans = Math.max(ans,j-i);
            if(j >= n) break;
            while(cs[i] == 'F') i++; // 跳过后续T之前的F
            flip--; // 跳过第一个T
        }
        return ans;
    }

    // 思路：动态窗口内不一样的字符最多k个，其他都相同，返回最大窗口长度
    public int maxConsecutiveAnswers2(String answerKey, int k) { // 固定右端点
        char[] cs = answerKey.toCharArray();
        int i=0,n = cs.length,ans=0;
        int TNum=0,FNum=0;
        for(int j=0;j<n;j++){
            if( cs[j] == 'T' ) TNum++;
            else FNum++ ;

            while(j-i+1 - Math.max(TNum,FNum) > k){
                if( cs[i] == 'T' ) TNum--;
                else FNum-- ;
                i++;
            }
            ans = Math.max(ans,j-i+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        考试的最大困扰度2024M main = new 考试的最大困扰度2024M();

        /**
         * 给定仅包含’T‘，’F'的字符串answerKey，现给定k次修改次数
         * 每次能够把T改成F或F改成T
         * 返回k次修改后字符串中最长连续的T或F的长度
         */
        System.out.println(main.maxConsecutiveAnswers("TTFF",2)); // 4
        System.out.println(main.maxConsecutiveAnswers("TFFT",1)); // 3
        System.out.println(main.maxConsecutiveAnswers("TTFTTFTT",1)); // 5
    }
}

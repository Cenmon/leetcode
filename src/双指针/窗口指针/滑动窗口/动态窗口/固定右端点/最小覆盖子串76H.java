package 双指针.窗口指针.滑动窗口.动态窗口.固定右端点;

/**
 * @Author Cenmo
 * @Date 2022-10-04 16:17
 * @Description 固定右端点
 */
public class 最小覆盖子串76H {

    // 对模板串的种类数进行计数，窗口内词频与模板串词频相同则种类数加一，词频大于模板串并不加一
    public String minWindow(String s, String t) { //
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();

        int[] cntt = new int[128];
        int type=0;
        for(int i=0,n=ct.length;i<n;i++){
            if(cntt[ ct[i] ] == 0) type++;
            cntt[ ct[i] ]++;
        }

        int[] cnts = new int[128];
        int i=0,matchType=0;
        int start=0,end=0,len=Integer.MAX_VALUE;
        for(int j=0,n=cs.length;j<n;j++){
            cnts[ cs[j] ]++; // 入队
            if(cnts[ cs[j] ] == cntt[ cs[j] ]){ // s中词频大于t，不算匹配类型
                matchType++;
            }
            while(matchType == type) {
                if(j-i+1 < len){ // 最短
                    start = i;
                    end = j+1;
                    len = j-i+1;
                }
                cnts[ cs[i] ]--; // 出队
                // if(cntt[ cs[i] ] - cnts[ cs[i] ] == 1){ // 词频差一时
                if(cntt[ cs[i] ] > cnts[ cs[i] ]){ // 词频差一时
                    matchType--;
                }
                i++;
            }
        }
        return  s.substring(start,end);
    }


    public static void main(String[] args) {
        最小覆盖子串76H main = new 最小覆盖子串76H();

        System.out.println(main);
    }
}

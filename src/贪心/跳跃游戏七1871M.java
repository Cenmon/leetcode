package 贪心;

/**
 * @Author Cenmo
 * @Date 2022-09-15 19:24
 * @Description 扫描区间：借助差分数组
 */
public class 跳跃游戏七1871M {

    // 扫描线思想：借助差分数组工具
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length(),visited = 0; // visited:正在多少个区间内

        if(s.charAt(n-1) != '0') return false;

        int[] diff = new int[n+1];
        diff[minJump]++;
        diff[maxJump+1]--;

        for(int i=1;i<n;i++){
            visited += diff[i];

            if( visited == 0 ) continue;
            if( s.charAt(i) == '1' ) continue;

            if(i+minJump < n ) diff[i+minJump]++;
            if(i+maxJump+1 < n ) diff[i+maxJump+1]--;
        }
        return visited>0;
    }

    public static void main(String[] args) {
        跳跃游戏七1871M main = new 跳跃游戏七1871M();

        /**
         * 给定01字符串和最小、最大跳跃步数，起始位置在下标0，
         * 每次在值为0的位置可最少跳跃minJump步，最多跳跃maxJump步,且跳后的值为0
         * 返回是否能够跳到最后一个下标(n-1)
         */
        System.out.println(main.canReach("011010",2,3)); // true
        System.out.println(main.canReach("01101110",2,3)); // false
        System.out.println(main.canReach("01",1,1)); // false
    }
}

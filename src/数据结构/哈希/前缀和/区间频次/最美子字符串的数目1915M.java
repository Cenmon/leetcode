package 数据结构.哈希.前缀和.区间频次;

/**
 * @Author Cenmo
 * @Date 2022-10-31 17:38
 * @Description
 */
public class 最美子字符串的数目1915M {

    public long wonderfulSubstrings(String word) {
        // times(presum[j])-times(presum[i])=odd/even
        // 某个字母为奇数，则该字母在j位出现次数与在i为的出现次数不同奇同偶
        // 若所有字母均为偶数，则所有字母在j位出现次数和在i为出现次数同奇同偶
        int[] map = new int[(1<<10)];
        int key = 0;
        long ans = 0;
        map[0] = 1; // 所有字母均出现0次
        for(int j=0,n=word.length();j<n;j++){
            key ^= ( 1 << (word.charAt(j)-'a') );

            ans += map[key]; // 字符串[i:j]内字符均出现偶数次

            for(int i=0;i<10;i++){
                ans += map[key ^ (1<<i)]; // 字符串[i:j]内字符i+'a'出现奇数次，其他均出现偶数次
            }
            map[key]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        最美子字符串的数目1915M main = new 最美子字符串的数目1915M();

        /**
         * 如果某个字符串中 至多一个 字母出现 奇数 次，则称其为 最美 字符串。
         *
         * 例如，"ccjjc" 和 "abab" 都是最美字符串，但 "ab" 不是。
         * 给你一个字符串 word ，该字符串由前十个小写英文字母组成（'a' 到 'j'）。
         * 请你返回 word 中 最美非空子字符串 的数目。如果同样的子字符串在 word 中出现多次，那么应当对 每次出现 分别计数。
         *
         * 子字符串 是字符串中的一个连续字符序列。
         */
        System.out.println(main.wonderfulSubstrings("aba")); // 4
        System.out.println(main.wonderfulSubstrings("aabb")); // 9
        System.out.println(main.wonderfulSubstrings("he")); // 2
    }
}

package 双指针.窗口指针.字符串排列.计数数组;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-25 2022-07-25
 */
public class 适龄的朋友825 {

    public int numFriendRequests_violent(int[] ages) { // 暴力解法
        int n=ages.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // j是否能给i发消息，ages[i]需满足( 0.5*ages[j]+7,ages[j] ]
                if(i == j) continue;
                if(ages[i] <= 0.5*ages[j]+7) continue;
                if(ages[i] > ages[j]) continue;
                if(ages[i] > 100 && ages[j] < 100) continue;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 窗口内正确的值域为(0.5*cur+1,cur],若用右指针指向cur，无法保证后续等于cur的值，使用三指针则可以解决
     * @param ages
     * @return
     */
    public int numFriendRequests_threePoint(int[] ages) { // 窗口三指针
        Arrays.sort(ages);
        int left=0,right=0,n=ages.length;
        int ans=0;
        for (int age : ages) {
            // ages[left] > 0.5*age+7，left指向第一个满足条件的age
            while (ages[left] <= 0.5*age + 7) left++;
            // ages[right] > age right指向第一个不满足条件的age
            while (right < n && ages[right] <= age) right++;
            ans += right - left - 1; // 减去自身给自身发消息
        }
        return ans;
    }

    public int numFriendRequests_prefix(int[] ages) { // 计数排序+前缀和
        int[] cnt = new int[121];
        // 记录等于age的人数
        for(int age : ages) cnt[age]++;
        int[] pre = new int[121];
        for(int age=1;age<121;age++){
            // 记录<=age的人数
            pre[age] = pre[age-1] + cnt[age];
        }
        int ans = 0;
        for(int age=15;age<121;age++){ // 15！！？？
            if(cnt[age] > 0){
                // (pre[age]-pre[(int)(0.5*age+7)] - 1):每个人可以发的人数，分布函数：(-,a]-(-,b]=(b,a]
//                System.out.println(age+" , " +(int)(0.5*age+7));
                System.out.println(pre[age]+" , "+pre[(int)(0.5*age+7)]);
                ans += cnt[age] * (pre[age]-pre[(int)(0.5*age+7)] - 1); // 自己不能给自己发，故减1
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        适龄的朋友825 main = new 适龄的朋友825();

//        System.out.println(main.numFriendRequests_prefix(new int[]{20,30,100,110,120})); // 3
//        System.out.println(main.numFriendRequests_prefix(new int[]{15,16,17,18})); // 2
//        System.out.println(main.numFriendRequests_prefix(new int[]{16,16})); // 2
        System.out.println(main.numFriendRequests_prefix(new int[]{118,14,7,63,103})); // 2
    }
}

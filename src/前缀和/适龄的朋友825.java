package 前缀和;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-25 2022-07-25
 */
public class 适龄的朋友825 {

    public int numFriendRequests3(int[] ages) { // 暴力解法
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

    public int numFriendRequests(int[] ages) { // 窗口指针
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

    public static void main(String[] args) {

        适龄的朋友825 main = new 适龄的朋友825();

        System.out.println(main.numFriendRequests(new int[]{20,30,100,110,120})); // 3
        System.out.println(main.numFriendRequests(new int[]{16,17,18})); // 2
        System.out.println(main.numFriendRequests(new int[]{16,16})); // 2
    }
}

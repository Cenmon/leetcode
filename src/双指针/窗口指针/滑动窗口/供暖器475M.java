package 双指针.窗口指针.滑动窗口;

import java.util.Arrays;

/**
 * @author Cenmo
 * @Date 2022-07-07 2022-07-07
 */
public class 供暖器475M {

    /**
     * 思路：每个房子，要么选择左边的供暖器，要么选择右边的供暖器，最后选择的供暖器应该是距离较小的一侧
     * 首先想到的应该是排序+二分查找，排序使得房子和供暖器的一维位置呈线性，二分查找找到房子在供暖器中所处的位置
     * 进一步优化，利用双指针，i指针指向房子，j指针指向供暖器，
     * 当二者位置均在一维坐标中时，距离房子比较近的供暖器位置即min(heaters[j],heaters[j+1]),j指向本次最近的供暖器
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        int m=houses.length,n=heaters.length;
        for(int i=0,j=0;i<m;i++){
            int radius = Math.abs(heaters[j]-houses[i]); // 默认选择左边的供暖器
            // 右边有加热器 且 与房子的距离小于左边的供暖器
            while(j+1 < n && Math.abs(heaters[j+1]-houses[i]) <= Math.abs(heaters[j]-houses[i])){
                radius = Math.min(radius,Math.abs(houses[i]-heaters[j+1]));
                j++;
            }

            ans = Math.max(ans,radius);
        }
        return ans;
    }

    public int findRadius3(int[] houses, int[] heaters) { // 左右指针
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = Integer.MIN_VALUE;
        int m=houses.length,n=heaters.length;
        int left = -Math.max(houses[m-1],heaters[n-1]),right=heaters[0]; // 假设左边无限远有一个供暖器
        for(int i=0,j=0;i<m;i++){
            if(houses[i] >= right){
                left = right;
                right = ++j<n ? heaters[j] : 2*Math.max(houses[m-1],heaters[n-1]); // 右边无限远有一个供暖器
            }
            ans = Math.max(ans,Math.min(houses[i]-left,right-houses[i]));
        }
        return ans;
    }

    public int findRadius2(int[] houses, int[] heaters) { // 左右扫
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m=houses.length,n=heaters.length;
        int[] leftRadius = new int[m];
        int pos = -Math.max(houses[m-1],heaters[n-1]); // 假设左边无限远有一个供暖器
        for(int i=0,j=0;i<m;i++){
            if(j<n && houses[i] >= heaters[j]) pos = heaters[j++];
            leftRadius[i] = houses[i] - pos;
        }
        pos = 2*Math.max(houses[m-1],heaters[n-1]); // 假设右边无限有一个供暖器
        int ans = Integer.MIN_VALUE;
        for(int i=m-1,j=n-1;i>=0;i--){
            if(j>=0 && houses[i] <= heaters[j]) pos=heaters[j--];
            ans = Math.max(ans,Math.min(leftRadius[i],pos-houses[i]));
        }
        return ans;
    }

    public int findRadius5(int[] houses, int[] heaters) { // 左右扫 + 滑动窗口固定端点
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int m=houses.length,n=heaters.length;
        int[] right = new int[m];
        for(int i=0,j=0;i<m;i++){
            while(j<n && houses[i] > heaters[j]) j++;
            right[i] = j<n ? heaters[j] - houses[i] : Integer.MAX_VALUE;
        }
        int ans = 0;
        for(int i=m-1,j=n-1;i>=0;i--){
            while(j>=0 && houses[i] < heaters[j]) j--;
            int left = j>=0 ? houses[i]-heaters[j] : Integer.MAX_VALUE;
            ans = Math.max(ans,Math.min(left,right[i]));
        }
        return ans;
    }

    public int findRadius4(int[] houses, int[] heaters) { // 二分
        Arrays.sort(heaters);

        int ans = 0,radius;
        for(int house : houses){
            int idx = leftBSearch(heaters,house);

            if(idx <= 0) radius = heaters[0]-house;
            else if(idx == heaters.length) radius = house-heaters[idx-1];
            else radius = Math.min(house-heaters[idx-1],heaters[idx]-house);

            ans = Math.max(ans,radius);
        }
        return ans;
    }

    private int leftBSearch(int[] heaters,int target){
        int left = 0,right = heaters.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(heaters[mid] >= target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        供暖器475M main = new 供暖器475M();

        /**
         * 给出房子和供暖器的一维坐标位置，求出供暖器能够覆盖所有房子的最小覆盖范围
         */
        System.out.println(main.findRadius3(new int[]{1,2,3},new int[]{2})); // 1
        System.out.println(main.findRadius3(new int[]{1,2,3,4},new int[]{1,4})); // 1
        System.out.println(main.findRadius3(new int[]{1,5},new int[]{2})); // 3
        System.out.println(main.findRadius3(new int[]{1,5},new int[]{10})); // 9
    }
}

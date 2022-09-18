package 双指针.模拟.补齐短板;

import java.util.Arrays;

/**
 * @Author Cenmo
 * @Date 2022-09-01 19:46
 * @Description
 */
public class 花园最大的总美丽值2234H {

    public long maximumBeauty(int[] flowers, long newFlowers, long target, long full, long partial) {
        Arrays.sort(flowers);

        int n = flowers.length - 1;
        long ans0 = 0;
        while (n>=0 && flowers[n] >= target) {
            ans0 += full;
            n--;
        }
        if( n<0 ) return ans0;
        int[] presum = new int[n + 1];
        presum[0] = flowers[0];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + flowers[i];
        }
        int[] diff = new int[n + 1]; // 把[0,i]补齐到flowers[i]高度需要的花数
        for (int i = 0; i <= n; i++) {
            diff[i] = flowers[i] * (i + 1) - presum[i];
        }

        long ans = 0;
        for (int i = n; i >= 0; i--) { // i右侧(i,+)为完善花园，左侧(-,i]为不完善花园
            if(newFlowers < 0) break;

            if (presum[i] + newFlowers >= (i + 1) * (target - 1)){ // 补齐所有不完善花园
                ans = Math.max(ans, partial * (target - 1) + full * (n - i));
            }else{
                int p = binarySearch(diff, 0, i, newFlowers);
                long minIncomplete = (presum[p] + newFlowers) / (p+1);
                ans = Math.max(ans, partial * minIncomplete + full * (n - i));
            }

            newFlowers -= target-flowers[i];
        }

        if(newFlowers > 0){ // 全为完善花园
            ans = Math.max(ans,(n+1)*full);
        }

        return ans0 + ans;
    }

    private int binarySearch(int[] arr,int low,int high,long key){
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] > key){
                high = mid - 1;
            }else if(arr[mid] < key){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return low-1>=0?low-1:0;
    }


    public static void main(String[] args) {
        花园最大的总美丽值2234H main = new 花园最大的总美丽值2234H();

        System.out.println(main.maximumBeauty(new int[]{1,3,1,1},7,6,12,1)); //14
        System.out.println(main.maximumBeauty(new int[]{2,4,5,3},10,5,2,6)); //30
        System.out.println(main.maximumBeauty(new int[]{18,16,10,10,5},10,3,15,4)); //75
        System.out.println(main.maximumBeauty(new int[]{20,1,15,17,10,2,4,16,15,11},2,20,10,2)); //14
        System.out.println(main.maximumBeauty(new int[]{10,9,16,14,6,5,11,12,17,2,11,15,1},80,14,15,1)); //195

        int[] flowers = new int[]{40742,74654,22547,18738,52156,33325,86828,63276,72224,65874,8268,91224,25184,28,69428,87064,65696,77466,90050,22475,19437,68830,56168,66104,86866,58547,66885,84417,13027,58683,76544,49343,10813,58444,16356,34161,19927,5397,16403,71540,21620,37374,49807,417,39043,38812,28248,71870,42961,40649,94016,19887,84,89541,10629,73203,14892,97132,62660,2370,5380,39769,94599,86931,83186,20501,44885,26943,77669,77891,66153,98865,32787,97342,68662,82740,78887,47815,42860,30637,60297,71183,26976,7776,2269,29377,23165,99864,53895,87432,24455,72667,52752,59991};
        System.out.println(main.maximumBeauty(flowers,3119579236L,100000,18353,74100)); //7411632729

    }
}

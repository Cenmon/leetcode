package 二分.最左二分;

/**
 * @Author Cenmo
 * @Date 2022-10-10 16:53
 * @Description 解空间是连续区间[0,max-min]的某个数
 */
public class 最小灯半径H {

    public double minLightRadius(int[] nums){
        int max=nums[0],min=nums[0];
        for(int num : nums){
            if(num > max) max = num;
            if(num < min) min = num;
        }
        int left=0,right=(max-min)/3;
        // 最左二分
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canLight(max,min,mid)){ // 半径为mid时可以点亮，减小半径
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left / 2.0;
    }

    private boolean canLight(int max, int min, int d) {
        return 3*d >= max-min;
    }


    public static void main(String[] args) {
        最小灯半径H main = new 最小灯半径H();

        System.out.println(main.minLightRadius(new int[]{3, 4, 5, 6})); // 0.5
    }
}

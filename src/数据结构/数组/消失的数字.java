package 数据结构.数组;

/**
 * @author Cenmo
 * @Date 2022-03-28 2022-03-28
 */
public class 消失的数字 {

    public int missingNumber(int[] nums) {
        int n=nums.length;
        boolean zeroVisited = false;
        for(int i=0;i<n;i++){
            int hash = Math.abs(nums[i]);
            if(hash < n){
                nums[hash] = -nums[hash];
                if(nums[hash] == 0) zeroVisited = true; // 单独处理0，因为正0和负0都是0，无法辨别
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] > 0 || (nums[i] == 0 && zeroVisited == false)){
                return i;
            }
        }
        return n;
    }

    /**
     * 给定数组，数组值为0-n，求缺失的值
     */
    public static void main(String[] args) {
        消失的数字 main = new 消失的数字();

        System.out.println(main.missingNumber(new int[] {3,0,1})); //0,1,2,3 缺2
        System.out.println(main.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})); //0,1,2,3,4,5,6,7,8,9 缺8
        System.out.println(main.missingNumber(new int[] {0,2})); //0,1,2 缺1

    }
}

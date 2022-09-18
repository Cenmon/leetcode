package 数据结构.哈希;

/**
 * @author Cenmo
 * @Date 2022-03-17 2022-03-17
 */
public class 缺失的第一个正数 {

    // 将值和键正确的哈希
    // 暴力解法：从1-n遍历，看看数是否在数组中
    // 故长度为n的数组，缺失的第一个正数必定在1-n+1中(若1,2,3...n都在数组，则数组满，第一个缺失的是n+1)
    // 故将值在1-n的元素哈希到0-n-1中，第一个num[i]!=i+1即所求
    public int minNumberDisappeared (int[] nums) {
        // write code here
        int n = nums.length;
        for(int i=0;i<n;i++){
            while( nums[i]>=1 && nums[i]<=n && nums[i] != nums[nums[i]-1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i]=tmp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }

    /**
     * 原地哈希之键值相等
     */
    public static void main(String[] args) {
        缺失的第一个正数 main = new 缺失的第一个正数();

        System.out.println(main.minNumberDisappeared(new int[] {1,0,2})); //3
        System.out.println(main.minNumberDisappeared(new int[] {-2,3,4,1,5})); //2
        System.out.println(main.minNumberDisappeared(new int[] {4,5,6,8,9})); //1
    }
}

package 数学.位运算;

/**
 * @author Cenmo
 * @Date 2022-03-28 2022-03-28
 */
public class 消失的数字 {

    public int missingNumber(int[] nums) {
        int missNum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            // 数组值为0-n，其中缺了一个值
            // 当数组值和0-n异或运算，异或运算满足交换律，出现了的值相当于和自身异或，最后只剩缺失的值
            missNum ^= i ^ nums[i];
        }
        return missNum ^ n;
    }

    public int missingNumber3(int[] nums) { // 原地哈希
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

    public int missingNumber2(int[] nums){ // 等差数列：数组值为0-n，求等差数列和为(1+n)*n/2,减去数组值的总和，即为缺失的值
        int n = nums.length;
        int sum=0;
        for(int num:nums){
            sum += num;
        }
        return (1+n)*n/2 - sum;
    }

    /**
     * 给定数组，数组值为0-n，求缺失的一个值
     * 原地哈希之正负标志
     */
    public static void main(String[] args) {
        数据结构.哈希.消失的数字 main = new 数据结构.哈希.消失的数字();

        System.out.println(main.missingNumber(new int[] {3,0,1})); //0,1,2,3 缺2
        System.out.println(main.missingNumber(new int[] {9,6,4,2,3,5,7,0,1})); //0,1,2,3,4,5,6,7,8,9 缺8
        System.out.println(main.missingNumber(new int[] {0,2})); //0,1,2 缺1

    }
}

package 双指针.对撞指针.翻转数组;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 旋转数组 {

    public void rotate1(int[] nums,int k){ // 辅助数组
        int n = nums.length;
        k = k % n;
        if( n == 0 || k == 0) return ;

        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = nums[ (i+k)%n ];
        }
        System.arraycopy(ans,0,nums,0,n);
    }

    public void rotate(int[] nums, int k) { // 翻转数组
        int n = nums.length;
        k = k % n;
        inverse(nums,0,n-1);
        inverse(nums,0,k-1);
        inverse(nums,k,n-1);
    }

    public void inverse(int[] nums,int left,int right){
        while(left < right){
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        旋转数组 main = new 旋转数组();
    }
}

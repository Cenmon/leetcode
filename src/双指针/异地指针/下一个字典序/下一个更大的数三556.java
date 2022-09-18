package 双指针.异地指针.下一个字典序;



/**
 * @author Cenmo
 * @Date 2022-07-09 2022-07-09
 */
public class 下一个更大的数三556 {

    public int nextGreaterElement(int n) {
        int[] nums = toIntArray(n);
        int left=nums.length-2;
        while(left>=0 && nums[left] >= nums[left+1]) left--;
        if(left == -1){
            return -1;
        }
        int right=nums.length-1;
        while(right>left && nums[left] >= nums[right]) right--;
        swap(nums,left,right);
        reverse(nums,left+1,nums.length-1);//left+1原为降序，逆转成升序，字典序减小

        long ans=0;
        for(int num : nums)
            ans = ans * 10 + num;
        return ans>Integer.MAX_VALUE ? -1 : (int)ans;
    }

    public int[] toIntArray(int n){
        String s = Integer.toString(n);
        int[] ans = new int[s.length()];
        for(int i=0;i<s.length();i++){
            ans[i] = s.charAt(i) - '0';
        }
        return ans;
    }

    public void reverse(int[] nums,int left,int right){
        while(left < right){
            swap(nums,left,right);
            left++;right--;
        }
    }

    public void swap(int[] nums,int i,int j){
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        下一个更大的数三556 main = new 下一个更大的数三556();

        System.out.println(main.nextGreaterElement(123)); // 132
        System.out.println(main.nextGreaterElement(132)); // 213
        System.out.println(main.nextGreaterElement(21)); // -1

    }
}

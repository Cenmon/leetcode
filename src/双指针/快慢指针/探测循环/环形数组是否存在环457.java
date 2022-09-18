package 双指针.快慢指针.探测循环;

/**
 * @author Cenmo
 * @Date 2022-07-02 2022-07-02
 */
public class 环形数组是否存在环457 {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) continue;

            int slow = i,fast = next(nums,i);
            // 保证同向：slow和fast指向的值同正负，slow和next(nums,fast)是保证不遗漏环的每个节点
            while( nums[slow]*nums[fast]>0 && nums[slow]*nums[next(nums,fast)]>0 ){
                if(slow == fast){
                    if(slow == next(nums,slow)){ // 自环不是循环，开启下一轮
                        break;
                    }
                    return true;// 非自环
                }
                slow = next(nums,slow);
                fast = next(nums,next(nums,fast));
            }

            // 自环或无环时，所有遍历过的节点设为0，即不再遍历
            int index=i;
            while(nums[index]*nums[next(nums,index)]>0){
                nums[index] = 0;
                index = next(nums,index);
            }
        }
        return false;
    }

    public int next(int[] nums,int i){
        return ((i + nums[i]) % nums.length + nums.length) % nums.length;
    }

    public static void main(String[] args) {
        环形数组是否存在环457 main = new 环形数组是否存在环457();

        /**
         * 数组值即向前或向后移动的距离，给出是否存在移动循环
         * 注：自环不属于循环，且移动方向不能改变
         */
        System.out.println(main.circularArrayLoop(new int[]{2,-1,1,2,2})); // true
        System.out.println(main.circularArrayLoop(new int[]{-1,2})); // false
        System.out.println(main.circularArrayLoop(new int[]{-2,1,-1,-2,-2})); // false
    }
}

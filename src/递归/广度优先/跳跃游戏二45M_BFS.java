package 递归.广度优先;

/**
 * @Author Cenmo
 * @Date 2022-09-12 19:32
 * @Description BFS(广度优先)求到达目的地的最少步数：双指针模拟队列
 */
public class 跳跃游戏二45M_BFS {

    /**
     * 思想：主要采用贪心思想，每次跳跃选择可跳范围内能到最远距离的下标位置
     */
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int front=0,rear=0; //队列为空时rear=-1,已将第一个元素放入队列
        int ans = 0;
        while(front <= rear){ // 队列非空
            int length = rear;
            while(front <= length){ // 出队length个
                rear = Math.max(rear,front+nums[front]);//入队
                if(rear >= nums.length-1) return ans+1;
                front++;// 出队
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        跳跃游戏二45M_BFS main = new 跳跃游戏二45M_BFS();

        /**
         * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
         * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
         * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
         * 假设你总是可以到达数组的最后一个位置。
         * 如：
         * 输入: nums = [2,3,1,1,4]
         * 输出: 2
         * 解释: 跳到最后一个位置的最小跳跃数是 2。
         *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
         */
        System.out.println(main.jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(main.jump(new int[]{2,3,0,1,4})); // 2
        System.out.println(main.jump(new int[]{0})); // 0
    }
}

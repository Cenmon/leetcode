package 双指针.窗口指针.滑动窗口.固定窗口;

/**
 * @Author Cenmo
 * @Date 2022-10-02 22:24
 * @Description
 */
public class 爱生气的书店老板1052M {

    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) { // 动态窗口
        int n=customers.length;
        int sum=0;
        int[] angry = new int[n]; // 队列记录生气时刻
        int front=0,rear=0;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 1){
                angry[rear++] = i;
            }else{
                sum += customers[i];
            }
        }

        int j=0,ans=0;
        for(int i=0;i<n;i++){
            while(j<n && (grumpy[j]==0 || j-angry[front]<minutes)){
                if(grumpy[j] == 1)
                    sum += customers[j];
                j++;
            }
            ans = Math.max(ans,sum);
            if(j >= n) break;
            if(grumpy[i] == 1){
                front++; // 出队，front指向下一个生气时刻
                sum -= customers[i];
            }
        }
        return ans;
    }

    // 思路：本题不生气的顾客满意度必定拿到，于是题目原意为固定大小minutes的时间内挽回不满意的顾客
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) { // 固定窗口
        int n=customers.length;
        int sum=0,ans=0;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        // 窗口遍历
        for(int i=0;i<n;i++){
            if(grumpy[i] == 1){ // 入窗口
                sum += customers[i];
            }
            // 初始化窗口大小(i>=minutes)，以及完成出窗口动作
            if(i>=minutes && grumpy[i-minutes] == 1){
                sum -= customers[i-minutes];
            }
            if(sum > ans) ans = sum;
        }

        return ans;
    }


    public static void main(String[] args) {
        爱生气的书店老板1052M main = new 爱生气的书店老板1052M();

        /**
         * 给定n个时刻下顾客到访数组customers以及老板是否发脾气数组grumpy
         * 当grumpy[i]=1时老板发脾气，为0时不发脾气
         * 老板不发脾气时的顾客是满意的，
         * 现控制老板某个时刻开始，连续minutes内不发脾气，返回老书店的最大满意度
         */
        System.out.println(main.maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3)); // 16
        System.out.println(main.maxSatisfied(new int[]{1},new int[]{0},1)); // 1
        System.out.println(main.maxSatisfied(new int[]{2,4,1,4,1},new int[]{1,0,1,0,1},2)); // 10
    }
}

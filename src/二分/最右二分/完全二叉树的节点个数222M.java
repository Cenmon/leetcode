package 二分.最右二分;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @Author Cenmo
 * @Date 2022-10-11 12:41
 * @Description
 */
public class 完全二叉树的节点个数222M {

    public int countNodes(TreeNode root) {
        TreeNode p = root;
        int h = 0;
        while(p != null){
            h++;
            p = p.left;
        }
        // System.out.println(h);
        if(h == 0) return 0;
        // 最右二分
        int left = (1<<(h-1)),right = (1<<h)-1;
        // System.out.println(left + " , " + right);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(existK(root,mid)){
                // System.out.println(mid+" exist:true");
                left = mid + 1;
            }else{
                // System.out.println(mid+" exist:false");
                right = mid - 1;
            }
        }
        return right;
    }

    private double LOG2 = Math.log(2);
    // 判断是否存在通往编号k节点的路径
    // private boolean existK(TreeNode root,int k){
    //     // k节点所在层数h = logk + 1;
    //     int h = (int)(Math.log(k)/LOG2) + 1;
    //     // System.out.println("k = " + k +" , h = " + h);
    //     // 获取从根节点到编号k节点的路径编号，如k=6,则经过的节点路径为1-3-6
    //     int[] nums = new int[h];
    //     for(int i=h-1;i>=0;i--){
    //         nums[i] = k;
    //         k /= 2;
    //     }
    //     // System.out.println(Arrays.toString(nums));
    //     for(int i=0;i<h;i++){// 第i层是否可达
    //         if(root == null) return false;
    //         if(i == h-1) return true;
    //         if(nums[i+1] == 2*nums[i]){ // 路径下一节点是在左边2i,反之2i+1在右边
    //             root = root.left;
    //         }else{
    //             root = root.right;
    //         }
    //     }
    //     return false;
    // }

    // 判断是否存在通往编号k节点的路径
    private boolean existK(TreeNode root,int k){
        // k节点所在层数h = logk + 1;
        int h = (int)(Math.log(k)/LOG2) + 1;
        // 获取从根节点到编号k节点的路径编号，如k=6,则经过的节点路径为1-3-6
        boolean[] turnLeft = new boolean[h];
        for(int i=h-1;i>=0;i--){
            if((k & 1) == 0) turnLeft[i] = true;
            k >>= 1;
        }
        // System.out.println(Arrays.toString(nums));
        for(int i=0;i<h;i++){// 第i层是否可达
            if(root == null) return false;
            if(i == h-1) return true;
            if(turnLeft[i+1]){ // 路径下一节点是在左边2i,反之2i+1在右边
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        完全二叉树的节点个数222M main = new 完全二叉树的节点个数222M();

        /**
         * 给定一个完全二叉树，计算完全二叉树中节点的个数
         * 注：0 <= node.val <= 5*10e4
         */
        System.out.println(main.countNodes(TreeUtils.create(new int[]{1,2,3,4,5,6}))); // 6
        System.out.println(main.countNodes(TreeUtils.create(new int[]{}))); // 0
        System.out.println(main.countNodes(TreeUtils.create(new int[]{1}))); // 1
    }
}

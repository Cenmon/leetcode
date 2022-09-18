package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-11 2022-03-11
 * https://www.youtube.com/watch?v=LUWuPSKksCE
 */
public class 二叉树中的最大路径和_交叉路径 {

    public int maxPathSum (TreeNode root) {
        // write code here
        // 最大交叉路径的和，即左孩子->根->右孩子
        int[] sum = new int[] {Integer.MIN_VALUE}; // 传入数组引用，即相当于传入指针
        getMaxPathSum(root,sum);
        return sum[0];
    }

    /**
     * 返回值返回左右子树的最大路径，sum保存左右子树的交叉路径最大和
     * 类似于求树高
     * @param root
     * @param sum
     * @return
     */
    private int getMaxPathSum(TreeNode root, int[] sum) {
        if(root == null) return 0;
        int left = Math.max(getMaxPathSum(root.left,sum),0); // 保证左子树的最大路径和大于0
        int right = Math.max(getMaxPathSum(root.right,sum),0);

        sum[0] = Math.max(sum[0],root.val+left+right); //最大路径和是左子树最大路径和 + 右子树最大路径和 + 当前节点
        return Math.max(left,right)+root.val; // 子树应该选择一条左右孩子较大的路径
    }

    public static void main(String[] args) {
        二叉树中的最大路径和_交叉路径 main = new 二叉树中的最大路径和_交叉路径();

        TreeUtils treeUtils = new TreeUtils();
        TreeNode root = treeUtils.create(new int[]{-20,8,20,-1,-1,15,6}); //15+20+6=41

        treeUtils.levelPrint(root);
        int res = main.maxPathSum(root);
        System.out.println("res = " + res);
    }
}

package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 二叉树根节点到叶子节点的所有路径和 {

    /**
     * 所有从根节点到叶子节点组成的数字之和
     * @param root
     * @return
     */
    public int sumNumbers (TreeNode root) {
        // write code here
        return doSum(root,0);
    }

    public int doSum(TreeNode root,int sum){
        if(root == null) return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) return sum; //处理叶子节点
        // 非叶子节点包括左右非空，左空右不空，左不空右空，处理空指针时，返回路径和为0
        return doSum(root.left,sum) + doSum(root.right,sum);
    }

    public static void main(String[] args) {
        二叉树根节点到叶子节点的所有路径和 main = new 二叉树根节点到叶子节点的所有路径和();

        TreeUtils treeUtils = new TreeUtils();
//        TreeNode root = treeUtils.create(new int[] {1,2,3}); // 12+13=25
//        TreeNode root = treeUtils.create(new int[] {1,0}); // 10
        TreeNode root = treeUtils.create(new int[] {1,2,0,3,4}); // 123+124+10=257

        int allPathSum = main.sumNumbers(root);
        System.out.println("allPathSum = " + allPathSum);

    }
}

package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 判断是不是平衡二叉树_先序 {

    public boolean IsBalanced_Solution(TreeNode root) {
        //先序遍历
        if(root == null) return true;

        int leftHeight = judgeHeight(root.left);
        int rightHeight = judgeHeight(root.right);

        if(Math.abs(leftHeight-rightHeight) > 1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int judgeHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(judgeHeight(root.left),judgeHeight(root.right))+1;
    }

    public static void main(String[] args) {
        判断是不是平衡二叉树_先序 main = new 判断是不是平衡二叉树_先序();
        TreeUtils treeUtils = new TreeUtils();

        int[] arr = new int[] {1,2,3,4,5,6,7};
        TreeNode head = treeUtils.create(arr);
        treeUtils.levelPrint(head);
        boolean res = main.IsBalanced_Solution(head);
        System.out.println("res = " + res);

    }
}

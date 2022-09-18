package 递归;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 求树高 {

    public int judgeHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(judgeHeight(root.left),judgeHeight(root.right))+1;
    }

    public static void main(String[] args) {
        求树高 main = new 求树高();
        TreeUtils treeUtils = new TreeUtils();

        int[] arr = new int[] {1,2,3,4,5,6,7}; // 3
        TreeNode head = treeUtils.create(arr);
        treeUtils.levelPrint(head);
        int res = main.judgeHeight(head);
        System.out.println("res = " + res);

    }
}

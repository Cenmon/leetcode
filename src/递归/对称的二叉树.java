package 递归;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return judge(pRoot.left,pRoot.right);
    }

    boolean judge(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        return t1.val == t2.val && judge(t1.left,t2.right) && judge(t1.right,t2.left);
    }

    public static void main(String[] args) {
        对称的二叉树 main = new 对称的二叉树();

        TreeUtils treeUtils = new TreeUtils();
//        TreeNode head = treeUtils.create(new int[]{1,2,2,3,4,4,3}); // true
//        TreeNode head = treeUtils.create(new int[]{8,6,9,5,7,7,5}); // false 值不同
        TreeNode head = treeUtils.create(new int[]{1,2,2,-1,3,-1,3}); // false 结构不对称

        treeUtils.levelPrint(head);
        boolean res = main.isSymmetrical(head);
        System.out.println("res = " + res);
    }
}

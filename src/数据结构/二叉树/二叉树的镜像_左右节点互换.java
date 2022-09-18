package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-08 2022-03-08
 */
public class 二叉树的镜像_左右节点互换 {

    public TreeNode Mirror (TreeNode root) {
        // write code here
        if(root == null) return null;
        Mirror(root.left);
        Mirror(root.right); // 先序后序都一样

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        二叉树的镜像_左右节点互换 main = new 二叉树的镜像_左右节点互换();

        TreeUtils treeUtils = new TreeUtils();
        TreeNode head = treeUtils.create(new int[]{8,6,10,5,7,9,11}); // {8,10,6,11,9,7,5}

        treeUtils.levelPrint(head);
        TreeNode res = main.Mirror(head);
        treeUtils.levelPrint(res);
    }
}

package 递归;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-03-09 2022-03-09
 */
public class 最近公共祖先 {

    TreeNode lca = null;
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here

        find2(root,o1,o2);
//         TreeNode lca = find(root,o1,o2);

        return lca.val;
    }

    // 利用一个TreeNode节点标志左右子树是否为所求值
    public TreeNode find(TreeNode root,int o1,int o2){
        if(root==null || root.val==o1 || root.val==o2) return root;

        TreeNode left = find(root.left,o1,o2);
        TreeNode right = find(root.right,o1,o2);

        // 当标志TreeNode左右非空时，则该节点为最近公共祖先
        if(left!=null && right!=null) return root;
        // 返回标志节点，原本为返回标志节点root，但root.left=left,root.right=right可省略
        return left!=null?left:right;
    }

    public int find2(TreeNode root,int o1,int o2){
        if(root == null) return 0;
        if(root.val == o1) return 1;//01
        if(root.val == o2) return 2;//10 两个bit为标志左右子树情况

        int lstate = find2(root.left,o1,o2);
        int rstate = find2(root.right,o1,o2);

        int state = 0;
        state |= lstate | rstate;//或运算
//         state |= rstate;

        if(state == 3) lca = root;//11
        return state;
    }

    public static void main(String[] args) {
        最近公共祖先 main = new 最近公共祖先();

        TreeUtils treeUtils = new TreeUtils();

        TreeNode head = treeUtils.create(new int[]{3,5,1,6,2,0,8,-1,-1,7,4});
        treeUtils.levelPrint(head);
        int res = main.lowestCommonAncestor(head, 5, 1 ); // 3
//        int res = main.lowestCommonAncestor(head, 2, 7 ); // 2
        System.out.println("res = " + res);


    }
}

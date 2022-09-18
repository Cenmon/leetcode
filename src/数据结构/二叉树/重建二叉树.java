package 数据结构.二叉树;

import Utils.TreeNode;
import Utils.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int [] pre, int [] vin) {
        // 先序确定根节点，中序确定根节点左右子树的节点个数
        Map<Integer,Integer> in = new HashMap<>();
        for(int i=0;i<vin.length;i++){
            in.put(vin[i],i);
        }
        return doConstruct(pre,0,pre.length-1,in,0,vin.length-1);

    }

    private TreeNode doConstruct(int[] pre, int pleft, int pright, Map<Integer, Integer> in, int ileft, int iright) {

        if(pleft > pright || ileft > iright) return null;

        // 先序遍历确定根节点
        TreeNode root = new TreeNode(pre[pleft]);

        //中序遍历确定左右子树节点个数
        Integer rootIndex = in.get(root.val);
        int leftSubTreeLen = rootIndex - ileft;

        //构建左右子树
        // 左子树：先序中pleft+1 ~ pleft+leftSubTreeLen ; 中序中ileft ~ rootIndex-1
        // 右子树：先序中pleft+leftSubTreeLen+1 ~ pright ; 中序中rootIndex+1 ~ iright
        root.left = doConstruct(pre,pleft+1,pleft+leftSubTreeLen,in,ileft,rootIndex-1);
        root.right = doConstruct(pre,pleft+leftSubTreeLen+1,pright,in,rootIndex+1,iright);
        return root;
    }

    public static void main(String[] args) {
        重建二叉树 main = new 重建二叉树();

        // {1,2,3,4,#,5,6,#,7,#,#,8}
        TreeNode root = main.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});

        //{1}
//        TreeNode root = main.reConstructBinaryTree(new int[]{1}, new int[]{1});

        //{1,2,5,3,4,6,7}
//        TreeNode root = main.reConstructBinaryTree(new int[]{1,2,3,4,5,6,7}, new int[]{3,2,4,1,6,5,7});

        new TreeUtils().levelPrint(root);
    }
}

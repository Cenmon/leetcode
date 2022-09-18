package 双指针.对撞指针.两数之和;

import Utils.TreeNode;
import Utils.TreeUtils;

/**
 * @author Cenmo
 * @Date 2022-07-10 2022-07-10
 */
public class 两数之和andBST { // 两数之和和二叉搜索树
    public boolean findTarget(TreeNode root, int k) {
        return findOther(root,root,k);
    }

    public boolean findOther(TreeNode root,TreeNode cur,int k){
        // 哈希思想，确定一个数为当前值，找另一个数k-cur.val是否存在
        // 注：此方法时间复杂度应该为O(nlogn),可以设置hashSet提高时间复杂度为O(n)，但实际set运算效果差不多
        if(cur == null) return false;
        TreeNode p = root;
        int target = k - cur.val;
        while ( p != null ){
            if(p != cur && target == p.val) return true;
            else if(target < p.val) p = p.left;
            else p = p.right;
        }
        return findOther(root,cur.left,k) || findOther(root,cur.right,k);
    }

    public static void main(String[] args) {
        /**
         * 在二叉搜索树中找出两个数，其和为给定值
         */
        两数之和andBST main = new 两数之和andBST();

        System.out.println(main.findTarget(TreeUtils.create(new int[]{5,3,6,2,4,-1,7}),9)); // true 5+4=9
        System.out.println(main.findTarget(TreeUtils.create(new int[]{5,3,6,2,4,-1,7}),28)); // false
    }
}

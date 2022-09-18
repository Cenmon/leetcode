package 双指针.异地指针;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p = headA,q = headB;
        /**
         第一次到达null，计算出长链和短链的长度差
         第二次到达null，长链走过长度差的节点
         此刻链表指向处长度相同，故必有交点
         */
        while(p != q){
            p = p==null ? headB : p.next;
            q = q==null ? headA : q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        相交链表 main = new 相交链表();

        ListNode l1 = ListUtils.create(new int[]{   4, 1, 8, 4, 5});
        ListNode l2 = ListUtils.create(new int[]{5, 6, 1});
        ListNode tail = ListUtils.getTail(l2);
        tail.next = l1.next.next;

        System.out.println(main.getIntersectionNode(l1,l2).val); //8
    }
}

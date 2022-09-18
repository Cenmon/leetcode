package 数据结构.链表;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-10 2022-03-10
 */
public class 两个链表的第一个公共结点_剑指023E {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode m = pHead1,n = pHead2;
        while(m != null && n != null){ // 计算两个链表的长度差k
            m=m.next; n=n.next;
        }
        ListNode p = pHead1,q = pHead2; //p,q指向距离相同的链表
        while (m != null) {p = p.next; m = m.next;} // 右移m指针，使得p指向第k个节点，n同理
        while (n != null) {q = q.next; n = n.next;}

        while(p != null && q != null){
            if( p == q ) return p;
            p = p.next; q = q.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA,q = headB;
        while(p!=q){
            p = p!=null ? p.next : headB;
            q = q!=null ? q.next : headA;
        }
        return p;
    }

    public static void main(String[] args) {
        两个链表的第一个公共结点_剑指023E main = new 两个链表的第一个公共结点_剑指023E();

        ListUtils listUtils = new ListUtils();
        ListNode list1 = listUtils.create(new int[] {1, 2, 3, 4, 5});
        ListNode list2 = listUtils.create(new int[] {6});

        ListNode tail = listUtils.getTail(list2);
        tail.next = list1.next.next;

        listUtils.print(list1);
        listUtils.print(list2);

        ListNode common = main.FindFirstCommonNode(list1, list2);
        System.out.println("common.val = " + common.val);
    }
}

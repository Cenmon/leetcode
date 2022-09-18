package 数据结构.链表;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-03-03 2022-03-03
 */
public class 单链表的排序 {

    public ListNode sortInList (ListNode head) {
        // write code here
        if(head == null || head.next==null) return head;

        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;// 化整为零，将单链表从中间断开，成两条

        ListNode left = sortInList(head);
        ListNode right = sortInList(list2);

        return merge(left,right);
    }

    public ListNode merge(ListNode list1,ListNode list2){
        ListNode p=list1,q=list2;
        ListNode res = new ListNode(-1);
        ListNode tail = null;
        for(tail = res;p!=null && q!=null;tail=tail.next){
            if(p.val < q.val) {
                tail.next = p;
                p = p.next;
            }else{
                tail.next = q;
                q = q.next;
            }
        }
        tail.next = null;
        if(p != null) tail.next = p;
        if(q != null) tail.next = q;
        return res.next;
    }

    public static void main(String[] args) {
        单链表的排序 main = new 单链表的排序();
        ListUtils listUtils = new ListUtils();

        ListNode head = listUtils.create(new int[]{1, 3, 2, 4, 5});
        listUtils.print(head);
        ListNode res = main.sortInList(head);
        listUtils.print(res);

    }
}

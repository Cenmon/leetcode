package 数据结构.链表.重排;

import Utils.ListNode;
import Utils.ListUtils;

/**
 * @author Cenmo
 * @Date 2022-06-30 2022-06-30
 */
public class 重排链表143M {

    public ListNode reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode l1=head,l2=mid.next;
        mid.next = null;
        l2 = inverseList(l2);
        return mergeList(l1,l2);
    }

    public ListNode findMid(ListNode head){ // 偶数个，返回中间节点靠右侧节点；奇数个，返回中间节点
        ListNode slow=head,fast=head; // 靠右侧中间节点
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode inverseList(ListNode head){
        ListNode phead = null,p = head,r=null;// 头指针形式逆置，还有头结点形式的逆置
        while(p != null){
            r = p.next;
            p.next = phead;
            phead = p;
            p = r;
        }
        return phead;
    }

    public ListNode mergeList(ListNode l1,ListNode l2){ // 交叉合并
        ListNode head=l1,tmp1=null,tmp2=null;
        while(l1!=null && l2!=null){
            tmp1 = l1.next;
            tmp2 = l2.next;

            l1.next = l2;
            l1 = tmp1;

            l2.next = l1;
            l2 = tmp2;
        }
        return head;
    }

    public static void main(String[] args) {
        重排链表143M main = new 重排链表143M();

        /**
         * 给定链表，将链表重排为L1,Ln-1,L2,Ln-2,L3,Ln-3....交叉重排链表
         */
        ListUtils.print(main.reorderList(ListUtils.create(new int[]{1,2,3,4}))); // 1,4,2,3
        ListUtils.print(main.reorderList(ListUtils.create(new int[]{1,2,3,4,5}))); // 1,5,2,4,3
    }
}

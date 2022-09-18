package 数据结构.链表.交换节点;

import Utils.ListNode;
import Utils.ListUtils;

public class 交换链表中的节点1721M {

    public ListNode swapNodes(ListNode head, int k) {  // 交换节点
        ListNode phead = new ListNode();
        phead.next = head;

        ListNode p = phead;
        ListNode kth,lastkth,pre1,pre2;
        for(int i=1;i<k;i++) p = p.next;
        pre1 = p;
        kth = p.next;

        p = p.next.next;
        pre2 = phead;
        while(p != null){
            p = p.next;
            pre2 = pre2.next;
        }
        lastkth = pre2.next;

        pre1.next = lastkth;
        pre2.next = kth;

        p = lastkth.next; // 交换
        lastkth.next = kth.next;
        kth.next = p;
        return phead.next;
    }

    public ListNode swapNodes2(ListNode head, int k) {  // 交换值
        ListNode phead = new ListNode();
        phead.next = head;

        ListNode p = phead;
        ListNode kth,lastkth;
        for(int i=0;i<k;i++) p = p.next; // 起始p指向0节点，后移k个，指向第k个节点
        kth = p;

        lastkth = phead;
        while(p != null){
            p = p.next;
            lastkth = lastkth.next;
        }

        int tmp = kth.val;
        kth.val = lastkth.val;
        lastkth.val = tmp;

        return phead.next;
    }


    public static void main(String[] args) {
        交换链表中的节点1721M main = new 交换链表中的节点1721M();

        /**
         * 给定链表以及k值，交换链表中第k项和倒数第k项
         */
        ListUtils.print(main.swapNodes(ListUtils.create(new int[]{1,2,3,4,5}),2)); // 1,4,3,2,5
        ListUtils.print(main.swapNodes(ListUtils.create(new int[]{7,9,6,6,7,8,3,0,9,5}),5)); // 7,9,6,6,8,7,3,0,9,5
        ListUtils.print(main.swapNodes(ListUtils.create(new int[]{1}),1)); // 1
        ListUtils.print(main.swapNodes(ListUtils.create(new int[]{1,2}),1)); // 2,1
        ListUtils.print(main.swapNodes(ListUtils.create(new int[]{1,2,3}),2)); // 1,2,3
    }
}

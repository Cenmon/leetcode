package 数据结构.链表;

import Utils.ListNode;

public class 链表环的入口节点	{

	public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead,fast = pHead; // 快慢指针均多走一步，最后会在交点处多走一步
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = pHead; // slow指向第一个，若指向第0个，交点处指针应退后一个
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        ListNode slow = head,fast = head.next;// 慢指针走s步，快指针严格走f=2s步
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;
        fast = head;// fast指向第一个节点，要比交点节点多走一个，故交点节点也要多走
        slow = slow.next;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
            System.out.println(slow.val);
        }
        return slow;
    }

	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = head.next;

		链表环的入口节点 main = new 链表环的入口节点();
		ListNode ret = main.EntryNodeOfLoop(head);
		System.out.println(ret.val);
	}
}
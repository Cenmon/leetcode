package 双指针.快慢指针.移除元素;

import Utils.ListNode;
import Utils.ListUtils;

public class 删除有序链表中重复的元素二 {

    public ListNode deleteDuplicates (ListNode head) {
	    if(head == null || head.next == null) return head;
	    ListNode slow=head,fast=head.next;
	    ListNode pre = slow;
	    while(fast != null){
	        pre.next = null; // 解除链表关系，便于垃圾回收
	        if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            pre = fast;
            fast = fast.next;
        }
        slow.next = null;
	    return head;
    }

	public static void main(String[] args){
		删除有序链表中重复的元素二 main = new 删除有序链表中重复的元素二();

        /**
         * 保留一个重复的元素
         */
        ListNode head = ListUtils.create(new int[] {0,0,1,1,1,2,2,3,3,4});
        ListUtils.print(head);
		head = main.deleteDuplicates(head);
        ListUtils.print(head);
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}
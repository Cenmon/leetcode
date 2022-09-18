package 数据结构.链表;

import Utils.ListNode;
import Utils.ListUtils;

public class 删除链表的倒数第n个节点_剑指021M {

	public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode res = new ListNode(-1);
        res.next = head;
        
        ListNode p = res,q=res;//q前移n步
        for(int i=0;i<n;i++) q = q.next;
        
        while(q.next != null){ //p，q同时前移，q到尾结点，则p到倒数n+1个节点
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return res.next;
    }

	public static void main(String[] args){
		删除链表的倒数第n个节点_剑指021M main = new 删除链表的倒数第n个节点_剑指021M();
		ListUtils listUtils = new ListUtils();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		listUtils.print(head);
		head = main.removeNthFromEnd(head,2);
		listUtils.print(head);

		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}
package 数据结构.链表;

import Utils.ListNode;

public class 链表相加{
	public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        
        ListNode ans = head1;
        ListNode p=head1,q=head2,pre=null;
        for(;p!=null && q!=null;p=p.next,q=q.next){
            p.val = p.val + q.val;
            pre = p;
        }
        if(q != null) pre.next = q;

        // print(ans);
        ans = carry(ans);//进一
        
        return reverse(ans);
        // return head1;
    }
    
    public ListNode carry(ListNode head){
        ListNode p = head;
        while( p != null ){
            if(p.val >= 10){
                p.val = p.val % 10;
                if(p.next == null) {
	                p.next = new ListNode(0);
            	}
            	p.next.val += 1;
            }
            p = p.next;
        }
        return head;
    }
    
    public ListNode reverse(ListNode head){
        ListNode p = head,r;
        
        head = null;
        while(p != null){
            r = p.next;
            p.next = head;
            head = p;
            p = r;
        }
        return head;
    }

    public void print(ListNode head){
    	ListNode p = head;
        while(p != null){
            System.out.print(p.val+" ");
            p = p.next;
        }
        System.out.println();
    }

	public static void main(String[] args){
		链表相加 list_add = new 链表相加();

		ListNode head1 = new ListNode(0);
		// head1.next = new ListNode(3);
		// head1.next.next = new ListNode(7);

		ListNode head2 = new ListNode(6);
		head2.next = new ListNode(3);
		// head2.next.next = new ListNode(7);

		ListNode ans = list_add.addInList(head1,head2);
		list_add.print(ans);
	}

}
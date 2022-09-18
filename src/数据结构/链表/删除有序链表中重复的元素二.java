package 数据结构.链表;

import Utils.ListNode;
import Utils.ListUtils;

import java.util.HashMap;
import java.util.Map;

public class 删除有序链表中重复的元素二 {

	public ListNode deleteDuplicates2 (ListNode head) { //哈希表记录重复次数
        // write code here
        if(head == null) return null;
        
        ListNode res = new ListNode(-1);
        ListNode tail = res;
        Map<Integer,Integer> map = new HashMap<>();
        for(ListNode p=head;p != null;p = p.next){
            if(map.containsKey(p.val))
                map.put(p.val,map.get(p.val)+1);
            else
                map.put(p.val,1);
        }
        System.out.println(map.toString());
        for(ListNode p=head;p != null;p = p.next){
            if(map.get(p.val) == 1){
                tail.next = p;
                tail = tail.next;
            }
        }
        tail.next = null;
        return res.next;
    }

    public ListNode deleteDuplicates3 (ListNode head){ // accept
	    ListNode tail = head,r;
	    for(ListNode p = head.next;p!=null;){
            r = p.next;
	        if(p.val != tail.val){
	            p.next = tail.next;
	            tail.next = p;
	            tail = tail.next;
            }
            p = r;
        }
	    tail.next = null;
	    return head;
    }
    
    public ListNode deleteDuplicates (ListNode head) {//三指针
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(head.val-1);
        res.next = head;
        
        ListNode left=res;
        ListNode pre=res,right=head,post = head.next;
        while( post != null ){//right指向最后一个节点时结束，最后一个节点未处理
            if(post.val != right.val && pre.val != right.val){
                left.next = right;
                left = right;
            }
            pre = right;
            right = post;
            post = post.next;
        }
        if(right.val != pre.val) left.next = right;//处理left的尾结点
        else left.next = null;
        return res.next;
    }

	public static void main(String[] args){
		删除有序链表中重复的元素二 main = new 删除有序链表中重复的元素二();

        ListUtils utils = new ListUtils();
        ListNode head = utils.create(new int[] {1,2,2,3,4,4,5,6,8,9,9});

        utils.print(head);
//		head = main.deleteDuplicates(head);
		head = main.deleteDuplicates3(head);
        utils.print(head);
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}
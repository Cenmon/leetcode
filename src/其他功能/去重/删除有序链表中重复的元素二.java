package 其他功能.去重;

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
    
    public ListNode deleteDuplicates3 (ListNode head) {//三指针
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

    public ListNode deleteDuplicates (ListNode head) { //双指针：快慢指针
	    ListNode id = head,tmp;// id指向最大的未重复元素
        ListNode p=head.next;
	    while(p!=null){
	        if(p.val != id.val){
	            tmp = p.next; //暂记当前节点

	            p.next = id.next; //插入到当前id节点的后面
	            id.next = p;

	            id = id.next;
	            p = tmp;
            }else{ //若重复，则直接下一个
                p=p.next;
            }
        }
        id.next = null;

	    return head;
    }

	public static void main(String[] args){
		删除有序链表中重复的元素二 main = new 删除有序链表中重复的元素二();

        ListUtils utils = new ListUtils();
        ListNode head = utils.create(new int[] {1,2,2});

        utils.print(head);
		head = main.deleteDuplicates(head);
        utils.print(head);
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}
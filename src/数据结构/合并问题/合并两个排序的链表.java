package 数据结构.合并问题;

import Utils.ListNode;
import Utils.ListUtils;

public class 合并两个排序的链表 {

	public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){//list1链接到res
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = null;
        if(list1!=null) tail.next = list1;
        if(list2!=null) tail.next = list2;

        return head.next;
    }

	public static void main(String[] args){
		合并两个排序的链表 main = new 合并两个排序的链表();
		ListUtils listUtil = new ListUtils();
		// ArrayUtils arrayUtil = new ArrayUtils();

		ListNode list1 = listUtil.create(new int[] {1,3,5});
		ListNode list2 = listUtil.create(new int[] {2,4,6});//{-1,2,4},{1,3,4}
		ListNode res = main.Merge(list1,list2);
		listUtil.print(res);
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
		// System.out.println( main.func() );
	}

}
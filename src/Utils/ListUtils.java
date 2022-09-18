package Utils;

public class ListUtils {

    /**
     * 获取并打印链表长度
     * @param head
     * @return
     */
	public static int length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }
        System.out.println("length="+length);
        return length;
    }

    /**
     * 打印链表
     * @param head
     */
    public static void print(ListNode head){
        ListNode p=head;
        System.out.print("list: ");
        while(p!=null){
            System.out.print(p.val);
            p = p.next;
            if(p != null)
                System.out.print(",");
        }
        System.out.println();
    }

    /**
     * 根据数组创建链表
     * @param arr
     * @return
     */
    public static ListNode create(int[] arr){
	    if(arr == null) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode tail = head;
        for(int i=1;i<arr.length;i++){
            tail.next = new ListNode(arr[i]);
            tail = tail.next;
        }
        return head;
    }

    /**
     * 获取左侧中间节点
     * @param head
     * @return
     */
    public static ListNode getLeftMid(ListNode head){
        ListNode slow=head,fast=head.next;// 偶数个，返回中间节点靠左侧节点；奇数个，返回中间节点
//        ListNode slow=head,fast=head;// 偶数个，返回中间节点靠右侧节点；奇数个，返回中间节点

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode getRightMid(ListNode head){
//        ListNode slow=head,fast=head.next;// 偶数个，返回中间节点靠左侧节点；奇数个，返回中间节点
        ListNode slow=head,fast=head;// 偶数个，返回中间节点靠右侧节点；奇数个，返回中间节点

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode inverseList(ListNode head){
        ListNode phead = null,p = head,r=null;// 头指针形式逆置，还有头结点形式的逆置
        while(p != null){
            r = p.next;
            p.next = phead;
            phead = p;
            p = r;
        }
        return phead;
    }

    /**
     * 归并排序链表
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getLeftMid(head);
        ListNode l1 = head,l2 = mid.next;
        mid.next = null;

        l1 = sortList(l1);
        l2 = sortList(l2);
        return mergeList(l1,l2);
    }

    public static ListNode mergeList(ListNode l1,ListNode l2){ // 按升序合并链表
        ListNode head = new ListNode(-1),tail = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;
        return head.next;
    }

    public static ListNode mergeListCross(ListNode l1,ListNode l2){ // 交叉合并链表,即l1一个，l2一个交叉
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

    public static boolean hasCycle(ListNode head) { // 判断是否有环
        if(head == null) return false;
        ListNode slow=head,fast=head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) { // 寻找环表入口
        if(head == null) return null; // 无环
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null; // 无环
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 获取倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head,int k){
        ListNode phead = new ListNode(-1,head);
        ListNode slow = phead,fast = phead;
        for(int i=0;i<k;i++) fast = fast.next;

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode getTail(ListNode list) {
        return getKthFromEnd(list,1);// 倒数第一个节点
    }

    public static void main(String[] args) {
        ListNode mid = ListUtils.getLeftMid(ListUtils.create(new int[]{1, 2}));
        System.out.println("mid.val = " + mid.val);
    }

}
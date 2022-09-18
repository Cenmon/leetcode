import java.util.*;

class LNode{
	Integer key;
	Integer value;
	LNode pre;
	LNode next;

	LNode(Integer key,Integer value){
		this.key = key;
		this.value = value;
	}
}

public class LRU缓存{
	private  Integer capacity;
	private  Map<Integer,LNode> map = new HashMap();// map save key and node
	private  LNode head = new LNode(-1,-1);// double list among all nodes
	private  LNode tail = new LNode(-1,-1);

	public  int[] LRU (int[][] operators, int k) {
		this.capacity = k;
		List<Integer> resList = new ArrayList<>();

		head.next = tail; // init double list
		tail.pre = head;

		for(int[] item : operators){
			if(item[0] == 1){
				set(item[1],item[2]);// set key and value
			}else if (item[0] == 2){
				Integer value = get(item[1]);//get key
				resList.add(value);
			}
		}

		int res[] = new int[resList.size()];// list to array,used to return
		for(int i=0;i<resList.size();i++){
			res[i] = resList.get(i);
		}

		return res;

	}

	private  Integer get(Integer key){
		if(map.containsKey(key)){ // whether map contain key
			LNode node = map.get(key);
			MoveToTop(node);
			return node.value;
		}else{
			return -1;
		}
	}

	private  void set(Integer key,Integer value){ // add new node and set double list
		if(map.containsKey(key)){ // whether map contain key
			LNode node = map.get(key);
			node.value = value;
			MoveToTop(node);
		}else{
			if(map.size() == capacity) DeleteLastNode(); // whether LRU overflown

			LNode newNode = new LNode(key,value);
			LNode tmp = head.next; // double list add item
			head.next = newNode;
			newNode.next = tmp;
			tmp.pre = newNode;
			newNode.pre = head;

			map.put(key,newNode);
		}
	}

	private  void DeleteLastNode(){
		LNode lastNode = tail.pre;//delete lastNode
		lastNode.pre.next = tail;
		lastNode.next.pre = lastNode.pre;

		map.remove(lastNode.key);
	}

	private  void MoveToTop(LNode node){
		node.pre.next = node.next;//delete node
		node.next.pre = node.pre;

		LNode tmp = head.next;// add node to top
		head.next = node;
		node.next = tmp;
		tmp.pre = node;
		node.pre = head;
	}

	public static void main(String[] args){

		LRU缓存 lru = new LRU缓存();

		System.out.println("你好中国3");

		// int[][] in = new int[][] {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
		// int[] a = lru.LRU(in,3);


		int[][] in = new int[][] {{1,1,1},{1,2,2},{2,1},{1,3,3},{2,2},{1,4,4},{2,1},{2,3},{2,4}};
		int[] a = lru.LRU(in,2);


		for (int aa : a) {
			System.out.print(aa+" ");
		}
		System.out.println();

	}
}
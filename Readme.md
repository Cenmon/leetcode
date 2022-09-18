目录  

[TOC]

# 常用思想
## 双指针
> 1. 两数之和：解决计算和一类的问题  
> 
> 	重复元素：左右指针是否有重复元素  
> 	左右相同：当剩余元素[left+1,right-1]相同时，由于已排序，故左右指针会指向相同元素，可采用组合Cmn思想确定二元组个数  
> 
> 2. 模拟栈：解决类似"移除元素"一类问题  
> ```java
> int top = -1; // 空栈
> for(int i=0;i<n;i++){
> 	if(arr[i] != 0){
> 		arr[++top] = arr[i]; // 入栈
> 	}
> }
> ```
> 
> 3. 滑动窗口：存在窗口[i,i+x]，当左端点i变化，右端点i+x同样变化  
> 模板一：可遍历左端点,右端点左侧即为窗口，左端点移动时即移出窗口  
> **注：若arr[right] < k，会导致while未执行，即right < left,此时需要重置right**
> ```java
> for(int i=0;i<n;i++){
> 	while(right<n && i+arr[right] < k){
> 		right++;
> 	}
> 	ans += right-i;
> 	operate(left);//左移出窗口
> }
> ```
## 扫描线算法
> 用于应对区间相关相关的题目  
> 1. 差分数组求和：可统计区间内各个元素的查询次数,受给定区间的表示范围影响，其表示范围应在固定范围内
> ```java
> int[] diff = new int[n+1];
> for(int[] interval : intervals){ //区间表示范围为(0~n-1)
> 	diff[ interval[0] ]  += 1; // 开始事件
> 	diff[ interval[1]+1 ] -= 1; // 结束事件
> }
> int sum = 0;
> for(int i=0;i<n;i++){
> 	sum += diff[i]; // 统计频率,sum表示数轴arr[i]点的访问次数，若为0，表示没有区间覆盖过
> 	diff[i] = diff;
> }
> ```
> 
> 2. List/Map存储事件+排序:不受给定区间的表示范围影响
> ```java
> List<Event> events = new ArrayList<>();
> for(int[] interval : intervals){
> 	events.add(interval[0],1); // 开始事件
> 	events.add(interval[1],-1); // 结束事件
> }
> Collections.sort(events,(o1,o2)->o1.pos-o2.pos);
> ```
> 
> 3. 线段树：待更新
> 
> 4. 数组排序+优先队列模拟
> ```java
> Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
> PriorityQueue<int[]> queue = new PriorityQueue<>();
> while(!queue.isEmpty()){
> 	
> }
> ```

# 数据结构
> ## 链表
>基本操作：倒数第k个节点，找中间节点，链表逆置
>> 倒数第k个节点：快慢指针  
>> <span style="color: red">@Cenmon:相同起点，快指针先走k步</span>
>> ```java
>> ListNode slow=head,fast=head;
>> for(int i=0;i<k;i++) fast=fast.next;
>> ```
>> 找中间节点：快慢指针  
>> <span style="color: red">@Cenmon:slow和fast的初始位置决定链表偏左中间节点还是偏右中间节点</span>
>> ```java
>> // 当slow和fast均指向0节点,最终slow指向偏左中间节点
>> slow=head;fast=head.next;
>> // 当slow和fast均指向1节点,最终slow指向偏右中间节点
>> slow=head;fast=head;
>> ```
>> 链表逆置：头插法  
>> <span style="color: red">@Cenmon:p指针指向旧链表，head指向新链表(故初始值为null)</span>
>> ```java
>> // head指向链表前一个节点，p指向链表的第一个节点
>> ListNode p = head.next;
>> head.next = null;
>> // head指向链表的第一个节点，p指向链表第一个节点
>> ListNode p = head;
>> head = null;
>> ```

>## 字符串
>基本操作：判断子序列，判断回文串，字符串排列(计数数组),子串的处理  
>>判断子序列:
>>```java
>>
>>```
>>
>>判断回文串：
>>```java
>>int left=0,right=arr.length-1;
>>while(left < right && arr[left] == arr[right]){
>>	left++;
>>	right--;
>>}
>>return left >= right;
>>```
>>
>>字符串排列：可以通过计数数组判断某个字符串是否是另一个字符串的排列  
>>
>>子串的处理：快慢指针
>>
>## 查询
>### BFS广度优先
>> 常用于从某点出发到达目的地的最小步数，其广度优先遍历的层数即最小步数  
>> 1. 双指针模拟队列实现BFS  
>> ```java
>> int front=0,rear=0; // 首元素入队，否则rear=-1
>> ```
>> 2. 队列实现BFS  
>> ```java
>> Queue<Integer> queue = new LinkedList<>();
>> int level=0;
>> while(!queue.isEmpty()){
>> 	int curLevelNum = queue.size();
>> 	for(int i=0;i<n;i++){
>> 		idx = queue.poll();
>> 		queue.offer(idx+1);
>> 		queue.offer(idx-1);
>> 	}
>> 	level++;
>> }
>> ```
> 
>### DFS深度优先

# 数学
> ## 位运算
> 
> 	带余除法：任何数n可写成n=qb + r(b:k进制，r余数)
> 	辗转相除法：用于求最大公因数，不断进行带余除法的过程
> 
> 十进制数的k进制表示：
> ```java
> List<Integer> res = new ArrayList<>();
> while(n > 0){
> 	res.add(n % k);
> 	n = n/k;
> }
> reverse(res);// 参考十进制转二进制
> ```
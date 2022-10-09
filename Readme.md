目录  

[TOC]

# 常用思想
## 双指针
> 1. 两数之和：解决求和差积商的一类题，如和为特定值，和小于特定值的可能，积的最大值  
> 该类题在没有合适的数学公式前提下，穷举+剪枝是最好的办法，完成剪枝可通过控制变量法
> 
> * 重复元素：左右指针是否有重复元素 
> * 左右相同：当剩余元素[left+1,right-1]相同时，由于已排序，故左右指针会指向相同元素，可采用组合Cmn 思想确定二元组个数 
> * k数和：牵涉到和项的去重
> ```java
> if(k*arr[left] > target) continue;
> else if(arr[i] + (k-1)*arr[n-1] < target) continue;
> else if(i>0 && arr[i] == arr[i-1]) continue;
> else nextSum(arr,i,n-1,target-arr[i])
> ```
> * 和小于或等于特定值：当arr[left]+arr[right]==target时，左移right则和减小，即[left,right]均满足条件
> 
> 
> 2. 模拟栈：解决类似"移动零283"一类问题  
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
> 模板一：固定左端点,右端点左侧即为窗口，左端点移动时即移出窗口  
> **注：若arr[right] < k，会导致while未执行，即right < left,此时需要重置right**  
> ```java
> for(int i=0,n=arr.length;i<n;i++){
> 	while(right<n && i+arr[right] < k){
> 		right++;
> 	}
> 	ans += right-i;
> 	operate(left);//左移出窗口
> }
> ```
> 模板二：固定右端点，类似于**模拟队列**的思想，i控制队头，j控制队尾  
> 窗口长度即j-i+1,可通过某个变量记录窗口内的和、积、最大重复元素个数等判断是否出队  
> 注：一般遵循先入队，再确定出队条件，最后确定答案（最终答案的位置可能在出队条件中，也可能在出队条件后）  
> ```java
> // 如：求和大于等于k的最小子数组长度
> int i=0,ans=Integer.MAX_VALUE;
> for(int j=0,n=arr.length;j<n;j++){
> 	sum += arr[j]; // 入队
> 	while(sum >= k){
> 		if(j-i+1 < ans) ans = j-i+1; // 最终条件在出队条件中
> 		sum -= arr[i++];
> 	}
> 	// ans = Math.min(ans,j-i+1); // 求小于k的最小子数组长度，最终条件在出队条件后
> }
> ```
> 
> 4. 分三段思想：解决对部分数组进行操作的相关问题
> 常见的分为三段，num=[numA,numB,numC],只要理清numA,numC的关系以及numB需要满足的条件即可
> 
## 扫描线算法
> 用于应对区间相关相关的题目  
> 1. 差分数组求和：可统计区间内各个元素的查询次数,受给定区间的表示范围影响，其表示范围应在固定范围内 
> <span style="color: red">@Cenmon:给定区间的开闭决定差分的位置(端点位置or下一位置)</span>：若右端点为开区间，则差分位置即端点下标，若右端点为闭区间，则差分位置为端点下标的下一位置，参考leetcode 2251
> ```java
> int[] diff = new int[n+1];
> for(int[] interval : intervals){ //区间表示范围为(0~n-1)
> 	diff[ interval[0] ]  += 1; // 开始事件
> 	diff[ interval[1]+1 ] -= 1; // 结束事件:闭区间表示
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
## 二分
> 解空间：题目所求答案的区间，一般用left,right指针指向
> 最左二分：最左二分找到第一个满足条件的解，关键在于满足条件时收缩右边界
> ```java
> int left=0,right=nums.length-1;
> while(left <= right){
> 	int mid = left + (right-left)/2;
> 	if(nums[mid] == target){ // 可以和下一个合并，此处凸显满足条件时收缩右边界
> 		right = mid - 1;
> 	}else if(nums[mid] > target){
> 		right = mid -1;
> 	}else{
> 		left  = mid + 1;
> 	}
> }
> ```
> 
> 最右二分：最右二分找到最后一个满足条件的解，关键在于满足条件时收缩左边界
> ```java
> int left=0,right=nums.length-1;
> while(left <= right){
> 	int mid = left + (right-left)/2;
> 	if(nums[mid] == target){ // 可以和下面条件合并，此处凸显满足条件时收缩左边界
> 		left = mid + 1;
> 	}else if(nums[mid] > target){
> 		right = mid -1;
> 	}else{
> 		left  = mid + 1;
> 	}
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
>>int i=0,j=0;
>>// 判断s是否是t的子序列
>>while(j<t.length()){
>>	if(s.charAt(i) == t.charAt(j)){
>>		i++;
>>	}
>>	j++;
>>}
>>return i>=s.length();
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
>> 2. 队列实现BFS：层序遍历  
>> ```java
>> Queue<Integer> queue = new LinkedList<>();
>> int level=0;
>> queue.offer(0);
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
> 	res.add(n % k); // 获取每次除k的余数
> 	n /= k;
> }
> reverse(res);// 参考十进制转二进制
> ```
> 
> ## 素数
> 素数只能被1和本身整除，反之为合数，即质数没有因子，合数有质因子和非质因子  
> 1. 判断素数
> ```java
> n = (int) Math.sqrt(n);
> for(int i=2;i<n;i++){
>     if(n % i == 0) return false;
> }
> return true;
> ```
> 2. 求素数:埃氏筛法，欧拉筛法
> ```java
> 	// 求小于n的所有素数:欧拉筛法，是埃氏筛选法的扩展
>   public int countPrimes(int n) {
>       int[] prime = new int[n];
>       int count = 0;
>       boolean[] isHeShu = new boolean[n]; // 是否是合数，默认false，即质数
>       for(int i=2;i<n;i++){
>           if(!isHeShu[i]) prime[count++] = i; // i是素数时，入栈
>           for(int j=0;i*prime[j]<n;j++){// 筛掉质因子的所有倍数，且只筛一次(最小质因子)
>               isHeShu[ i*prime[j] ] = true;
>               if( i%prime[j] == 0 ) break; //等于0则prime[j]是i的最小因子，同时更是i*prime[j]的最小因子，只需筛一次，故结束循环
>           }
>       }
>       return count;
>   }
> ```
> 3. 求质因子
> ```java
> 
> ```
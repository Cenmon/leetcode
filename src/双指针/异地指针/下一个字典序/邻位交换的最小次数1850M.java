package 双指针.异地指针.下一个字典序;

public class 邻位交换的最小次数1850M {

    // @Cenmo:移位问题：邻位移位
    public int getMinSwaps(String num, int k) {
        char[] olds = num.toCharArray();
        char[] news = num.toCharArray();
        int n = olds.length,ans = 0;
        for(int i=0;i<k;i++)
            nextPermuation(news,n);

        // 冒泡确定交换次数
        for(int i=0;i<n;i++){ // 新串
            int count=0;
            /**
             * 新串中前面的字符完成左冒泡后，当前字符在老串中的对应字符必在当前位置或之后
             * new[0]字符对应old[0]或old[i],当old[i]完成左冒泡，
             * 则new[1]字符对应除“#”之外的1位置或之后，故可通过count计数得到交换次数
             */
            for(int j=0;j<n;j++){ // 老串
                if(news[i] == olds[j]){
                    olds[j] = '#';
                    break;
                }
                if(olds[j] == '#') continue;
                count++;
            }
            ans += count;
        }

        return ans;
    }

    private void nextPermuation(char[] cs,int n){
        int left=n-2,right=n-1;
        while(left>=0 && cs[left] >= cs[left+1]) left--;

        if(left == -1) return;

        while(left<right && cs[left] >= cs[right]) right--;

        swap(cs,left,right);
        reverse(cs,left+1,n-1);
    }

    private void reverse(char[] cs,int left,int right){
        while(left < right){
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            left++;right--;
        }
    }

    private void swap(char[] cs,int left,int right){
        char tmp = cs[left];
        cs[left] = cs[right];
        cs[right] = tmp;
    }


    public static void main(String[] args) {
        邻位交换的最小次数1850M main = new 邻位交换的最小次数1850M();

        /**
         * 给定由数组构成的字符串num和k值，计算num字典序第k次字典序比num大值串new
         * 求字符串num通过相邻交换变成new的最小交换次数
         */

        System.out.println(main.getMinSwaps("5489355142",4)); // 2
        /**
         * 对于5489355142，字典序比其大的下一个串依次为5489355214，5489355241，5489355412，5489355421
         */
        System.out.println(main.getMinSwaps("11112",4)); // 4
        System.out.println(main.getMinSwaps("00123",1)); // 1
    }
}

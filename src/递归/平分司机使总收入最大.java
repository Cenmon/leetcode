package 递归;

/**
 * @author Cenmo
 * @Date 2022-03-27 2022-03-27
 */
public class 平分司机使总收入最大 {

    public int maxIncome(int[][] incomes){
        int n = incomes.length; // 总人数
        int goA = n/2; // 要去A场的人数
        return process(incomes,n,0,goA); // n:总人数，0:已经分配的人数，goA
    }

    // 用goA表示去A还是去B，去A则goA-1，去B则goA不变
    private int process(int[][] incomes, int n, int i, int goA) { // 深搜遍历过程！！
        if(i == n) return 0;

        if(goA == 0){ // 要去A场的人满了，全去B场
            return incomes[i][1] + process(incomes,n,i+1,goA);
        }
        // n-i剩余未分配的人数
        if(n - i == goA){  // 情况1：已经分配了5人，全去了B场，此时A场名额为5，故全去A场
            return incomes[i][0] + process(incomes,n,i+1,goA-1); // A场去一人，则goA-1
        }

        int p1 = incomes[i][0] + process(incomes,n,i+1,goA-1); // 去A场，去一人，则goA-1
        int p2 = incomes[i][1] + process(incomes,n,i+1,goA); // 去B场
        return Math.max(p1,p2);
    }

    /**
     * 给出每个司机去A,B两场的收入，求平分司机，使得所有司机的总收入最大,求最大收入
     */
    public static void main(String[] args) {
        平分司机使总收入最大 main = new 平分司机使总收入最大();

        int[][] incomes = new int[][] {{9,13},{26,14}};

        System.out.println(main.maxIncome(incomes));
    }
}

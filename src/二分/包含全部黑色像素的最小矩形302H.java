package 二分;

/**
 * @Author Cenmo
 * @Date 2022-10-11 21:14
 * @Description
 */
public class 包含全部黑色像素的最小矩形302H {
    // o(n2)
    public int minArea2(char[][] image, int x, int y) {
        // write your code here
        int minx=x,miny=y,maxx=x,maxy=y;
        for(int i=0,m=image.length;i<m;i++){
            for(int j=0,n=image[0].length;j<n;j++){
                if(image[i][j] == '1'){
                    if(i<minx) minx = i;
                    else if(i>maxx) maxx = i;

                    if(j<miny) miny = j;
                    else if(j>maxy) maxy = j;
                }
            }
        }
        return (maxx-minx+1)*(maxy-miny+1);
    }

    public int minArea(char[][] image, int x, int y) {
        int row=image.length,col=image[0].length;
        int upper = upper(image,0,x,0,col-1);
        int left = left(image,0,row-1,0,y);
        int down = down(image,x,row-1,0,col-1);
        int right = right(image,0,row-1,y,col-1);
//        System.out.println("upper = " + upper);
//        System.out.println("left = " + left);
//        System.out.println("down = " + down);
//        System.out.println("right = " + right);
        return (down-upper+1)*(right-left+1);
    }

    private int upper(char[][] image, int minRow, int maxRow, int minCol, int maxCol) {
        int left=minRow,right=maxRow;
        // 上半部分和左半部分做最左二分
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 检测mid行是否含1
            boolean hasBlack = false;
            for(int j=minCol;j<=maxCol;j++)
                if(image[mid][j] == '1')
                    hasBlack=true;

            if(hasBlack){ //上半部分和左半部分的右边界行必定含1，故当mid行含1时，可舍弃右半边
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left; // 首个出现1的行
    }

    private int down(char[][] image, int minRow, int maxRow, int minCol, int maxCol) {
        int left=minRow,right=maxRow;
        // 下半部分和右半部分做最右二分
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 检测mid行是否含1
            boolean hasBlack = false;
            for(int j=minCol;j<=maxCol;j++)
                if(image[mid][j] == '1')
                    hasBlack=true;

            if(hasBlack){ //下半部分和右半部分的左边界行必定含1，故当mid行含1时，可舍弃左半边
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right; // 最后一个出现1的行
    }

    private int left(char[][] image, int minRow, int maxRow, int minCol, int maxCol) {
        int left=minCol,right=maxCol;
        // 上半部分和左半部分做最左二分
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 检测mid列是否含1
            boolean hasBlack = false;
            for(int i=minRow;i<=maxRow;i++)
                if(image[i][mid] == '1')
                    hasBlack=true;

            if(hasBlack){ //上半部分和左半部分的右边界行必定含1，故当mid行含1时，可舍弃右半边
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left; // 首个出现1的行
    }

    private int right(char[][] image, int minRow, int maxRow, int minCol, int maxCol) {
        int left=minCol,right=maxCol;
        // 下半部分和右半部分做最右二分
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 检测mid列是否含1
            boolean hasBlack = false;
            for(int i=minRow;i<=maxRow;i++)
                if(image[i][mid] == '1')
                    hasBlack=true;

            if(hasBlack){ //下半部分和右半部分的左边界行必定含1，故当mid行含1时，可舍弃左半边
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right; // 最后一个出现1的行
    }

    public static void main(String[] args) {
        包含全部黑色像素的最小矩形302H main = new 包含全部黑色像素的最小矩形302H();
        System.out.println(main.minArea(
                new char[][]{{'0','0','1','0'},
                            {'0','1','1','0'},
                            {'0','1','0','1'}},0,2)); // 6
//        System.out.println(main.minArea(
//                new char[][]{{'1','1','1','0'},
//                        {'1','1','0','0'},
//                        {'0','0','0','0'},
//                        {'0','0','0','0'}},0,1)); // 6
    }
}

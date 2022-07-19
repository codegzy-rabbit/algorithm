package class12;

/**
 * 一个数组有RG两种颜色，左边都为R，右边都为G，求所需染色个数
 */

public class RGProblem {

    /**
     * @param array 染色数组
     * @param index 从哪个位置开始染色
     * @return
     */
    public static int Block(char[] array, int index) {
        int number = 0;
        int[] rightR = new int[array.length];   //从右向左数R个数
        int[] leftG = new int[array.length];    //从左向右数G的个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 'G') {
                leftG[i] = number;
            } else {
                leftG[i] = ++number;
            }
        }
        number = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != 'R') {
                rightR[i] = number;
            } else {
                rightR[i] = ++number;
            }
        }
        return rightR[index];
    }


    public static void main(String[] args) {
        char[] chars = new char[]{'R', 'G', 'R', 'G', 'R'};
        System.out.println(Block(chars, 2));

    }

}

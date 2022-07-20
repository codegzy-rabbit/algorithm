package array;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/7/19 23:14
 */

/**
 * give any num , to reverse it, if it is a negative number, keep the minus sign
 * if it overflows Integer scope , it should be zero
 */
public class ReverseNumber {

    /**
     * violent solution
     * Time complexity: O(n)
     * Space complexity: O(n)
     * convert this number to string, then to char array, reverse it,  pay attention to detail
     */
    public static int solutionOne(int x) {
        //eliminate some of the answers that are already clear
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x == 0){
            return 0;
        }
        // get the sign
        int sign = x > 0 ? 1 : -1;
        // avoid the sign to interference calculation
        int operateNumber = Math.abs(x);
        //convert x to string and reverse it
        String s = new StringBuilder(String.valueOf(operateNumber)).reverse().toString();
        // convert s to long type, to prevent it overflow the limit of int type
        long value = Long.parseLong(s);
        // if it overflows, return zero, otherwise return the value convert to int;
        return ((value > Integer.MAX_VALUE) ? 0 : (int) value) * sign;
    }


    /**
     * swap element in a array to lower the space overhead
     *
     * @param x receive a number to reverse
     * @return answer
     */
    public static int solutionTwo(int x) {
        //eliminate some of the answers that are already clear
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x == 0){
            return 0;
        }
        // get the sign
        int sign = x > 0 ? 1 : -1;
        // avoid the sign to interference calculation
        int operateNumber = Math.abs(x);
        //convert x to char array
        char[] chars = String.valueOf(operateNumber).toCharArray();
        //swap the start position num and end position num
        for (int start = 0, end = chars.length - 1; start < end; start++, end--) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
        }
        //convert chars array to string
        String s = String.valueOf(chars);
        // convert s to long type, to prevent it overflow the limit of int type
        long value = Long.parseLong(s);
        // if it overflows, return zero, otherwise return the value convert to int;
        return ((value > Integer.MAX_VALUE) ? 0 : (int) value) * sign;
    }

    /**
     *
     * By mathematical method to solve the problem
     *
     * @param x receive a number to reverse
     * @return answer
     */
    public static int solutionThree(int x) {
        //eliminate some of the answers that are already clear
        if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE || x == 0){
            return 0;
        }
        // get the sign
        int sign = x > 0 ? 1 : -1;
        // avoid the sign to interference calculation
        int operateNumber = Math.abs(x);
        // define the result
        long result = 0;
        // declare the unit digit
        int last;
        while ((last = operateNumber % 10) != operateNumber) {
            result = result * 10 + last;
            operateNumber /= 10;
        }
        // the highest digit num will not operate, so do it
        if (operateNumber != 0) {
            last = operateNumber;
            result = result * 10 + last;
        }
        // if it overflows, return zero, otherwise return the value convert to int;
        return ((result > Integer.MAX_VALUE) ? 0 : (int) result) * sign;
    }

    public static void main(String[] args) {
        System.out.println(solutionThree(-1200));
    }
}

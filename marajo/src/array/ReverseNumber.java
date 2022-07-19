package array;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/7/19 23:14
 */

/**
 * give any num , to reverse it, if it is a negative number, keep the minus sign
 * if it overflows Integer_MAX_VALUE , it should be zero
 */
public class ReverseNumber {

    //violent solution
    /**
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

    public static void main(String[] args) {
        System.out.println(solutionOne(120));
    }
}

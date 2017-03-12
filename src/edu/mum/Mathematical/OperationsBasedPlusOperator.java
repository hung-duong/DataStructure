package edu.mum.Mathematical;

/**
 * Created by hungduong on 3/12/17.
 * Question:
 * Write a method to implement *, - , / operations. You should use only the + operator.
 */
public class OperationsBasedPlusOperator {
    //Subtraction: we know that a - b ~ a + (-1)*b
    //Flip a positive sign to negative, or a negative sign to pos
    public static int negate(int a) {
        int neg = 0;
        int d = a < 0 ? 1 : -1;
        while(a != 0) {
            neg += d;
            a += d;
        }

        return neg;
    }

    public static int minus(int a, int b) {
        return a + negate(b);
    }

    public static boolean differentSigns(int a, int b) {
        return ((a < 0 && b > 0) || (a > 0 && b < 0)) ? true : false;
    }

    public static int abs(int a) {
        if (a < 0) return negate(a);
        return a;
    }

    //Multiply a by b by adding a to itself b times
    public static int times(int a, int b) {
        if(a < b) return times(b, a);
        int sum = 0;
        for(int i = abs(b); i > 0; i--)
            sum += a;

        if(b < 0) sum = negate(sum);
        return sum;
    }

    /*Divide a by b by literally counting how many times does b go into a.
     *That is, count how many times you can subtract b from a until you hit 0
     */
    public static int divide(int a, int b) throws ArithmeticException{
        if(b == 0)
            throw new ArithmeticException("Divide by 0.");

        int quotient = 0;
        int divisor = negate(abs(b));

        for(int divend = abs(a); divend >= abs(divisor); divend += divisor) {
            ++quotient;
        }

        if(differentSigns(a, b))
            quotient = negate(quotient);

        return quotient;
    }
}

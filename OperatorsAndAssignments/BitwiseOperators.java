package OperatorsAndAssignments;

public class BitwiseOperators {
    public static void main(String[] args) {

        //integral-bitwise operator (Applicable for both boolean and integral type)
        //internal AND, OR, X-OR operations takes place on their binary values
        System.out.println(4 & 5); 
        System.out.println(4 | 5);
        System.out.println(4 ^ 5);
        System.out.println(true & false);
        System.out.println(false & false);
        System.out.println(true | false);


        //Bitwise complement operator (Applicable only for integral type)
        System.out.println(~4);   //-5

        
        //Boolean compliment operator (Applicable only for boolean type)
        System.out.println(!true);
        System.out.println(!false);
    }
}

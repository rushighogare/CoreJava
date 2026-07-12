package OperatorsAndAssignments;

public class AssignmentOperators {
    public static void main(String[] args) {
        //1. Simple assignment 
        int x=10;

        //2. Chained assignment
        int a, b, c, d;
        a=b=c=d=3;

        //int a=b=c=0; --> this is not correct


        //3. Compound assignment 
        int z=10;
        z+=10;
        System.out.println(z);




        //Conditional operator - new type of operator
        int m=(10<20) ? 30:40;
        System.out.println(m);

        System.out.println((true)?1:0);


        //there is no precedence for operands
        //operator precedence - (if same precedence then it will be evaluated from Left to Right)
        System.out.println(1+2*3/2+5*6);
    }   
}

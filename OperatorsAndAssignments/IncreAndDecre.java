package OperatorsAndAssignments;

public class IncreAndDecre {
    public static void main(String[] args){
        int a=10;


        //pre-increment
        ++a;
        System.out.println("pre-increment: " + a);

        //post-increment
        a++;
        System.out.println("post-increment: " + a);

        //pre-decrement
        --a;
        System.out.println("pre-decrement: " + a);

        //post-decrement
        a--;
        System.out.println("post-decrement: " + a);


        //Explicit type casting - 
        byte b=10;
        byte c=20;
        // byte d=c+b;  //this will give error because c+b is int and cannot be assigned to byte
        //how above operation is done?
        //byte d=max(int, type of c, type of b)  ==> The max datatype will be resultant of given operation
        //for now max is int so it can't be assigned to byte
        //to resolve this, we have to use explicit type casting - 
        byte d=(byte)(c+b);
        System.out.println("Explicit type casting: " + d);

        
        //implicit type casting - 
        byte e=2;
        e++;   //for increment and decrement operations, implicit type castin is done
        // e=e+1;   //it will give error as we have explicitly type cast it
        System.out.println("Implicit type casting: " + e);
    }
}

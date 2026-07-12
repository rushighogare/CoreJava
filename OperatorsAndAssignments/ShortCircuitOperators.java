package OperatorsAndAssignments;

public class ShortCircuitOperators {
    //short-circuit operators (&&, ||) - Applicable for both boolean and integral type
    public static void main(String[] args) {
        int x=10;
        int y=15;

        //bitwise operator will execute both conditions regardless of requirement, thus performance is low
        if(++x<10 & ++y>15){  
            x++;
        }
        else{
            y++;
        }

        System.out.println(x+"...."+y);
        //short-circuit && or || operator executes conditions as per its requirements so performance is high
        //for true cases (&&) - suppose first is true then only it will check if second is also true
        //for false cases (&&) - suppose first is false then no need to check further as the o/p will be false only
        //same for || operator, it checks conditions as per its requirements so performance is optimised

        x=10;
        y=15;
        if(++x<10 && ++y>15){   //2nd condition will not be evaluated as first condition is false
            x++;
        }
        else{
            y++;
        }

        System.out.println(x+"...."+y);
    }
}

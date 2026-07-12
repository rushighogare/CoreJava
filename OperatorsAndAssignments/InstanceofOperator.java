package OperatorsAndAssignments;

public class InstanceofOperator {
    int roll;

    InstanceofOperator(){
        this.roll=0;
    }

    public static void main(String[] args){
        InstanceofOperator i=new InstanceofOperator();
        Thread t=new Thread();

        if(i instanceof InstanceofOperator) System.out.println(true);
        else System.out.println(false);
        
        if(t instanceof Thread) System.out.println(true);
        else System.out.println(false);


        //below case will always false because null cannot be instance of any class
        if(null instanceof Thread) System.out.println(true);
        else System.out.println(false);
    }
}

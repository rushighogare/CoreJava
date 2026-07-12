package OperatorsAndAssignments;

public class EqualityOperators {
    String name;

    EqualityOperators(){
        name="";
    }

    EqualityOperators(String name){
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        EqualityOperators other = (EqualityOperators) obj;
        return this.name.equals(other.name);
    }

    public static void main(String[] args){
        int a=10;
        int b=20;
        System.out.println(a!=b);

        //we can apply for object type also
        EqualityOperators e1=new EqualityOperators();
        EqualityOperators e2=new EqualityOperators();
        e1=e2;  //now e1 is referring to e2
        if(e1==e2){  //== checks if memory address is same or not
            System.out.println("Objects are equal e1 & e2");
        }
        else{
            System.out.println("Objects are not equal e1 & e2");
        }

        EqualityOperators e3=new EqualityOperators("Rushi");
        EqualityOperators e4=new EqualityOperators("Rushi");
        // e3=e4;
        //we have to override .equals() method to check content in objects otherwise it will behave same as ==
        if(e3.equals(e4)) System.out.println("Content is same e3 & e4");
        else System.out.println("Content is different e3 & e4");
        if(e3==e4){
            System.out.println("Objects are equal e3 & e4");
        }
        else{
            System.out.println("Objects are not equal e3 & e4");
        }
    }
}

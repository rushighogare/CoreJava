package OperatorsAndAssignments;

public class newVsnewInstance {

    newVsnewInstance(){

    }

    newVsnewInstance(int a){

    }

    public static void main(String[] args) throws ClassNotFoundException,
                   NoSuchMethodException,
                   InstantiationException,
                   IllegalAccessException,
                   java.lang.reflect.InvocationTargetException{
        //new - It is keyword used to create object of know class
        //we can pass value as parameter to initialize object  
        newVsnewInstance n1=new newVsnewInstance(1);
        
        
        //newInstance() - It is method to create object of unknown class at runtime
        //To use newInstance(), class should contain no-arg type constructor because newInstance() does not let us pass the value to initializa object
        Object o=Class.forName("OperatorsAndAssignments.EqualityOperrs")  //this class is not declared so it will throw exception as classnotfound
                                    .getDeclaredConstructor()
                                    .newInstance();

        System.out.println(o);

        Thread t=new Thread();
        System.out.println(t);
    }
}

package OperatorsAndAssignments;

public class InstanceofVsIsInstance {
    public static void main(String[] args) throws ClassNotFoundException,
                   NoSuchMethodException,
                   InstantiationException,
                   IllegalAccessException,
                   java.lang.reflect.InvocationTargetException{

        //instanceof is used to check if object is instance of given class or not. However that class is hardcoded
        //objects created by new keyword can be checked
        InstanceofVsIsInstance i=new InstanceofVsIsInstance();
        if(i instanceof InstanceofVsIsInstance) System.out.println(true);


        //isInstance() method is used to check if object is instance of given class or not. However that class is defined at runtime
        Object o=Class.forName("OperatorsAndAssignments.EqualityOperators")  //this class is not declared so it will throw exception as classnotfound
                                    .getDeclaredConstructor()
                                    .newInstance();
        System.out.println(Class.forName("OperatorsAndAssignments.EqualityOperators").isInstance(o));
    }
}

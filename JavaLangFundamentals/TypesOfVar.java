package JavaLangFundamentals;

public class TypesOfVar {
    //Division 1 - declared to represent type of value
    //1. Primitive type - used to represent primitive values (int, float, double, char, boolean, byte, short, long)
    int a=3;
    byte b=4;
    double d=9.0;

    //2. Reference type - used to refer ab object
    //Student s=new Student();


    //Division 2 - declared on the basis of position of declaration and behaviour 
    //1. Instance variable - declared outside method, constructor or block and insider class
    //separate copy for every object of that particular class
    //these are object-level variables or attributes
    int x=10;  //--> instance-primitive

    //2. Static variable - declared with static keyword outside method, constructor or block and inside class
    //shared memory among all objects of that particular class
    //these are class level variables or fields
    static int y=20; 
    static String s=new String("asgd");  //static-reference

    public static void main(String[] args) {
        //instance variable can be accessed only through object reference
        TypesOfVar obj2=new TypesOfVar();
        System.out.println(obj2.x);

        //static variable can be accessed directly inside static area
        System.out.println(y);
        System.out.println(TypesOfVar.y);
        System.out.println(obj2.y); 


        //3. Local variable - declared insider method, constructor or block
        int z=3;
        System.out.println(z);
    }
}

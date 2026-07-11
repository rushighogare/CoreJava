package JavaLangFundamentals;

public class MainMethod {
    //valid syntax for main method
    public static void main(String[] args){
        System.out.println("called main method from parent class");
    }

    static public void main(int[] args){
        
    }

    static final synchronized public void main(boolean[] args){

    }


    //main method allows overloading and inheritance
    //overloading
    public static void main(char[] args){}
    public static void main(double[] args){}


    //inheritance
    //run mainmethodchild class file and it will call main method of parent class as child class does not have it

    //method hiding - if child class has main method, then it will hide the main method of parent class upon running it
    //overriding is not applicable for main method so we call it as method hiding
    //run mainmethodchild class file to see results
}

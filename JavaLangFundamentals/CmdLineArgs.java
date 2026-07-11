package JavaLangFundamentals;

public class CmdLineArgs {
    //we can pass arguments from command prompts at runtime and make main method to change its behaviour
    public static void main(String[] args){
        for(int i=0; i<args.length; i++){
            int num=Integer.parseInt(args[i]);
            System.out.println("Square of "+num+" is "+(num*num));
        }
    }
}

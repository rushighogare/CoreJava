package JavaLangFundamentals;

public class VarArgMethod {
    public static void main(String[] args){
        //var-arg method - method which can take variable number of arguments

        sum(1, 2, 3);
        sum(1, 2, 3, 4, 5);
        sum2(1, new int[]{2,3,4});   //we can pass array as well
        sum();   //we can also call var-arg method without passing any argument
        sum3(1, 2, new int[][]{{1,2}, {3,4,5}});
    }

    //var-arg method (No need to write multiple methods according to number of arguments)
    //valid declarations are - 
    //sum(int... arr)
    //sum(int ...arr)
    //sum(int...arrr)
    public static void sum(int... arr){
        //int... arr - internally, all variable arguments are stored in an array and passed array as argument 
        
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        System.out.println(sum);
    }

    public static void sum2(int a, int... arr){
        int sum=a;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }

        System.out.println(sum);
    }

    public static void sum3(int a, int b, int[]... arr){
        int sum=a+b;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                sum+=arr[i][j];
            }
        }

        System.out.println(sum);
    }
}

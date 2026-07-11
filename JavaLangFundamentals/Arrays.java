package JavaLangFundamentals;

public class Arrays {
    
    //variation of declaration for 1-D array
    int[] x=new int[3];
    int y[]=new int[3];
    int []z=new int[3];

    
    //variation of declaration for 2-D array
    int[][] a=new int[3][3];
    int b[][]=new int[3][3];
    int []c[]=new int[3][3];
    int d[][]=new int[3][3];
    int[] e[]=new int[3][3];
    int[] []f=new int[3][3]; 

    int[] x1, y1=new int[4];
    int[][] x2[], y2=new int[4][];  //x2 - 3d array, y2 - 2d array
    


    //variation of declaration for 3-D array
    int[][][] a1=new int[3][3][3];
    int b1[][][]=new int[3][3][3];
    int []c1[][]=new int[0][][];
    //and so on

    public static void main(String[] args) {
        Arrays arr=new Arrays();
        System.out.println(arr.c1);        
        System.out.println(arr.c1.length);   
        
        //anonymous array - an array without a name, used for instant usage
        //below passed array is without name and it is being used for only one time 
        sum(new int[]{1, 2, 3});  


        //object-type arrays
        Object[] obj=new Object[4];
        obj[0]=new Object();
        obj[1]=new String("Hello");
    }

    public static void sum(int[] arr){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}

package JavaLangFundamentals;

//literals are the values we assign to variables.
public class Literals {
    public static void main(String[] args){
        int a=3; //3 is literal

        //boolean literal
        boolean bool=true;  //true is literal
        System.out.println(bool);

        //integral literal
        int x=10;  //decimal form  (allowed digits 0-9)
        int b=010;  //octal form --> it's value is 8 (allowed digits 0-7)
        int c=0x10;  //hexadecimal form --> its value is 16 (allowed digits 0-9, A-F)
        System.out.println(b);
        System.out.println(c);
        
        //long literal
        long l=10l;  //by adding l as suffix, it is converted to long literal
        System.out.println(l);

        //floating-point literal
        float f=10.5f;  //by default it is double but by adding f as suffix, it is converted to float literal
        System.out.println(f);
        double d=10.5;  //by default it is double
        System.out.println(d);

        //character literal
        char ch='a';
        char ch1='\u0061';  //unicode representation of 'a'
        System.out.println(ch);
        System.out.println(ch1);

        //Binary literal (starts with 0b or 0B and contains only 0s and 1s)
        int z=0b1111;
        System.out.println(z);

        double y=1_23_4_5_6;
        System.out.println(y);  //it will print 123456.0, underscores are ignored in numeric literals for readability
    }
}

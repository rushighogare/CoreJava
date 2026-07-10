package JavaLangFundamentals;

public class Datatypes {
    public static void main(String[] args){
        byte b=-128;   //-128 to 127
        short s=3276;  //-32768 to 32767 (outdated datatype)
        int i=3;  //-2147483648 to 2147483647
        long l=1234567890;  //-9223372036854775808 to 9223372036854775807
        float f=3.14f;  //-3.4E38 to 3.4E38
        double d=3.14;  //-1.7E308 to 1.7E308
        char c='A';  //0 to 65535  --> Unicode values (unique code for every character even for emojis)
        boolean bool=true;  //no range applicable, only values can be given (true or false)

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
        System.out.println(c);      
        System.out.println(false);
        System.out.println(bool);
    }
}

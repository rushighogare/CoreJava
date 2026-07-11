package JavaLangFundamentals;


//Listeners - Listeners listens events and perform appropriate actions whenever that event occurs
//starts from line no - 50


//Java Bean - it is class which has private data members and public getter and setter methods
public class BeansAndListeners {
    private int rollNumber;
    private String name;

    BeansAndListeners(){

    }

    BeansAndListeners(int rollNumber, String name){
        this.rollNumber=rollNumber;
        this.name=name;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public void setRollNumber(int roll){
        rollNumber=roll;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public static void main(String[] args){
        BeansAndListeners student = new BeansAndListeners(1, "Alice");
        System.out.println("Roll Number: " + student.getRollNumber());
        System.out.println("Name: " + student.getName());

        student.setRollNumber(3);
        student.setName("Bob");
        System.out.println("Roll Number: "+student.getRollNumber());
        System.out.println("Name: "+student.getName());
    }


    //Listeners - method names starts with add/remove only
    // public void addMyActionListener(MyActionListener listener) {
    //     // Code to add the listener to a list of listeners
    // }

    // public void removeMyActionListener(MyActionListener listener) {
    //     // Code to remove the listener from the list of listeners
    // }
}

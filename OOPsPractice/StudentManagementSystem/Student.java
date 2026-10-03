package StudentManagementSystem;

public class Student {
    private int id;
    private String name;
    private int age;
    private int marks;
    private Course course;

    Student(){
        this.id=0;
        this.name="";
        this.age=0;
        this.marks=0;
        this.course=null;
    }

    Student(int id, String name, int age, int marks, Course course){
        this.id=id;
        this.name=name;
        this.age=age;
        this.marks=marks;
        this.course=course;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(int marks){
        this.marks=marks;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course=course;
    }
}

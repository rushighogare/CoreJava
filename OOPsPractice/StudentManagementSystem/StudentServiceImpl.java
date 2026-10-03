package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private ArrayList<Student> students;
    
    public StudentServiceImpl(){
        students=new ArrayList<>();
    }

    public Student getStudentById(int id){
        for(Student s:students){
            if(s.getId()==id){
                return s;
            }
        }

        return null;
    }

    public void addStudent(int id, String name, int age, int marks, Course course){
        Student s=new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setMarks(marks);
        s.setCourse(course);
        students.add(s);

        System.out.println("Student added successfully!");
    }

    public void addStudent(Student s){
        students.add(s);
        System.out.println("Student added successfully!");
    }

    public void displayStudentById(int id){
        for(Student s:students){
            if(s.getId()==id){
                System.out.println("Student: ID="+s.getId()+", Name="+s.getName()+", Age="+s.getAge()+", Marks="+s.getMarks()+ ", Course="+s.getCourse().getCourseName());
                return;
            }
        }

        System.out.println("Student not found with ID: " + id);
    }

    public void displayAllStudents(){
        for(Student s:students){
            System.out.println("Student: ID="+s.getId()+", Name="+s.getName()+", Age="+s.getAge()+", Marks="+s.getMarks()+ ", Course="+s.getCourse().getCourseName());
        }
    }

    public void updateStudent(int id, String name, int age, int marks){
        for(Student s:students){
            if(s.getId()==id){
                s.setName(name);
                s.setAge(age);
                s.setMarks(marks);
                return ;
            }
        }

        System.out.println("Student not found with ID: " + id);
    }

    public void deleteStudent(int id){

        //below implementation may throw concurrent modification exception
        // for(Student s:students){
        //     if(s.getId()==id){
        //         students.remove(s);
        //         return ;
        //     }
        // }

        //use iterator
        Iterator<Student> it=students.iterator();
        while(it.hasNext()){
            Student s=it.next();
            if(s.getId()==id){
                it.remove();
                return ;
            }
        }

        System.out.println("Student not found with ID: " + id);
    }

    public boolean isPassed(int id) {
        Student s=getStudentById(id);
        if(s==null){
            System.out.println("Student not found with ID: " + id);
            return false;
        }
        
        int marks=s.getMarks();
        if(marks>=35) return true;

        return false;
    }

    public List<Student> getStudentsByCourse(String courseName) {
        List<Student> studentsByCourse = new ArrayList<>();
        for (Student s : students) {
            if (s.getCourse() != null && s.getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                studentsByCourse.add(s);
            }
        }
        return studentsByCourse;
    }

    public char calculateGrade(int id) {
        Student s=getStudentById(id);
        int marks=0;

        if(s!=null) marks=s.getMarks();

        if(marks>=90) return 'A';
        else if(marks>=80) return 'B';
        else if(marks>=70) return 'C';
        else if(marks>=60) return 'D';
        else if(marks>=50) return 'E';
        else return 'F';
    }

    public static void main(String[] args){
        StudentServiceImpl ss=new StudentServiceImpl();

        Student s2=new Student(1, "Rushi", 23, 100, new Course(1, "Java", 6, 10000));
        ss.addStudent(s2);

        ss.addStudent(2, "alice",22, 20, new Course(2, "Python", 4, 8000));
        ss.displayStudentById(2);

        ss.updateStudent(2, "alice", 45, 80);
        ss.displayStudentById(2);

        ss.addStudent(3, "bob", 25, 90, new Course(3, "C++", 5, 9000));
        ss.displayStudentById(3);

        ss.displayAllStudents();
        ss.deleteStudent(2);
        ss.displayAllStudents();

        ss.calculateGrade(3);
        System.out.println("Grade of student with id 3: "+ss.calculateGrade(3));

        System.out.println("Student with id 3 passed? "+ss.isPassed(90));
    }
}

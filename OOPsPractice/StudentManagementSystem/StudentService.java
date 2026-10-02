package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentService {
    private ArrayList<Student> students;
    
    StudentService(){
        students=new ArrayList<>();
    }

    public void addStudent(int id, String name, int age, int grade){
        Student s=new Student();
        s.setId(id);
        s.setName(name);
        s.setAge(age);
        s.setGrade(grade);
        students.add(s);

        System.out.println("Student added successfully!");
    }

    public void displayStudentById(int id){
        for(Student s:students){
            if(s.getId()==id){
                System.out.println("Student: ID="+s.getId()+", Name="+s.getName()+", Age="+s.getAge()+", Grade="+s.getGrade());
                return;
            }
        }

        System.out.println("Student not found with ID: " + id);
    }

    public void displayAllStudents(){
        for(Student s:students){
            System.out.println("Student: ID="+s.getId()+", Name="+s.getName()+", Age="+s.getAge()+", Grade="+s.getGrade());
        }
    }

    public void updateStudent(int id, String name, int age, int grade){
        for(Student s:students){
            if(s.getId()==id){
                s.setName(name);
                s.setAge(age);
                s.setGrade(grade);
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
                students.remove(s);
                return ;
            }
        }

        System.out.println("Student not found with ID: " + id);
    }

    public static void main(String[] args){
        StudentService ss=new StudentService();

        Student s1=new Student();
        ss.displayStudentById(0);

        Student s2=new Student(1, "Rushi", 23, 1);
        ss.displayStudentById(1);

        ss.addStudent(2, "alice",22, 2);
        ss.displayStudentById(2);

        ss.updateStudent(2, "alice", 45, 0);
        ss.displayStudentById(2);

        ss.addStudent(3, "bob", 25, 3);
        ss.displayStudentById(3);

        ss.displayAllStudents();
        ss.deleteStudent(2);
        ss.displayAllStudents();
    }
}

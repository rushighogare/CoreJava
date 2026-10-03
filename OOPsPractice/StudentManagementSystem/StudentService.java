package StudentManagementSystem;
public interface StudentService {
    public void addStudent(int id, String name, int age, int grade, Course course);

    public void addStudent(Student s);

    public void updateStudent(int id, String name, int age, int grade);

    public void deleteStudent(int id);

    public void displayAllStudents();

    public void displayStudentById(int id);

    public boolean isPassed(int id);

    public char calculateGrade(int id);

    public Student getStudentById(int id);
}
package StudentManagementSystem;

public class Course {
    private int courseId;
    private String courseName;
    private int duration;
    private int fees;

    public Course(){
        this.courseId=0;
        this.courseName="";
        this.duration=0;
        this.fees=0;
    }

    public Course(int courseId, String courseName, int duration, int fees){
        this.courseId=courseId;
        this.courseName=courseName;
        this.duration=duration;
        this.fees=fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }
}

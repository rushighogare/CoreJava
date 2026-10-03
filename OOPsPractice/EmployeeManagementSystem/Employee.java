package EmployeeManagementSystem;

public abstract class Employee {
    private int employeeId;
    private String name;
    private String email;
    private int salary;
    private Department department;

    public Employee(){
        this.employeeId=0;
        this.name="";
        this.email="";
        this.salary=0;
        this.department=null;
    }

    public Employee(int employeeId, String name, String email, int salary, Department department){
        this.employeeId=employeeId;
        this.name=name;
        this.email=email;
        this.salary=salary;
        this.department=department;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }

    public String getEmployeeName(){
        return name;
    }

    public void setEmployeeName(String name){
        this.name=name;
    }

    public String getEmployeeEmail(){
        return email;
    }

    public void setEmployeeEmail(String email){
        this.email=email;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }

    public void displayDetails(){
        System.err.println("Employee id: "+this.employeeId);
        System.err.println("Employee name: "+this.name);
        System.err.println("Employee email: "+this.email);
        System.err.println("Employee salary: "+this.salary);
    }

    public abstract int calculateSalary();

    public abstract double calculateBonus();
}

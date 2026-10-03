package EmployeeManagementSystem;

public class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private int hourlyRate;

    public PartTimeEmployee(){
        this.hourlyRate=0;
        this.hoursWorked=0;
    }

    public PartTimeEmployee(int employeeId, String name, String email, int salary, Department department, int hoursWorked, int hourlyRate){
        super(employeeId, name, email, salary, department);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    public int getHoursWorked(){
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked){
        this.hoursWorked=hoursWorked;
    }

    public int getHourlyRate(){
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate){
        this.hourlyRate=hourlyRate;
    }

    @Override 
    public int calculateSalary(){
        return getHourlyRate()*getHoursWorked();
    }

    @Override 
    public double calculateBonus(){
        return 0.05*calculateSalary();
    }

    @Override 
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Employee hours worked: "+this.hoursWorked);
        System.out.println("Employee hourly rate: "+this.hourlyRate);
    }
}

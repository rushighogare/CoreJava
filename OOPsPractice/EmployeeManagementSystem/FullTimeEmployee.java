package EmployeeManagementSystem;

public class FullTimeEmployee extends Employee {
    private int benefits;

    public FullTimeEmployee(){
        super();
        this.benefits=0;
    }

    public FullTimeEmployee(int employeeId, String name, String email, int salary, int benefits, Department department){
        super(employeeId, name, email, salary, department);
        this.benefits=benefits;
    }

    public int getBenefits(){
        return benefits;
    }

    public void setBenefits(int benefits){
        this.benefits=benefits;
    }

    @Override
    public int calculateSalary(){
        return getSalary()+benefits;
    }

    @Override 
    public double calculateBonus(){
        return 0.1*getSalary();
    }

    @Override 
    public void displayDetails(){
        super.displayDetails();
        System.err.println("Employee salary: "+calculateSalary());
        System.out.println("Employee benefits: "+this.benefits);
    }
}

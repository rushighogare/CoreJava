package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    private ArrayList<Employee> employees;
    
    public EmployeeServiceImpl(){
        employees=new ArrayList<>();
    }

    public Employee createEmployee(int employeeId, String name, String email, int salary, Department department, int benefits, int hoursWorked, int hourlyRate, String employeeType){
        Employee e;

        if(employeeType.equalsIgnoreCase("fulltimeemployee")){
            e=new FullTimeEmployee(employeeId, name, email, salary, benefits, department);
        }
        else{
            e=new PartTimeEmployee(employeeId, name, email, salary, department, hoursWorked, hourlyRate);
        }

        addEmployee(e);
        return e;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Employee getEmployeeById(int employeeId){
        for(Employee e: employees){
            if(e.getEmployeeId()==employeeId){
                return e;
            }
        }

        System.out.println("Employee with given id is not found.");
        return null;
    }

    public void displayEmployee(int employeeId){
        Employee e=getEmployeeById(employeeId);
        if(e!=null){
            e.displayDetails();
        }
    }

    public void displayAllEmployees(){
        for(Employee e: employees){
            e.displayDetails();
        }
    }

    public void updateEmployee(int employeeId, Employee updatedEmployee){
        Employee e=getEmployeeById(employeeId);

        if(e!=null){
            e.setEmployeeName(updatedEmployee.getEmployeeName());
            e.setEmployeeEmail(updatedEmployee.getEmployeeEmail());
            e.setDepartment(updatedEmployee.getDepartment());

            if(e instanceof PartTimeEmployee && updatedEmployee instanceof PartTimeEmployee){
                PartTimeEmployee existing=(PartTimeEmployee) e;
                PartTimeEmployee updated=(PartTimeEmployee) updatedEmployee;

                existing.setHoursWorked(updated.getHoursWorked());
                existing.setHourlyRate(updated.getHourlyRate());
            }
            else if(e instanceof FullTimeEmployee && updatedEmployee instanceof FullTimeEmployee){
                FullTimeEmployee existing=(FullTimeEmployee) e;
                FullTimeEmployee updated=(FullTimeEmployee) updatedEmployee;

                existing.setBenefits(updated.getBenefits());
            }

            e.setSalary(updatedEmployee.calculateSalary());
        }
    }

    public void deleteEmployee(int employeeId){
        Iterator<Employee> it=employees.iterator();

        while(it.hasNext()){
            Employee e=it.next();
            if(e.getEmployeeId()==employeeId){
                it.remove();
                return ;
            }
        }

        System.out.println("Employee with given Id is not found for deletion.");
    }

    public void calculateSalary(int employeeId){
        Employee e=getEmployeeById(employeeId);

        if(e!=null){
            System.out.println("Employee salary: "+e.calculateSalary());
        }
    }

    public void calculateBonus(int employeeId){
        Employee e=getEmployeeById(employeeId);

        if(e!=null) System.out.println("Employee bonus: "+e.calculateBonus());
    }

    public List<Employee> getEmployeesByDepartment(int departmentId){
        List<Employee> ans=new ArrayList<>();

        for(Employee e:employees){
            if(e.getDepartment().getDepartmentId()==departmentId){
                ans.add(e);
            }
        }

        return ans;
    }

    public static void main(String[] args){
        EmployeeServiceImpl es=new EmployeeServiceImpl();

        es.createEmployee(1, "Rushikesh", "rushighogare1306@gmail.com", 50000, new Department(1, "Development"), 30000, 0, 0, "fulltimeemployee");
        es.createEmployee(2, "Ajinkya", "ajinkya@gmail.com", 60000, new Department(2, "Cybersecurity"), 0, 900, 20, "parttimeemployee");
        es.createEmployee(3, "Shubham", "shubham@gmail.com", 70000, new Department(1, "Development"), 30000, 0, 0, "fulltimeemployee");
        es.createEmployee(4, "Shantanu", "shantanu@gmail.com", 80000, new Department(1, "Development"), 30000, 0, 0, "fulltimeemployee");

        es.displayAllEmployees();
        
        System.out.println("================================================");
        es.displayEmployee(1);
        es.deleteEmployee(3);
        es.displayAllEmployees();

        System.out.println("================================");

        List<Employee> employee = es.getEmployeesByDepartment(1);
        for(Employee e : employee){
            e.displayDetails();
        }

        System.out.println("================================");
        
        es.calculateSalary(2);
        es.updateEmployee(2, new PartTimeEmployee(2, "Ajinkya", "ajinkya@gmail.com", 60000, new Department(2, "Cybersecurity"), 1000, 30));
        es.calculateSalary(2);
    }
}

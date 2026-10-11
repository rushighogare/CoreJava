package EmployeeManagementSystem;

import java.util.List;

public interface EmployeeService {
    public void addEmployee(Employee employee);

    public Employee getEmployeeById(int employeeId);

    public void displayEmployee(int employeeId);

    public void displayAllEmployees();

    public void updateEmployee(int employeeId, Employee employee);

    public void deleteEmployee(int employeeId);

    public void calculateSalary(int employeeId);

    public void calculateBonus(int employeeId);

    public List<Employee> getEmployeesByDepartment(int departmentId);
}

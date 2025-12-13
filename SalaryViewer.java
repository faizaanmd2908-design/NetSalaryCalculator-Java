import java.io.BufferedReader;
import java.io.FileReader;

public class SalaryViewer {

    private SalaryCalc scalc = new SalaryCalc();

    // View salary by Employee object
    public void viewSalary(Employee emp) {
        scalc.calculateSalary(emp);
    }

    // View salary by Employee ID
    public void viewSalary(String empId) throws Exception {
        Employee emp = getEmployeeById(empId);
        if (emp != null) scalc.calculateSalary(emp);
        else System.out.println("========== Employee not found! ==========");
    }

    // View only employee details
    public void viewDetails(String empId) throws Exception {
        Employee emp = getEmployeeById(empId);
        if (emp != null) {
            System.out.println("========== Employee Details ==========");
            System.out.println("Employee ID  : " + emp.getId());
            System.out.println("Name         : " + emp.getName());
            System.out.println("Basic Salary : " + emp.getBasic());
            System.out.println("HRA          : " + emp.getHra());
            System.out.println("Allowances   : " + emp.getAllowances());
            System.out.println("=====================================");
        } else System.out.println("========== Employee not found! ==========");
    }

    // Helper: get Employee from Data.txt
    private Employee getEmployeeById(String empId) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(empId)) {
                    return new Employee(
                            parts[0], parts[1],
                            Double.parseDouble(parts[2]),
                            Double.parseDouble(parts[3]),
                            Double.parseDouble(parts[4]),
                            parts[5]
                    );
                }
            }
        }
        return null;
    }
}

import java.io.*;
import java.util.*;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private AddEmployee addEmp = new AddEmployee();
    private SalaryViewer salaryViewer = new SalaryViewer();
    private AllEmployeesViewer allEmpViewer = new AllEmployeesViewer();
    private Map<String, String> managers = new HashMap<>();
    private static final String EMPLOYEE_PASSWORD = "Emp@123";

    public Menu() throws IOException { loadManagers(); }

    private void loadManagers() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("ManagerData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) managers.put(parts[0].trim(), parts[1].trim());
            }
        }
    }

    public void start() throws Exception {
        System.out.println("======================================");
        System.out.println("      SELECT YOUR ROLE                 ");
        System.out.println("======================================");
        System.out.println("1. Employee");
        System.out.println("2. Manager");
        System.out.print("Enter choice: ");

        int roleChoice = sc.nextInt();
        sc.nextLine();

        if (roleChoice == 1) employeeLogin();
        else if (roleChoice == 2) managerLogin();
        else System.out.println("Invalid choice!");
    }

    private EmployeeLogin empLogin = new EmployeeLogin();
    private void employeeLogin() throws Exception {
    Employee emp = empLogin.login(sc);

    if (emp == null) {
        System.out.println("Invalid employee credentials!");
        return;
    }

    employeeMenu(emp.getId());
}


    private void employeeMenu(String empId) throws Exception {
        System.out.println("========== Logged in as Employee ==========");
        while (true) {
            System.out.println("1. View My Salary Slip");
            System.out.println("2. View My Details");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1 -> salaryViewer.viewSalary(empId);
                case 2 -> salaryViewer.viewDetails(empId);
                case 3 -> { System.out.println("Logged out successfully."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void managerLogin() throws Exception {
        System.out.print("Enter Manager ID: ");
        String mid = sc.nextLine();
        System.out.print("Enter Manager Password: ");
        String pwd = sc.nextLine();

        if (!managers.containsKey(mid) || !managers.get(mid).equals(pwd)) {
            System.out.println("Invalid manager credentials!");
            return;
        }

        managerMenu();
    }

    private void managerMenu() throws Exception {
        System.out.println("========== Logged in as Manager ==========");
        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Salary");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt(); sc.nextLine();
            switch (ch) {
                case 1 -> addEmp.addDetails(sc);
                case 2 -> {
                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();
                    salaryViewer.viewSalary(id);
                }
                case 3 -> allEmpViewer.viewAll();
                case 4 -> {
                    DeleteEmployee d = new DeleteEmployee();
                    System.out.print("Enter Employee ID to delete: ");
                    String delId = sc.nextLine();
                    d.delete(delId);
                }
                case 5 -> { System.out.println("Manager logged out."); return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}



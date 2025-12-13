import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddEmployee {

    public Employee addDetails(Scanner sc) throws IOException {
        System.out.print("Enter Employee ID: ");
        String id = sc.next();
        sc.nextLine(); // Consume leftover newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Enter HRA: ");
        double hra = sc.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();

        System.out.print("Create Employee Password: ");
        String password = sc.next();

        Employee emp = new Employee(id, name, basic, hra, allowances, password);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data.txt", true))) {
            bw.write(emp.toString());
            bw.newLine();
        }

        System.out.println("============ Employee added successfully! ============");
        return emp;
    }
}

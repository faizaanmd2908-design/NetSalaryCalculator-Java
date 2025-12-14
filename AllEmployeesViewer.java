import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllEmployeesViewer {

    public void viewAll() throws IOException {
        System.out.println("============ ALL EMPLOYEES ============");

        int totalEmployees = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                totalEmployees++;
            }
        }

        System.out.println("Total Employees : " + totalEmployees);
        System.out.println("=======================================");
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AllEmployeesViewer {

    public void viewAll() throws IOException {
        System.out.println("============ ALL EMPLOYEES ============");
        try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) System.out.println(line);
        }
        System.out.println("=======================================");
    }
}

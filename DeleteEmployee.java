import java.io.*;
import java.util.*;

public class DeleteEmployee {

    public void delete(String empId) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader("Data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith(empId + "|")) list.add(line);
                else found = true;
            }
        }

        if (!found) {
            System.out.println("============ Employee not found! ============");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data.txt"))) {
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
        }

        System.out.println("============ Employee deleted successfully! ============");
    }
}


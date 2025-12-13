import java.io.*;
import java.util.*;

public class ManagerLogin {

    private Map<String, String> managers = new HashMap<>();

    public ManagerLogin() throws Exception {
        loadManagers();
    }

    private void loadManagers() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("ManagerData.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split("\\|");
            if (parts.length == 2) managers.put(parts[0], parts[1]);
        }
        br.close();
    }

    public boolean login(Scanner sc) {
        System.out.print("Enter Manager ID: ");
        String mid = sc.nextLine();
        System.out.print("Enter Manager Password: ");
        String pwd = sc.nextLine();

        return managers.containsKey(mid) && managers.get(mid).equals(pwd);
    }
}

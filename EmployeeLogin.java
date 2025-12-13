import java.io.*;
import java.util.*;

public class EmployeeLogin {
public Employee login(Scanner sc) throws Exception {
System.out.print("Employee ID: ");
String id = sc.next();
System.out.print("Password: ");
String pass = sc.next();

BufferedReader br = new BufferedReader(new FileReader("Data.txt"));
String line;
while ((line = br.readLine()) != null) {
String[] p = line.split("\\|");
if (p[0].equals(id) && p[5].equals(pass)) {
br.close();
return new Employee(p[0], p[1], Double.parseDouble(p[2]),
Double.parseDouble(p[3]), Double.parseDouble(p[4]), p[5]);
}
}
br.close();
return null;
}
}
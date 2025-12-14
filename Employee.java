public class Employee {
    private String id;
    private String name;
    private double basic;
    private double hra;
    private double allowances;
    private String password;

    public Employee(String id, String name, double basic, double hra, double allowances, String password) {
        this.id = id;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
        this.allowances = allowances;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBasic() { return basic; }
    public double getHra() { return hra; }
    public double getAllowances() { return allowances; }
    public String getPassword() { return password; }

    public void setName(String name) { this.name = name; }
    public void setBasic(double basic) { this.basic = basic; }
    public void setHra(double hra) { this.hra = hra; }
    public void setAllowances(double allowances) { this.allowances = allowances; }
    public void setPassword(String password) { this.password = password; }

    public String toString() {
        return id + "|" + name + "|" + basic + "|" + hra + "|" + allowances + "|" + password;
    }
}


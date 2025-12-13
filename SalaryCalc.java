public class SalaryCalc {

    public double calculateSalary(Employee emp) {
        double basic = emp.getBasic();
        double hra = emp.getHra();
        double allowances = emp.getAllowances();

        double gross = basic + hra + allowances;

        // Provident Fund (PF)
        double pf = 0.12 * basic;

        // Employee State Insurance (ESI)
        double esi = (gross <= 21000) ? 0.0075 * gross : 0;

        // Professional Tax
        double pt = 200;

        // Income Tax
        double tax;
        if (gross <= 25000) tax = 0;
        else if (gross <= 50000) tax = 0.05 * gross;
        else if (gross <= 100000) tax = 0.10 * gross;
        else tax = 0.15 * gross;

        double net = gross - (pf + esi + pt + tax);

        // Print Salary Slip
        System.out.println("===============================================");
        System.out.println("-------------------------------");
        System.out.println("        SALARY SLIP            ");
        System.out.println("-------------------------------");
        System.out.println("Employee ID          : " + emp.getId());
        System.out.println("Name                 : " + emp.getName());
        System.out.printf("Gross Salary         : %.2f/-\n", gross);
        System.out.printf("PF Deduction         : %.2f/-\n", pf);
        System.out.printf("ESI Deduction        : %.2f/-\n", esi);
        System.out.printf("Professional Tax     : %.2f/-\n", pt);
        System.out.printf("TDS                  : %.2f/-\n", tax);
        System.out.printf("Net Salary           : %.2f/-\n", net);
        System.out.println("-------------------------------");
        System.out.println("===============================================");

        return net;
    }
}

package week5_assignment1.sort_salary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sort_Salary {
    public static void main(String[] args) throws IOException {

        try{
            BufferedReader br = new BufferedReader(new FileReader("week5_assignment1/sort_salary/Employee.csv"));
            List<String[]> records = new ArrayList<>();

            String line = br.readLine();

            while((line = br.readLine()) != null) {
                String[] data = line.split(",");
                records.add(data);
            }

            br.close();

            // sort the salary using lambda function
            records.sort((a, b) -> {
                double salaryA = Double.parseDouble(a[2].trim());
                double salaryB = Double.parseDouble(b[2].trim());
                return Double.compare(salaryB, salaryA);
            });

            System.out.println("Top 5 Highest Paid Employees:\n");

            // Print top 5
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                String[] emp = records.get(i);
                System.out.println((i + 1) + ". " + emp[0] + " | Department: " + emp[1] + " | Salary: " + emp[2]);
            }


        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}

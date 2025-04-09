package week5_assignment1.Search_records;

import java.io.*;
import java.util.Scanner;

public class Search_Employee {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String searchName = sc.nextLine().trim();

        BufferedReader br = new BufferedReader(new FileReader("week5_assignment1/Search_records/Employee.csv"));
        String line;

        br.readLine();

        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            String name = data[0].trim();
            String department = data[1].trim();
            String salary = data[2].trim();

            if (name.equalsIgnoreCase(searchName)) {
                System.out.println("Employee Found!");
                System.out.println("Department: " + department);
                System.out.println("Salary: " + salary);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found in the records.");
        }

        br.close();
    }
}

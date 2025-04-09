package week5_assignment1.Update_salary;

import java.io.*;

public class Update_Salary {
    public static void main(String[] args) throws IOException {

        // Creating the file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("week5_assignment1/Update_salary/Employee_records.csv"));

            writer.write("Name,Department,Salary");
            writer.newLine();

            writer.write("Nazim,IT,10LPA");
            writer.newLine();

            writer.write("Vansh,MBA,20LPA");
            writer.newLine();

            writer.write("Ajay,Finance,8LPA");
            writer.newLine();

            writer.write("Vishal,IT,7LPA");
            writer.newLine();

            writer.write("Sanjay,Marketing,9LPA");
            writer.newLine();

            writer.close();

            System.out.println("CSV file created successfully");

        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }


        // Searching the record of employee

        try {

            BufferedReader br = new BufferedReader(new FileReader("Employee_records"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("week5_assignment1/Update_salary/Updated_Employee_records.csv"));

            String line;
            line = br.readLine();
            bw.write(line);
            bw.newLine();

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String name = data[0].trim();
                String department = data[1].trim();
                double salary = Double.parseDouble(data[2].trim());


                if (department.equalsIgnoreCase("IT")) {
                    salary = salary * 1.10;
                }

                String updatedLine = name + "," + department + "," + String.format("%.2f", salary);
                bw.write(updatedLine);
                bw.newLine();

            }
            br.close();
            bw.close();

            System.out.println("Employee data is updated to file successfully");

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}

package week5_assignment1.create_student_file;

import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "week5_assignment1/create_student_file/employees.csv";

        try (FileWriter writer = new FileWriter(filePath)) {

            writer.append("ID,Name,Department,Salary\n");

            writer.append("201,John,IT,50000\n");
            writer.append("202,Emma,HR,45000\n");
            writer.append("203,David,Finance,55000\n");
            writer.append("204,Linda,Marketing,48000\n");
            writer.append("205,Nazim,Engineering,60000\n");

            System.out.println("CSV file created and data written successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

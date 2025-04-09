package week5_assignment1.Filter_record;

import java.io.*;

public class Filter_Records {
    public static void main(String[] args) {


        // Creating the file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("week5_assignment1/Filter_record/Student_marks.csv"));

            writer.write("Name,Marks");
            writer.newLine();

            writer.write("Nazim,90");
            writer.newLine();

            writer.write("Vansh,90");
            writer.newLine();

            writer.write("Ajay,70");
            writer.newLine();

            writer.write("Vishal,79");
            writer.newLine();

            writer.write("Sanjay,75");
            writer.newLine();

            writer.close();

            System.out.println("CSV file created successfully");

        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }


        // Filter the marks
        try {
            BufferedReader br = new BufferedReader(new FileReader("week5_assignment1/Filter_record/Student_marks.csv"));
            String line;

            // Skip header
            br.readLine();

            System.out.println("\nStudents with marks greater than 80:");
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");
                if (data.length < 2) {
                    continue;
                }

                String name = data[0].trim();
                int marks = Integer.parseInt(data[1].trim());

                if (marks > 80) {
                    System.out.println(name + " : " + marks);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Error reading from CSV file: " + e.getMessage());
        }
    }
}

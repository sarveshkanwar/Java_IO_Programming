package week5_assignment1.student_details;

import java.io.*;

public class StudentDetails {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("week5_assignment1/student_details/studentdetails.csv"));

        writer.write("ID : 2110990935");
        writer.write("\nName : Nazim Ahmad");
        writer.write("\nAge : 21");
        writer.write("\nMarks : 90 / 100");

        writer.close();


        try {
            BufferedReader reader = new BufferedReader(new FileReader("week5_assignment1/student_details/studentdetails.csv"));

            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


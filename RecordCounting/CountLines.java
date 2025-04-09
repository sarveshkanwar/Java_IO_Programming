package week5_assignment1.CountRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLines {
    public static void main(String[] args) {

        String filePath = "employee.csv";
        int recordCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            if((line = reader.readLine()) != null) {

            }

            while((line = reader.readLine()) != null) {
                recordCount++;
            }

            System.out.println("Number of record in file(excluding header) : "+recordCount);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

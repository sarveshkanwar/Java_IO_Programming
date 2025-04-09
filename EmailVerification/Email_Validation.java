package week5_assignment1.Validate_Email;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email_Validation {
    public static void main(String[] args) {

        // Creating a file
        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("week5_assignment1/Validate_Email/emp_data.csv"));

            bw.write("Name,Email,Phone_No");
            bw.newLine();

            bw.write("Nazim,nazim@gmail.com,2836238423");
            bw.newLine();

            bw.write("Vansh,vansh@gmail.com,1277324290");
            bw.newLine();

            bw.write("Akshat,akshat@gmail.com,9072362411");
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        // Validating emails
        try {
            BufferedReader br = new BufferedReader(new FileReader("week5_assignment1/Validate_Email/emp_data.csv"));
            String line = br.readLine();

            String email_regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern_regex = Pattern.compile(email_regex);

            int lineNum = 1;

            while((line = br.readLine()) != null) {
                lineNum++;
                String[] data = line.split(",");

                if(data.length < 3) {
                    System.out.println("Incomplete data");
                    continue;
                }

                String name = data[0].trim();
                String email = data[1].trim();
                String phone = data[2].trim();


                boolean isValid = true;

                Matcher emailMatcher = pattern_regex.matcher(email);
                if (!emailMatcher.matches()) {
                    System.out.println("Line " + lineNum + ": Invalid email for " + name + " -> " + email);
                    isValid = false;
                }


                if (!phone.matches("\\d{10}")) {
                    System.out.println("Line " + lineNum + ": Invalid phone number for " + name + " -> " + phone);
                    isValid = false;
                }

                if (isValid) {
                    System.out.println("Line " + lineNum + ": Valid record for " + name);
                }
            }

            br.close();

        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Collections;

public class Aibar_Barlykov_230103147 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scan.next();

        System.out.print("Enter password: ");
        String password = scan.next();
        // System.out.println(username + " " + password);

        int o = 0;
        boolean nonname = true;
        System.out.println("Main Menu");
        ArrayList<String> student_name = new ArrayList<String>();
        ArrayList<Integer> student_ID = new ArrayList<Integer>();
        ArrayList<Double> student_score = new ArrayList<Double>();
        ArrayList<String> student_b = new ArrayList<String>();

        while (o != 7) {
            // Меню
            System.out.println("1. Add student");
            System.out.println("2. Manage Records");
            System.out.println("3. Calculate Grades");
            System.out.println("4. View Statistics");
            System.out.println("5. Generate Reports");
            System.out.println("6. Delete Student");
            System.out.println("7. Logout and exit");

            // Enter your choice
            System.out.print("Enter your choice: ");
            o = scan.nextInt();

            if ( o == 1 ){  // 1. Add student
                //Student name
                System.out.print("Enter student name: ");
                String name = scan.next();
                for (int i = 0; i < name.length(); i++) {
                    if (Character.isDigit(name.charAt(i))) {
                        nonname = false;
                    }
                }
                if (nonname == true) {


                    //Student ID
                    System.out.print("Enter student ID: ");
                    int ID = scan.nextInt();

                    //Student score
                    System.out.print("Enter test score: ");
                    double score = scan.nextDouble();
                    if (score > 100){
                    System.out.println("Invalid number");
                    }else{
                        System.out.println("Student successfully added");
                        student_score.add(score);
                        student_ID.add(ID);
                        student_name.add(name);
                    }
                }else if(nonname == false) {
                    System.out.println("Wrong name \nTry again");
                }
            }
            else if ( o == 2 ){   //2. Manage Records
                if (student_ID.size() > 0) {
                    System.out.print("Enter student ID to edit: \n");
                    int ID = scan.nextInt();
                    int ID1 = student_ID.indexOf(ID);

                    System.out.print("Enter new test score: ");
                    double score = scan.nextInt();
                    student_score.set(ID1, score);
                    System.out.println("Student record updated successufully.");
                }else {
                    System.out.println("There are no students to manage records");
                }
            }
            else if ( o == 3 ){ //3. Calculate Grades
                int size = student_score.size();
                int b_id = 0;
                if (size > 0) {
                    while (size > 0) {
                        double ball = student_score.get(b_id);
                        if (ball <= 100 & ball >= 90) {
                            student_b.add("A");
                        } else if (ball >= 80 & ball < 90) {
                            student_b.add("B");
                        } else if (ball >= 70 & ball < 80) {
                            student_b.add("C");
                        } else if (ball >= 60 & ball < 70) {
                            student_b.add("D");
                        } else {
                            student_b.add("F");
                        }
                        size -= 1;
                        b_id += 1;
                    }
                    System.out.println("Grades calculated");
                    System.out.println("Grade Details added");
                }else {
                    System.out.println("There are no students to calculate grades");
                }
            }
            else if ( o == 4 ){   //4. View Statistics
                if (student_score.size() > 0){
                int size = student_score.size();
                int b_id = 0;
                double sum = 0;
                while (size > 0){
                    double num = student_score.get(b_id);
                    sum = sum + num;
                    size -= 1;
                    b_id += 1;
                }
                double average = sum / student_score.size();
                System.out.println("Total students: " + student_name.size());
                System.out.println("Average score: " + average);
                System.out.println("Highest score: " + Collections.max(student_score));
                System.out.println("Lowest score: "+ Collections.min(student_score));
            }else {
                    System.out.println("There are no students to do statistics");
                }
            }
            else if ( o == 5 ) {  //5. Generate Reports
                if (student_ID.size() > 0) {
                    System.out.print("Enter student ID to generate a report: ");
                    int ID = scan.nextInt();
                    int ID1 = student_ID.indexOf(ID);
                    System.out.println("Generating report for student with ID: " + ID);
                    System.out.println("Student report");
                    System.out.println("Name: " + student_name.get(ID1));
                    System.out.println("Student ID: " + student_ID.get(ID1));
                    System.out.println("Test score: " + student_score.get(ID1));
                    if (student_b.size() == student_name.size()) {
                        System.out.println("Final grade: " + student_b.get(ID1));
                    }
                }else{
                    System.out.println("There are no students to generate reports");
                }
            }
            else if ( o == 6 ) {  //6. Delete Student
                if (student_ID.size() > 0) {
                    System.out.print("Enter student ID to delete: ");
                    int ID = scan.nextInt();
                    int ID1 = student_ID.indexOf(ID);
                    student_name.remove(ID1);
                    student_score.remove(ID1);
                    student_ID.remove(ID1);
                    if (student_b.size() == student_name.size()) {
                        student_b.remove(ID1);
                    }
                    System.out.println("Student deleted successufully.");
                }else {
                    System.out.println("There are no students to delete");
                }
            }
            else if ( o == 7){   //7. Logout and exit
            }
        }
    }
}
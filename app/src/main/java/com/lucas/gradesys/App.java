package com.lucas.gradesys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.util.Scanner;

import com.opencsv.exceptions.CsvException;

/**
 * The main class of the application.
 */
public class App {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please input path to CSV file: (default to testing Grades.csv)");
        String path = myScanner.nextLine();
        myScanner.close();

        Course course = new Course();
        InputStream inputFileStream = App.class.getClassLoader().getResourceAsStream("Grades.csv");

        try {
            if (!path.isEmpty()) {
                course.loadCourseWorkFromCSV(FileSystems.getDefault().getPath(path));
            } else {
                course.loadCourseWorkFromCSV(inputFileStream);
            }
        } catch (IOException e) {
            System.out.println("Invalid path");
            System.exit(1);
        } catch (CsvException e) {
            System.out.println("Invalid CSV file");
            System.exit(1);
        }

        System.out.println("Sorted CourseWork by Grade: ");
        course.printIncreasingGrades();
        System.out.println("========");
        System.out.println("Sorted CourseWork by Student Name: ");
        course.printIncreasingNames();
        System.out.println("========");
        System.out.println("Sorted CourseWork by Date: ");
        course.printIncreasingDate();
    }
}

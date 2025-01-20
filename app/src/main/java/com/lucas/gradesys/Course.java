package com.lucas.gradesys;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to organize data for a course.
 */
public class Course {
    private List<CourseWork> courseWorkList;

    /**
     * Reads CSV file and stores the data into an arrayList containing courseWork
     * objects.
     * 
     * Expected CSV file format:
     * type,name,studentName,grade,date
     * 
     * @param stream CSV file input stream.
     * @throws IOException
     * @throws CsvException
     */
    public void loadCourseWorkFromCSV(InputStream stream) throws IOException, CsvException {
        this.courseWorkList = new ArrayList<>();
        List<String[]> fileContent = this.readCSV(stream);
        for (String[] courseWorkInfo : fileContent) {
            switch (courseWorkInfo[0]) {
                case "Homework":
                    this.courseWorkList.add(new Homework(courseWorkInfo[1], courseWorkInfo[2],
                            Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
                case "Assessment":
                    this.courseWorkList.add(new Assessment(courseWorkInfo[1], courseWorkInfo[2],
                            Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
            }
        }
    }

    /**
     * Helper method. Reads CSV file content and stores the data into a List of
     * String Arrays.
     * 
     * @param stream
     * @return A List of String Arrays.
     * @throws IOException
     * @throws CsvException
     */
    private List<String[]> readCSV(InputStream stream) throws IOException, CsvException {
        try (InputStreamReader reader = new InputStreamReader(stream)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                return csvReader.readAll();
            }
        }
    }

    /**
     * This method showcases Java Overloading.
     * 
     * Reads CSV file and stores the data into an arrayList containing courseWork
     * objects.
     * 
     * Expected CSV file format:
     * type,name,studentName,grade,date
     * 
     * @param filePath CSV file path
     * @throws IOException
     * @throws CsvException
     */
    public void loadCourseWorkFromCSV(Path filePath) throws IOException, CsvException {
        this.courseWorkList = new ArrayList<>();
        List<String[]> fileContent = this.readCSV(filePath);
        for (String[] courseWorkInfo : fileContent) {
            switch (courseWorkInfo[0]) {
                case Homework.CSV_TYPE_VALUE:
                    this.courseWorkList.add(new Homework(courseWorkInfo[1], courseWorkInfo[2],
                            Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
                case Assessment.CSV_TYPE_VALUE:
                    this.courseWorkList.add(new Assessment(courseWorkInfo[1], courseWorkInfo[2],
                            Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
            }
        }
    }

    /**
     * This method showcases Java Overloading.
     * 
     * Helper method. Reads CSV file content and stores the data into a List of
     * String Arrays.
     * 
     * @param filePath
     * @return A List of String Arrays.
     * @throws IOException
     * @throws CsvException
     */
    private List<String[]> readCSV(Path filePath) throws IOException, CsvException {
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                return csvReader.readAll();
            }
        }
    }

    /**
     * Sorts an CourseWork Array by each CourseWork object's date field. Uses a
     * selection sort algorithm.
     * 
     * Time Complexity: O(n^2)
     * 
     * @param data CourseWork Array
     */
    private void selectionSortIncreasingDate(CourseWork[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            CourseWork current = data[i];
            String earliest = "99999999";
            CourseWork swap = current;
            int swapIndex = i;
            for (int j = i; j < data.length; j++) {
                if (data[j].getDate().compareTo(earliest) < 0) {
                    swap = data[j];
                    swapIndex = j;
                    earliest = swap.getDate();
                }
            }
            data[swapIndex] = current;
            data[i] = swap;
        }
    }

    /**
     * Prints a sorted CourseWork Array by each CourseWork object's date field.
     */
    public void printIncreasingDate() {
        CourseWork[] data = this.courseWorkList.toArray(new CourseWork[0]);
        this.selectionSortIncreasingDate(data);
        this.print(data);
    }

    /**
     * Sorts an CourseWork Array by each CourseWork object's studentName field. Uses
     * a bubble sort algorithm.
     * 
     * Time Complexity: O(n^2)
     * 
     * @param data CourseWork Array
     */
    private void bubbleSortIncreasingStudentNames(CourseWork[] data) {
        int end = data.length;
        while (end > 1) {
            int bubble = 0;
            while (bubble + 1 < end) {
                CourseWork first = data[bubble];
                CourseWork second = data[bubble + 1];
                // If first.getName() is lexicographically greater than second.getName()
                if (first.getStudentName().compareTo(second.getStudentName()) > 0) {
                    data[bubble] = second;
                    data[bubble + 1] = first;
                }
                bubble++;
            }
            end--;
        }
    }

    /**
     * Prints a sorted CourseWork Array by each CourseWork object's studentName
     * field.
     */
    public void printIncreasingNames() {
        CourseWork[] data = this.courseWorkList.toArray(new CourseWork[0]);
        this.bubbleSortIncreasingStudentNames(data);
        this.print(data);
    }

    /**
     * Sorts an CourseWork Array by each CourseWork object's grade field. Uses a
     * insertion sort algorithm.
     * 
     * Time Complexity: O(n^2)
     * 
     * @param data CourseWork Array
     */
    private void insertionSortIncreasingGrades(CourseWork[] data) {
        for (int i = 1; i < data.length; i++) {
            CourseWork current = data[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current.getGrade() >= data[j].getGrade()) {
                    data[j + 1] = current;
                    break;
                }
                data[j + 1] = data[j];
                data[j] = current;
            }

        }
    }

    /**
     * Prints a sorted CourseWork Array by each CourseWork object's grade field.
     */
    public void printIncreasingGrades() {
        CourseWork[] data = this.courseWorkList.toArray(new CourseWork[0]);
        this.insertionSortIncreasingGrades(data);
        this.print(data);
    }

    /**
     * Prints an Array of CourseWork objects.
     * 
     * @param works Array of CourseWork objects.
     */
    public void print(CourseWork[] works) {
        for (CourseWork w : works) {
            System.out.println(w);
        }
    }
}

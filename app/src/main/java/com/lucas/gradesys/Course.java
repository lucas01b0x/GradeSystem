package com.lucas.gradesys;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Course {
    // Make private later
    public List<CourseWork> courseWorkList;

    public void loadCourseWorkFromCSV(Path filePath) throws Exception {
        this.courseWorkList = new ArrayList<>();
        List<String[]> fileContent = this.readCSV(filePath);
        for (String[] courseWorkInfo : fileContent) {
            switch (courseWorkInfo[0]) {
                case "Homework":
                    this.courseWorkList.add(new Homework(courseWorkInfo[1], courseWorkInfo[2], Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
                case "Assessment":
                    this.courseWorkList.add(new Assessment(courseWorkInfo[1], courseWorkInfo[2], Double.parseDouble(courseWorkInfo[3]), courseWorkInfo[4]));
                    break;
            }
        }
    }

    private List<String[]> readCSV(Path filePath) throws IOException, CsvException{
        try (Reader reader = Files.newBufferedReader(filePath)) {
            try (CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {
                return csvReader.readAll();
            }
        }
    }

    public void print(CourseWork[] works) {
        for (CourseWork w : works) {
            System.out.println(w);
        }
    }
}

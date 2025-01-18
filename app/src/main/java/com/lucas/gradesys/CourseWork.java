package com.lucas.gradesys;

public class CourseWork implements Comparable<CourseWork> {
    private String name;
    private double grade;
    private String studentName;

    public CourseWork(String name, String studentName, double grade) {
        this.name = name;
        this.studentName = studentName;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public double getGrade() {
        return this.grade;
    }

    public String getStudentName() {
        return this.studentName;
    }

    @Override
    public String toString() {
        return "StudentName: " + this.studentName + " Work: " + this.name + " Grade: " + this.grade;
    }

    @Override
    public int compareTo(CourseWork o) {
        if (this.grade > o.grade) {
            // Current object has a higher grade...
            return 1;
        } else if (this.grade < o.grade) {
            // Current object has a lower grade...
            return -1;
        } else {
            // Grades are the same.
            return 0;
        }
    }
}

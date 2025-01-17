package com.lucas.gradesys;

public class CourseWork {
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
}

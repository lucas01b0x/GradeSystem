package com.lucas.gradesys;

/**
 * Child class of CourseWork for Homework
 */
public class Homework extends CourseWork {
    public final static String TYPE_COLUMN_VALUE = "Homework";
    private String dueDate;

    public Homework(String name, String studentName, double grade, String dueDate) {
        super(name, studentName, grade);
        this.dueDate = dueDate.trim();
    }

    @Override
    public String getDate() {
        return this.dueDate;
    }

    @Override
    public String toString() {
        return super.toString() + " | DueDate: " + this.dueDate;
    }
}

package com.lucas.gradesys;

public class Assessment extends CourseWork {
    private String assessmentDate;
    
    public Assessment(String name, String studentName, double grade, String assessmentDate) {
        super(name, studentName, grade);
        this.assessmentDate = assessmentDate;
    }

    public String getAssessmentDate() {
        return this.assessmentDate;
    }

    @Override
    public String getDate() {
        return this.assessmentDate;
    }

    @Override
    public String toString() {
        return super.toString() + " AssessmentDate: " + this.assessmentDate;
    }
}
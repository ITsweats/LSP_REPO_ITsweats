package org.howard.edu.lsp.finalexam.question2;

/**
 * Generates a course report.
 */
public class CourseReport extends Report {
    private String courseName;
    private int enrollment;

    @Override
    protected void loadData() {
        courseName = "CSCI 363";
        enrollment = 45;
    }

    @Override
    protected void formatHeader() {
        header = "Course Report";
    }

    @Override
    protected void formatBody() {
        body = "Course: " + courseName + "\nEnrollment: " + enrollment;
    }

    @Override
    protected void formatFooter() {
        footer = "End of Course Report";
    }
}
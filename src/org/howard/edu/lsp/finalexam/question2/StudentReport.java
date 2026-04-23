package org.howard.edu.lsp.finalexam.question2;

/**
 * Generates a student report.
 */
public class StudentReport extends Report {
    private String studentName;
    private double gpa;

    @Override
    protected void loadData() {
        studentName = "John Doe";
        gpa = 3.8;
    }

    @Override
    protected void formatHeader() {
        header = "Student Report";
    }

    @Override
    protected void formatBody() {
        body = "Student Name: " + studentName + "\nGPA: " + gpa;
    }

    @Override
    protected void formatFooter() {
        footer = "End of Student Report";
    }
}
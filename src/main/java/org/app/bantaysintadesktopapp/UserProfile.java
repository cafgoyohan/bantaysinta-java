package org.app.bantaysintadesktopapp;

public class UserProfile {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String program;
    private String year;
    private String section;

    // Constructor
    public UserProfile(String firstName, String lastName, String studentNumber, String program, String year, String section) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.program = program;
        this.year = year;
        this.section = section;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getProgram() {
        return program;
    }

    public String getYear() {
        return year;
    }

    public String getSection() {
        return section;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSection(String section) {
        this.section = section;
    }
}

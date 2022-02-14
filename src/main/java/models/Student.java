package models;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String fName;
    private String lName;
    private String course;

    public Student(String fName, String lName, String course) {
        this.fName = fName;
        this.lName = lName;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("{ %s %s %s }", fName, lName, course);
    }
}

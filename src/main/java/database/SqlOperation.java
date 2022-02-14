package database;

import models.Student;

import java.sql.*;
import java.util.ArrayList;

public class SqlOperation {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "#Peniskop911911";

    public static void createStudentsTable (){

        String sqlCrateTable = "CREATE TABLE IF NOT EXISTS ss_finalproject.students (id INTEGER NOT NULL AUTO_INCREMENT, fname VARCHAR(255), lname VARCHAR(255), course VARCHAR(255), PRIMARY KEY (id))";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            statement.execute(sqlCrateTable);
            System.out.println("Table created successful!");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("ERROR: Table isn't created");
        }
    }

    public static void addStudent (Student student){
        String sqlAddStudent = "INSERT INTO ss_finalproject.students (fName, lName, course) VALUES (?, ?, ?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlAddStudent);
            preparedStatement.setString(1, student.getfName());
            preparedStatement.setString(2, student.getlName());
            preparedStatement.setString(3, student.getCourse());
            preparedStatement.execute();
            System.out.printf("Student %s %s is successfully added at course %s\n", student.getfName(), student.getlName(), student.getCourse());
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("");
        }
    }

    public static void deleteStudent (int id){
        String sqlDelete = "DELETE FROM ss_finalproject.students WHERE id="+id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDelete);
            System.out.println("Delete successful");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("ERROR: deleting failed");
        }
    }

    public static ArrayList<Student> getAllStudents (){
        ArrayList<Student> studentList = new ArrayList<>();
        String sqlGetAll = "SELECT * FROM ss_finalproject.students";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlGetAll);
            while (resultSet.next()){
                Student student = new Student(
                        resultSet.getString("fname"),
                        resultSet.getString("lname"),
                        resultSet.getString("course"));
                student.setId(resultSet.getInt("id"));
                studentList.add(student);
            }
            System.out.println("Students is read");
        } catch (SQLException | ClassNotFoundException e){
            System.out.println("ERROR: can't read students:");
            e.printStackTrace();
        }
        return studentList;
    }

    public static void editStudent (Student student, int id){
        String sqlEdit = "UPDATE ss_finalproject.students SET fname =?, lname = ?, course = ? WHERE id=?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            PreparedStatement prStatement = connection.prepareStatement(sqlEdit);
            prStatement.setString(1, student.getfName());
            prStatement.setString(2, student.getlName());
            prStatement.setString(3, student.getCourse());
            prStatement.setInt(4,id);
            prStatement.execute();
            System.out.println("Student data updated successfully");
        }catch (SQLException | ClassNotFoundException e){
            System.out.println("ERROR: can't update student data");
        }
    }
}

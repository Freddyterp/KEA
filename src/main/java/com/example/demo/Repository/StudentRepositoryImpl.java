package com.example.demo.Repository;

import com.example.demo.Model.Student;
import com.example.demo.Repository.IStudentRepository;
import com.example.demo.Util.DatabaseConnectionManager;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private Connection conn;

    public StudentRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Student student){

    try {

        Statement st = conn.createStatement();
        st.executeUpdate("INSERT INTO students(,"+student.getFirst_name()+","
                +student.getLast_name()+","+student.getEnrollment_date()+","+student.getCpr()+")");

        /*
        String sql = "INSERT INTO students(id, firstname, lastname, cpr, enrollmentDate) VALUES (?,?,?,?,?)";
        PreparedStatement prepState = conn.prepareStatement(sql);
        prepState.setInt(1, id);
        prepState.setString(2,firstName);
        prepState.setString(3, lastName);
        prepState.setInt(4, cpr);
        prepState.setDate(5, (java.sql.Date) date);

        prepState.executeUpdate(sql);
         */

    }catch(SQLException e){
        e.printStackTrace();
    }


        return false;
    }

    @Override
    public Student read(int id) {
        Student studentToReturn = new Student();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM students WHERE id=?");
            getSingleStudent.setInt(1,id);
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                studentToReturn = new Student();
                studentToReturn.setId(rs.getInt(1));
                studentToReturn.setFirst_name(rs.getString(2));
                studentToReturn.setLast_name(rs.getString(3));
                studentToReturn.setCpr(rs.getInt(4));
                studentToReturn.setEnrollment_date(rs.getDate(5));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return studentToReturn;
    }

    @Override
    public List<Student> readAll() {
        List<Student> allStudents = new ArrayList<Student>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student tempStudent = new Student();
                tempStudent.setId(rs.getInt(1));
                tempStudent.setFirst_name(rs.getString(2));
                tempStudent.setLast_name(rs.getString(3));
                tempStudent.setCpr(rs.getInt(4));
                tempStudent.setEnrollment_date(rs.getDate(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}

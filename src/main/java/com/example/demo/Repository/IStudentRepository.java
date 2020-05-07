package com.example.demo.Repository;

import com.example.demo.Model.Student;

import java.util.Date;
import java.util.List;

public interface IStudentRepository {
    // CRUD operations
    public boolean create(Student student);

    public Student read(int id);

    public List<Student> readAll();

    public boolean update(Student student);

    public boolean delete(int id);
}



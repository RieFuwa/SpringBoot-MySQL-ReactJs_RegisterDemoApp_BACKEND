package com.bedirhankabatas.RegisterDemoWebApp.service;

import com.bedirhankabatas.RegisterDemoWebApp.model.Student;

import java.util.List;


public interface StudentService {

     Student saveStudent(Student student);
     List<Student> getAllStudent();
     Student getStudentById(Long id);
     Boolean deleteStudentById(Long studentId);
     Student updateStudentById(Long studentId, Student student);
}

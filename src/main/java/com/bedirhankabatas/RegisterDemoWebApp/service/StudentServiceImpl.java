package com.bedirhankabatas.RegisterDemoWebApp.service;

import com.bedirhankabatas.RegisterDemoWebApp.model.Student;
import com.bedirhankabatas.RegisterDemoWebApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(Math.toIntExact(studentId)).orElse(null);
    }

    @Override
    public Boolean deleteStudentById(Long studentId) {
        Optional<Student> deleteStudent = studentRepository.findById(Math.toIntExact(studentId));
        if (deleteStudent.isPresent()){
            studentRepository.deleteById(Math.toIntExact(studentId));
            return true;
        }
            return false;
    }
    @Override
    public Student updateStudentById(Long studentId, Student newUser) {
        Optional<Student> student = studentRepository.findById(Math.toIntExact(studentId));
        if(student.isPresent()){
            Student updateStudent = student.get();
            updateStudent.setName(newUser.getName());
            updateStudent.setAddress(newUser.getAddress());
            return studentRepository.save(updateStudent);
        }else{
            return null;
        }
    }


}

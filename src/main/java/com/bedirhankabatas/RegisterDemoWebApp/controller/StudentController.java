package com.bedirhankabatas.RegisterDemoWebApp.controller;


import com.bedirhankabatas.RegisterDemoWebApp.model.Student;
import com.bedirhankabatas.RegisterDemoWebApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private  StudentService studentService;

    @PostMapping("/add")
    public Student add(@RequestBody Student student){
       return studentService.saveStudent(student);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteStudentById(@PathVariable("id") Long studentId){
        return studentService.deleteStudentById(studentId);
    }

    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable("id") Long studentId, @RequestBody Student student){
        return  studentService.updateStudentById(studentId,student);
    }

}

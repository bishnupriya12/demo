package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;
    @PostMapping("/save")
    public Student saveStudent(@Valid @RequestBody Student student) throws Exception {
        boolean entityValidation = studentService.entityValidation(student);
        System.out.println("entityValidation :"+ entityValidation);
        student.setTotal(student.getTotal());
        student.setResult(student.getResult());
        student.setAverage(student.getAverage());
        System.out.println(student);
        if(entityValidation)
             return studentRepository.save(student);
        else
            throw new Exception();
    }
    @PutMapping("/update/{id}")
    public Student updateStudent(@Valid @RequestBody Student student,@PathVariable long id){
        Student studentFromDB = null;
        student.setTotal(student.getTotal());
        student.setResult(student.getResult());
        student.setAverage(student.getAverage());
        try{
            studentFromDB = studentRepository.findById(id).get();
        }catch(Exception ex)
        {
            System.out.println("No Student found for this id : "+id);
        }
        if (null !=studentFromDB){
            studentFromDB.setTotal(student.getTotal());
            studentFromDB.setResult(student.getResult());
            studentFromDB.setAverage(student.getAverage());
            studentFromDB.setMarks1(student.getMarks1());
            studentFromDB.setMarks2(student.getMarks2());
            studentFromDB.setMarks3(student.getMarks3());
        }
        else {
            studentFromDB = student;
        }
        return studentRepository.save(studentFromDB);
    }
}

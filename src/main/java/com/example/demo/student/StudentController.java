package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// controller is the api layer
@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    //StudentService is a bean.
    private final StudentService studentService;

    //dependency injection @Autowired.
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
       return studentService.getStudents();
    }

    //post request
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

//    @PutMapping(path = "{studentId}")
//    public void updateStudent(
//            @PathVariable("studentId") Long studentId,
//            @RequestParam(required= false) String name,
//            @RequestParam(required= false) String email
//    ){
//        studentService.updateStudent(studentId, name, email);
//    }

}

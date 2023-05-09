package com.example.sprintbootjpah2.controller;

import com.example.sprintbootjpah2.entity.Student;
import com.example.sprintbootjpah2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
        try {
            if (id == null)
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(studentService.getById(Long.valueOf(id.longValue())), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        try {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(studentService.setStudentInfoById(student.getFirstName(), student.getLastName(), Long.valueOf(id.longValue())), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        try {
            List<Student> students = new ArrayList<Student>();
            studentService.getAllStudents().forEach(students::add);
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

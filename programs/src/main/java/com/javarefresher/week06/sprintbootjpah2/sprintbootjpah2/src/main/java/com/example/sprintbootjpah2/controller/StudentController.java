package com.example.sprintbootjpah2.controller;

import com.example.sprintbootjpah2.entity.Student;
import com.example.sprintbootjpah2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
    @GetMapping(value = "/", produces = { "application/hal+json" })
    public ResponseEntity<CollectionModel<Student>> getAllStudents(){
        try {
            List<Student> students = new ArrayList<Student>();
            studentService.getAllStudents().forEach((student) ->{
                student.add(linkTo(StudentController.class).slash(student.getStudentId()).withSelfRel());
                students.add(student);
            });
            if (students.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Link link = linkTo(StudentController.class).withSelfRel();
            CollectionModel<Student> result = CollectionModel.of(students, link);
            return new  ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

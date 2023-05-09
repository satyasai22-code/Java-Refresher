package com.example.sprintbootjpah2.service;

import com.example.sprintbootjpah2.entity.Student;
import com.example.sprintbootjpah2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
   StudentRepository studentRepo;

    public Student save(Student student){
        return studentRepo.save(student);
    }
    public Student getById(Long id){
        return studentRepo.findById(id).get();
    }
    public void deleteById(Long id){
        studentRepo.deleteById(id);
    }
    public Student update(Student student){
        return studentRepo.setUserInfoById(student.getFirstName(), student.getLastName(), student.getStudentId());
    }
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    public Student setStudentInfoById(String firstname, String lastname,Long userId){
        return studentRepo.setUserInfoById(firstname, lastname, userId);
    }
}

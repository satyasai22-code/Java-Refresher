package com.example.sprintbootjpah2.repository;

import com.example.sprintbootjpah2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Modifying
    @Query("update Student u set u.firstName = ?1, u.lastName = ?2 where u.studentId = ?3")
    Student setUserInfoById(String firstname, String lastname,Long userId);
}

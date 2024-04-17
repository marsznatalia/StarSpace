package com.uep.wap.service;

import com.uep.wap.dto.StudentDTO;
import com.uep.wap.model.Student;
import com.uep.wap.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setPoints(studentDTO.getPoints());
        studentRepository.save(student);
        System.out.println("Students added!");
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}

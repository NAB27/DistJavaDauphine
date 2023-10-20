package TP1demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentEntityRepository StudentEntityRepository;

@Override
    public Student createStudent(Student student) {
        // Implement the logic to create and save a new student
        return StudentEntityRepository.save(student);
    }
}


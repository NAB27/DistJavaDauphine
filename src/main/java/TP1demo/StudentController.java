package TP1demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    StudentEntityRepository studentEntityRepository;

    public StudentController(StudentService studentService) {
        this.studentService = studentService ;
    }

    /**
     *
     * @return on return tout les students de la database
     */
    @GetMapping
    @RequestMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentEntityRepository.findAll();
    }

    /**
     *
     * @return on return tout les students de la database avec le meme prenom
     */
    @GetMapping
    @RequestMapping("/getAllByLastname")
    public List<Student> getAllStudentsByLastname(@RequestParam("lastname") String lastname) {
        return studentEntityRepository.findAllByLastNameIgnoreCase(lastname);
    }
    /**
     *
     * @return on return tout les students dont age < 30
     */
    @GetMapping
    @RequestMapping("/getAge")
    public List<Student> getAllStudentsByAgeYoungerThan() {
        return studentEntityRepository.findByAgeLessThan(30);
    }

    @PostMapping
    @RequestMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    @RequestMapping("/modify/email/{oldemail}/{newemail}")
    public void modifyEmail(@PathVariable String oldemail, @PathVariable String newemail){
        studentEntityRepository.updateEmail(oldemail,newemail);
    }

    @PutMapping
    @RequestMapping("/modify/age")
    public void modifyAge(){
       List<Student> students = studentEntityRepository.findAll();
       for(Student s: students){
           s.setAge(s.getAge()+1);
       }
       studentEntityRepository.saveAll(students);
    }

}


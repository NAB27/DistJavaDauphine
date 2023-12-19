package TP1demo;

import TP1demo.Book;
import TP1demo.BookEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookEntityRepository bookEntityRepository;

    @Autowired
    private StudentEntityRepository studentEntityRepository;


    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookEntityRepository.findAll();
    }

    @GetMapping("/findByBookName")
    public List<Book> getBooksByName(@RequestParam("bookName") String bookName) {
        return bookEntityRepository.findByBookName(bookName);
    }

    @PostMapping (value = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book createBook(@RequestBody Book book) {
        return bookEntityRepository.save(book);
    }

    @PutMapping("/updateBooks/{studentId}")
    public String updateBooksForStudent(@PathVariable Integer studentId, @RequestBody List<Book> newBooks) {
        Optional<Student> optionalStudent = studentEntityRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            List<Book> oldBooks =  student.getBooks();
            oldBooks.forEach(book -> book.setStudent(null));
            newBooks.forEach(book -> book.setStudent(student));
            bookEntityRepository.saveAll(newBooks);
            student.setBooks(newBooks);
            studentEntityRepository.save(student);
            return "Successfully updated the books for the student with ID " + studentId;
        } else {
            return "Student with ID " + studentId + " not found.";
        }
    }

}

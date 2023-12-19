package TP1demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_code")
    private String bookCode;

    @JsonBackReference

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}



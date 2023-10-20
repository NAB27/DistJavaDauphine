package TP1demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookEntityRepository extends JpaRepository<Book, Integer> {
    List<Book> findByBookName(String bookName);
}

package TP1demo;

import TP1demo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private TP1demo.BookEntityRepository bookEntityRepository;

    @Override
    public Book createBook(Book book) {
        return bookEntityRepository.save(book);
    }
    @Override
    public List<Book> findAllBooks() {
        return bookEntityRepository.findAll();
    }
    @Override
    public List<Book> findBooksByName(String name) {
        return bookEntityRepository.findByBookName(name);
    }
}

package TP1demo;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    List<Book> findAllBooks();
    List<Book> findBooksByName(String name);
}

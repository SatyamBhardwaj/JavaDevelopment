package org.geeksforgeeks.jbdl7.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    @Autowired
    private Environment env;    // Environment Object containts the port number

    @GetMapping("/books")
    public List<Book> getBooks() throws SQLException {
        return repository.findAll();
    }

    @PostMapping("/book")
    public void createBook(@RequestBody Book book) throws SQLException {
        repository.save(book);
    }

    @GetMapping("/book")
    public List<Book> getBooksByAuthorName(@RequestParam("author") String author) throws SQLException {
        return repository.findBooksByAuthor(author);

    }

    @PutMapping("/book")
    public int editBooksByAuthorName(@RequestParam("authorrep") String authorrep, @RequestParam("newauthor") String newauthor) throws SQLException {
        return repository.UpdateAuthor(authorrep, newauthor);

    }

    @DeleteMapping("/book")
    public int deleteBook() throws SQLException {
        return repository.deletebook();

    }
    @GetMapping("/status")
    public String status()
    {
        return "Running On Port No: "+(env.getProperty("local.server.port"));
    }
}
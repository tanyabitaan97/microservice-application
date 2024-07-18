package com.example.bookms.api;

import com.example.bookms.domain.Book;
import com.example.bookms.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookResource {
	
    @Autowired
    private BookRepo repo;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = repo.findAll();
        return new ResponseEntity<>(allBooks,HttpStatus.OK);
    }
    
    @PostMapping("/book")
    public ResponseEntity<Book> getByBookId(@RequestBody Book book) {
    	
        Book bookById = repo.selectIsbn(book.getIsbn());
        return new ResponseEntity<>(bookById,HttpStatus.OK);
        
    }
    
    @PostMapping("/books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
    	
    	Book savedBook = repo.save(book);
    	return new ResponseEntity<>(savedBook,HttpStatus.OK);
    	
    }
    
    @PutMapping("/edit/book")
    public ResponseEntity<Book> editBook(@RequestBody Book  book) {
    	
    		Book foundBook = repo.selectIsbn(book.getIsbn());

    		foundBook.setIssuedCopies(book.getIssuedCopies());
    		repo.save(foundBook);
    		return new ResponseEntity<Book>(foundBook,HttpStatus.OK);
    	
    	
    	
    }
    
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer bookId) {
    	
    	repo.deleteById(bookId);
    	return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
    


}

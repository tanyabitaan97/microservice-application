package com.example.bookms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bookms.domain.Book;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
	
  @Query(value="select * from books_store where isbn=:isbn",nativeQuery = true)
  Book selectIsbn(@Param("isbn") String isbn);
	
}

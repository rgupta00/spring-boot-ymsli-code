package com.bookapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bookapp.dto.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}

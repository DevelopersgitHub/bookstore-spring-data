package com.senlainc.training.backend.repository;

import com.senlainc.training.backend.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Book, Long> {

}

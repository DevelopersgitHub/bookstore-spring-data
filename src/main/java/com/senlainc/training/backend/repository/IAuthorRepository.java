package com.senlainc.training.backend.repository;

import com.senlainc.training.backend.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface IAuthorRepository extends CrudRepository<Author, Long> {

}

package com.senlainc.training.backend.services;

import com.senlainc.training.backend.repository.IAuthorRepository;
import com.senlainc.training.backend.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuthorServiceImpl {

    @Autowired
    private IAuthorRepository authorRepository;

    public void save(Author author) {
        this.authorRepository.save(author);
    }

    public List<Author> findAll() {
        return (List<Author>) this.authorRepository.findAll();
    }

    public Author findById(Long id) {
        Author author = null;
        Optional<Author> optionalAuthor = this.authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            author = optionalAuthor.get();
        }
        return author;
    }

    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }

}

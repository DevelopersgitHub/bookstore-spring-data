package com.senlainc.training.backend.services;

import com.senlainc.training.backend.domain.Book;
import com.senlainc.training.backend.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl {

    @Autowired
    private IBookRepository bookRepository;

    public void save(Book book) {
        this.bookRepository.save(book);
    }

    public List<Book> findAll() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book findById(Long id) {
        Book book = null;
        Optional<Book> optionalBook = this.bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        }
        return book;
    }

    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

}

package com.senlainc.training.backend.controllers;

import com.senlainc.training.backend.services.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;


}

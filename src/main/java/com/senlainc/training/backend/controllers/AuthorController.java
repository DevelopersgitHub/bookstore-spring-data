package com.senlainc.training.backend.controllers;

import com.senlainc.training.backend.services.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;



}

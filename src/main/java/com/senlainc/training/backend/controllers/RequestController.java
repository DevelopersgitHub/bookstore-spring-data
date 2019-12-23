package com.senlainc.training.backend.controllers;

import com.senlainc.training.backend.services.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RequestController {

    @Autowired
    private RequestServiceImpl requestService;
}

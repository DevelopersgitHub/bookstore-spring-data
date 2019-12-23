package com.senlainc.training.backend.controllers;

import com.senlainc.training.backend.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @Autowired
    private OrderServiceImpl customerService;

}

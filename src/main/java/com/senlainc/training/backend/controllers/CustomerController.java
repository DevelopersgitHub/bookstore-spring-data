package com.senlainc.training.backend.controllers;

import com.senlainc.training.backend.domain.Customer;
import com.senlainc.training.backend.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/")
    public ModelAndView home() {
        List<Customer> listCustomer = this.customerService.findAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

}

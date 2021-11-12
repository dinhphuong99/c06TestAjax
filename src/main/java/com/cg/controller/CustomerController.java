package com.cg.controller;


import com.cg.model.Customer;
import com.cg.model.Search;
import com.cg.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;



    @GetMapping
    public ModelAndView listCustomers() {
        Iterable<Customer> customers = customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("searchObj", new Search());
        return modelAndView;
    }



    @GetMapping("/create-customer")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("success", "New customer created successfully");
        return modelAndView;
    }


    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);

        Optional<Customer> customer = customerService.findById(id);

        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }

//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/edit");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
    }

    @GetMapping("/edit-by-first-name/{firstName}")
    public ModelAndView showEditFormByFirstName(@PathVariable("firstName") String firstName) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Optional<Customer> customer = customerService.findByFirstName(firstName);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/edit-by-last-name/{lastName}")
    public ModelAndView showEditFormByLastName(@PathVariable("lastName") String lastName) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        Optional<Customer> customer = customerService.findByLastNameNativeQuery(lastName);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView getSearch(@ModelAttribute("searchObj") Search search) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/customer/list");

        BigDecimal minMoney = search.getMinMoney();
        BigDecimal maxMoney = search.getMaxMoney();

        Iterable<Customer> customers = customerService.findAllByBalance(minMoney, maxMoney);

        modelAndView.addObject("customers", customers);

        return modelAndView;
    }

//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }

    @PostMapping("/edit-by-last-name")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("success", "Customer updated successfully");
        return modelAndView;
    }

//    @GetMapping("/delete-customer/{id}")
//    public ModelAndView showDeleteForm(@PathVariable Long id) {
//        Customer customer = customerService.findById(id);
//        if (customer != null) {
//            ModelAndView modelAndView = new ModelAndView("/customer/delete");
//            modelAndView.addObject("customer", customer);
//            return modelAndView;
//
//        } else {
//            ModelAndView modelAndView = new ModelAndView("/error.404");
//            return modelAndView;
//        }
//    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.remove(customer.getId());
        return "redirect:/customers";
    }

}

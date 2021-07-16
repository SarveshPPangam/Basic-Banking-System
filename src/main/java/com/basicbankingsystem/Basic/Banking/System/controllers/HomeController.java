package com.basicbankingsystem.Basic.Banking.System.controllers;

import com.basicbankingsystem.Basic.Banking.System.models.Customer;
import com.basicbankingsystem.Basic.Banking.System.services.CustomerService;
import com.basicbankingsystem.Basic.Banking.System.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {
    @Autowired
    CustomerService customerService;

    @Autowired
    TransferService transferService;

    String message, error;

    @GetMapping("/")
    public String root(){
        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("allCustomers", customerService.getAll());
        model.addAttribute("message", message);
        model.addAttribute("error", error);
        message = null;
        error = null;
        return "customers";
    }

    @GetMapping("/transferHistory")
    public String transferHistory(Model model) {
        model.addAttribute("allTransfers", transferService.getAll());
        return "transfer-history";
    }

    @GetMapping("/transfer/")
    public String transferPage(int id, Model model) {
        Customer transferFrom = customerService.findById(id);
        model.addAttribute("toCustomers", customerService.getAll().stream().filter(customer ->
                customer.getId() != id).collect(Collectors.toList()));
        model.addAttribute("from", transferFrom);
        return "transfer-page";
    }

    @PostMapping("/transfer")
    public String transfer(int fromId, int toId, double amount, Model model) {
        try {
            Customer from = customerService.findById(fromId);
            Customer to = customerService.findById(toId);
            if (customerService.transfer(from, to, amount))
                message = "Successfully transferred from " + from.getName() + " to " + to.getName() + "!";
            else error = "Insufficient balance in account of " + from.getName() + "!";
            return "redirect:/customers";
        }catch (Exception e){
            error = "Enter valid amount!";
            return "redirect:/customers";

        }
    }
}

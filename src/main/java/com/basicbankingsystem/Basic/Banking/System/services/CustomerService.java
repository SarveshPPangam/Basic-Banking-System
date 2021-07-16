package com.basicbankingsystem.Basic.Banking.System.services;

import com.basicbankingsystem.Basic.Banking.System.models.BankAccount;
import com.basicbankingsystem.Basic.Banking.System.models.Customer;
import com.basicbankingsystem.Basic.Banking.System.models.Transfer;
import com.basicbankingsystem.Basic.Banking.System.repositories.CustomerRepository;
import com.basicbankingsystem.Basic.Banking.System.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransferRepository transferRepository;


    public List<Customer> getAll(){
        return customerRepository.findAllByOrderByNameAsc();
    }

    public Customer findById(int id){
        return customerRepository.findById(id).get();
    }

    public boolean transfer(Customer transferFrom, Customer transferTo, double amount){
        if(!transferFrom.withdraw(amount)) return false;
        transferTo.deposit(amount);
        customerRepository.save(transferFrom);
        customerRepository.save(transferTo);
        transferRepository.save(new Transfer(transferFrom.getName(), transferTo.getName(), amount));
        return true;
    }


}

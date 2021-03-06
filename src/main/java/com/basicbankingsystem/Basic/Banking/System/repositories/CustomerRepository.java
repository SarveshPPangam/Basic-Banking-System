package com.basicbankingsystem.Basic.Banking.System.repositories;

import com.basicbankingsystem.Basic.Banking.System.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public List<Customer> findAllByOrderByNameAsc();
}

package com.bymyself.SteelFabricatedOrderManage.repository;

import com.bymyself.SteelFabricatedOrderManage.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer save(Customer customer);
    Customer findById(int id);
    List<Customer> findAll();
    Customer findByMail(String email);
}

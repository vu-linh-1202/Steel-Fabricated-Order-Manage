package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Customer;
import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findById(int id);
    HashMap<String, Object> getOrders(int c_id);
    List<Customer> findAll();
    Customer findByMail(String email);
    Customer authenticate(String email, String password);
    void  addOrder(Order order);
    void transaction(int amount, int c_id);
}

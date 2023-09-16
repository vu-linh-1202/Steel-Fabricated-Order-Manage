package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Customer;
import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import com.bymyself.SteelFabricatedOrderManage.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductService productService;
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public HashMap<String, Object> getOrders(int c_id) {
        Customer customer = customerRepository.findById(c_id);
        List<Order> list = customer.getOrders();
        List<Product> products = new ArrayList<>();
        if (list!= null)
        {
            for(Order o: list)
            {
                products.add(o.getProduct());
            }
        }
        HashMap<String, Object> responseOrder = new HashMap<>();
        if (list != null)
        {
            responseOrder.put("Orders", list);
            responseOrder.put("Products", products);
        }
        else
        {
            responseOrder.put("Orders", 0);
            responseOrder.put("Products", 0);
        }
        return responseOrder;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> list = customerRepository.findAll();
        return list;
    }

    @Override
    public Customer findByMail(String email) {
        Customer customer = customerRepository.findByMail(email);
        return customer;
    }

    @Override
    public Customer authenticate(String email, String password) {
        Customer customer = customerRepository.findByMail(email);
        if (customer == null)
        {
            return null;
        }
        if (customer.getPassword().equals(password)) return customer;
        else return null;
    }

    @Override
    public void addOrder(Order order) {
        int c_id = order.getcId();
        Customer customer = findById(c_id);
        customer.addOrder(order);
        System.out.println(customer.getOrders());
    }

    @Override
    public void transaction(int amount, int c_id) {
        Customer customer = findById(c_id);
        customer.setWalletBalance(customer.getWalletBalance()+ amount);
        customerRepository.save(customer);
    }
}

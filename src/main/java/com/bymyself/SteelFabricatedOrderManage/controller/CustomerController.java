package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.entities.Customer;
import com.bymyself.SteelFabricatedOrderManage.model.Credential;
import com.bymyself.SteelFabricatedOrderManage.model.Transaction;
import com.bymyself.SteelFabricatedOrderManage.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") int id)
    {
        Customer cu = customerService.findById(id);
        System.out.println(cu);
        if (cu == null) throw new RuntimeException("Customer not found");
        return ResponseEntity.ok(cu);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> findAll()
    {
        List<Customer> customerList = customerService.findAll();
        if (customerList==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(customerList);
    }

    @PostMapping("")
    public ResponseEntity<Customer> save(@RequestBody Customer customer)
    {
        Customer newCustomer = customerService.save(customer);
        if (newCustomer == null) throw new RuntimeException("Something went wrong");
        return ResponseEntity.ok(newCustomer);
    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> authenticate(@RequestBody Credential cred){
        Customer customer = customerService.authenticate(cred.getMail(), cred.getPassword());
        if(customer == null) throw new RuntimeException("Wrong email id or password");
        HashMap<String, Object> responseAuth = new HashMap<String, Object>();
        responseAuth.put("status", new String("success"));
        responseAuth.put("data", customer);
        return ResponseEntity.ok(responseAuth);
    }

    @PostMapping("/update")
    public ResponseEntity<HashMap<String, Object>> update(@RequestBody Customer customer){

        System.out.println("recieved" + customer);
        Customer updatedCust = customerService.save(customer);
        if(updatedCust == null) new RuntimeException("Something went wrong");
        HashMap<String, Object> responseUpdate = new HashMap<String, Object>();
        responseUpdate.put("status", new String("success"));
        responseUpdate.put("data", updatedCust);
        return ResponseEntity.ok(responseUpdate);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> pay(@RequestBody Transaction transaction){
        System.out.println(transaction);
        customerService.transaction(transaction.getAmount(), transaction.getCid());
        String responseData = "Payment successful";
        return ResponseEntity.ok(responseData);
    }
}

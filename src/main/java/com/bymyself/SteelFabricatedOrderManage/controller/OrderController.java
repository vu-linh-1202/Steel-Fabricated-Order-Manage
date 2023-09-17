package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.dto.OrderDto;
import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import com.bymyself.SteelFabricatedOrderManage.entities.Product;
import com.bymyself.SteelFabricatedOrderManage.services.CustomerService;
import com.bymyself.SteelFabricatedOrderManage.services.OrderServices;
import com.bymyself.SteelFabricatedOrderManage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderServices orderServices;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/{cid}")
    public ResponseEntity<HashMap<String, Object>> getOrders(@PathVariable("cid") int cid)
    {
        HashMap<String, Object> order = customerService.getOrders(cid);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/stafforders/{id}")
    public ResponseEntity<List<Order>> getStaffOrders(@PathVariable("id") int id)
    {
        System.out.println("Get method call" + id);
        List<Order> orders = orderServices.findByStaff(id);
        System.out.println(orders);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/customerid/{cid}")
    public ResponseEntity<List<Product>> findOrdersForCustomer(@PathVariable("cid") int cid)
    {
        List<Product> productList = new ArrayList<>();
        List<Order> orderList = orderServices.findAll();
        for(Order order: orderList)
        {
            if (order.getcId() == cid)
            {
                Product product = order.getProduct();
                productList.add(product);
            }
        }
        return ResponseEntity.ok(productList);
    }

    @GetMapping("")
    public ResponseEntity<List<Order>> findAll()
    {
        List<Order> orderList = orderServices.findAll();
        if (orderList == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(orderList);
    }

    @CrossOrigin(origins = "http://localhost:3001")
    @PostMapping("/putorder")
    public ResponseEntity<Order> putorder(@RequestBody OrderDto orderDto)
    {
        System.out.println(orderDto);
        Order newOrder = new Order();
        newOrder.setcId(orderDto.getcId());
        newOrder.setProduct(productService.findById(orderDto.getpId()));
        newOrder.setDdate(orderDto.getDdate());
        newOrder.setQty(orderDto.getQty());
        newOrder.setoDate(orderDto.getoDate());
        newOrder.setStatus(orderDto.getStatus());
        newOrder.setPaymentmode(orderDto.getPaymentmode());
        Order placeOrder = orderServices.save(newOrder);
        return ResponseEntity.ok(placeOrder);
    }

    @CrossOrigin(origins = "http://localhost:3001")
    @PutMapping("/cancel/{oid}")
    public ResponseEntity<Order> cancelorder(@PathVariable("oid") int oid)
    {
        Order order = orderServices.cancelOrder(oid);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/product-customer")
    public ResponseEntity<HashMap<String, Object>> getOrders() {
        HashMap<String, Object> response = new HashMap<String, Object>();
        List<Order> orderList = orderServices.findAll();

        for(Order order:orderList)
        {
            response.put("product", order.getProduct());
            response.put("customer",customerService.findById(order.getcId()) ) ;
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/changestatus/{oid}/{status}")
    public ResponseEntity<Order> changeStatus(@PathVariable("oid") int oid,@PathVariable("status") String status)
    {
        System.out.println("inside chnage status");
        Order order=orderServices.findById(oid);
        order.setStatus(status);
        orderServices.save(order);
        return null;

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/assignstaff/{cId}")
    public ResponseEntity<Order> assignStaff(@PathVariable("cId") int cId ,@RequestBody Order order)
    {
        Order order1=orderServices.findById(cId);
        System.out.println("customer id is........... "+order1.getstaffId());
        order1.setstaffId(cId);
        orderServices.save(order);
        return ResponseEntity.ok(order);
    }
}

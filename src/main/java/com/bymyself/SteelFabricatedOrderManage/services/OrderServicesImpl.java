package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import com.bymyself.SteelFabricatedOrderManage.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrderServicesImpl implements OrderServices{

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Order save(Order order) {
        Order placeOrder = orderRepository.save(order);
        return placeOrder;
    }

    @Override
    public List<Order> findByCId(int cid) {
        List<Order> orders = orderRepository.findByStaffId(cid);
        System.out.println(orders);
        return orders;
    }

    @Override
    public Order cancelOrder(int oid) {
        Optional<Order> findOrder = orderRepository.findById(oid);
        Order newOrder = findOrder.get();
        newOrder.setStatus("Cancelled");
        newOrder = orderRepository.save(newOrder);
        return newOrder;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(int oid) {
        Optional<Order> order = orderRepository.findById(oid);
        Order newOrder = order.get();
        return newOrder;
    }

    @Override
    public List<Order> findByStatus(String string) {
        return orderRepository.findByStatus(string);
    }

    @Override
    public List<Order> findByStatusNot(String string) {
        return orderRepository.findByStatusNot(string);
    }

    @Override
    public int getMinStaffId() {
        System.out.println("min staff");
        System.out.println("Min staff :" + orderRepository.getMinStaffId());
        return orderRepository.getMinStaffId();
    }

    @Override
    public List<Order> findByStaff(int id) {
        System.out.println("Inside service method" + id);
        List<Order> orders = orderRepository.findByStaffId(id);
        System.out.println(orders);
        return orders;
    }
}

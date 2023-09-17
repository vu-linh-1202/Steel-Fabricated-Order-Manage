package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.dto.OrderDto;
import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import com.bymyself.SteelFabricatedOrderManage.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderServices {
    Order save(Order order);
    List<Order> findByCId(int cid);
    Order cancelOrder(int oid);
    List<Order> findAll();
    Order findById(int oid);
    List<Order> findByStatus(String string);
    List<Order> findByStatusNot(String string);
    int getMinStaffId();
    List<Order> findByStaff(int id);
}

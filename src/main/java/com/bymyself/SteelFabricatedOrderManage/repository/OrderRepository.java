package com.bymyself.SteelFabricatedOrderManage.repository;

import com.bymyself.SteelFabricatedOrderManage.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByStatus(String status);
    List<Order> findByStatusNot(String string);
    List<Order> findByStaffId(int id);

    @Query(value = "select staff_id from orders where status!='delivered' group by status order by count(staff_id) limit 1", nativeQuery = true)
    int getMinStaffId();
}

package com.bymyself.SteelFabricatedOrderManage.repository;

import com.bymyself.SteelFabricatedOrderManage.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

    Staff save(Staff staff);
    Staff findById(int id);
    Staff findByMail(String mail);
    List<Staff> findByRole(String role);
}

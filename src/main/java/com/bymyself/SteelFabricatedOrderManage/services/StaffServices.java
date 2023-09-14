package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Staff;

import java.util.List;

public interface StaffServices {
    Staff save(Staff staff);
    Staff findById(int id);
    void deleteById(int id);
    Staff authenticate(String mail, String password);
    Staff addStaff(Staff staff);
    List<Staff> findAll();
    List<Staff> findByRole(String role);
    Staff findByMail(String mail);

    void delete(Staff staff);
}

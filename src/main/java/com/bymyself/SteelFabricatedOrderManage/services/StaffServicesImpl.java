package com.bymyself.SteelFabricatedOrderManage.services;

import com.bymyself.SteelFabricatedOrderManage.entities.Staff;
import com.bymyself.SteelFabricatedOrderManage.repository.StaffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class StaffServicesImpl implements StaffServices{

    @Autowired
    private StaffRepository staffRepo;
    @Override
    public Staff save(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public Staff findById(int id) {
        return staffRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
      staffRepo.deleteById(id);
    }

    @Override
    public Staff authenticate(String mail, String password) {
        Staff staff = staffRepo.findByMail(mail);
        if (staff!=null && staff.getPassword().equals(password))
        {
            return staff;
        }
        else
        {
            System.out.println("Authenticate fail by miss email or password");
            return null;
        }
    }

    @Override
    public Staff addStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    @Override
    public List<Staff> findAll() {
        return staffRepo.findAll();
    }

    @Override
    public List<Staff> findByRole(String role) {
        return staffRepo.findByRole(role);
    }

    @Override
    public Staff findByMail(String mail) {
        Staff staff = staffRepo.findByMail(mail);
        if (mail!= null)
        {
            return staff;
        }
        else
        {
            System.out.println("Email invalid!");
            return null;
        }
    }

    @Override
    public void delete(Staff staff) {
        staffRepo.delete(staff);
    }
}

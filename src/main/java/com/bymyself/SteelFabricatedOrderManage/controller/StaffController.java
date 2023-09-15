package com.bymyself.SteelFabricatedOrderManage.controller;

import com.bymyself.SteelFabricatedOrderManage.entities.Staff;
import com.bymyself.SteelFabricatedOrderManage.model.Credential;
import com.bymyself.SteelFabricatedOrderManage.services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffServices staffServices;

    /**
     * This function used to authenticate user by email and password
     * @param cred
     * @return responseData:dữ liệu trả về từ phương thức authenticate.
     */
    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> authenticate(@RequestBody Credential cred)
    {
        System.out.println(cred.getMail()+ cred.getPassword());
        Staff staff = staffServices.authenticate(cred.getMail(), cred.getPassword());
        if(staff == null) throw new RuntimeException("Wrong email with id or password!");
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("status", new String("success"));
        responseData.put("data", staff);
        return ResponseEntity.ok(responseData);
    }

    /**
     * *******************************************DONE**********************
     * @param staff
     * @return
     */
    @PostMapping("")
    public ResponseEntity<Staff> save(@RequestBody Staff staff)
    {
        Staff newStaff = staffServices.save(staff);
        if(newStaff == null) throw new RuntimeException("Something went wrong");
        return ResponseEntity.ok(newStaff);
    }

    /**
     *  ****************************DONE***************************************
     * @return list staff
     */
    @GetMapping("")
    public ResponseEntity<List<Staff>> findAll()
    {
        List<Staff> staffList = staffServices.findAll();
        if(staffList == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(staffList);
    }

    /**
     * ****************************DONE***************************************
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletedById(@PathVariable("id") int id)
    {
        staffServices.deleteById(id);
        return ResponseEntity.ok("Data deleted successfully!");
    }

    @GetMapping("/admin")
    public ResponseEntity<List<Staff>> findAdmin()
    {
        List<Staff> staff = staffServices.findByRole("admin");
        if (staff == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Staff>> findEmployee()
    {
        List<Staff> staff = staffServices.findByRole("employee");
        if (staff == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(staff);
    }

    @GetMapping("/manager")
    public ResponseEntity<List<Staff>> findManager()
    {
        List<Staff> staff = staffServices.findByRole("manager");
        if (staff == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(staff);
    }
}

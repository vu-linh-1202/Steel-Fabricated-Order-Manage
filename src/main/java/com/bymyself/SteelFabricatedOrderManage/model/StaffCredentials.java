package com.bymyself.SteelFabricatedOrderManage.model;

public class StaffCredentials {
    private String mail;
    private String password;
    private String role;

    public StaffCredentials(String mail, String password, String role) {
        super();
        this.mail = mail;
        this.password = password;
        this.role = role;
    }
    public StaffCredentials()
    {
        super();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

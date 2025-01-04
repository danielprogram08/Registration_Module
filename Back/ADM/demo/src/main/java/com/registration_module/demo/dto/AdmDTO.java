package com.registration_module.demo.dto;

public class AdmDTO {
    private String name;
    private String password;

    public AdmDTO() {
    }

    public AdmDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
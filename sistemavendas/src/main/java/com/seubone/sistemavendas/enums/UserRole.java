package com.seubone.sistemavendas.enums;

public enum UserRole {
    GERENTE("gerente"),
    VENDEDOR("vendedor");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
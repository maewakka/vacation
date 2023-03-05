package com.woo.vacation.entity.user;

public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_COMPANY_ADMIN("COMPANY_ADMIN"),
    ROLE_TOP_ADMIN("TOP_ADMIN"),
    ROLE_DEPARTMENT_ADMIN("DEPARTMENT_ADMIN");

    String key;

    Role(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

}

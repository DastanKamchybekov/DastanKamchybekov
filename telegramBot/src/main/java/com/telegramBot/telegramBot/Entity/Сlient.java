package com.telegramBot.telegramBot.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Сlient {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Long externalId;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false, length = 15)
    private String phoneNumber;
    @Column(nullable = false, length = 400)
    private String address;

    public Long getExternalId() {
        return externalId;
    }

    public void setExternalId(Long external_id) {
        this.externalId = external_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String full_name) {
        this.fullName = full_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

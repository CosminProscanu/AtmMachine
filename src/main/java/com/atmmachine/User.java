package com.atmmachine;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int pinCode;

    private String firstname;

    private String lastName;

    private int accountValue;

    private int sumToAdd;

    private int sumToTake;

    public User(int pinCode, String firstname, String lastName, int accountValue) {
        this.pinCode = pinCode;
        this.firstname = firstname;
        this.lastName = lastName;
        this.accountValue = accountValue;
    }
}

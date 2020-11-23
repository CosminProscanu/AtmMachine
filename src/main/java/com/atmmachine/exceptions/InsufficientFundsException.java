package com.atmmachine.exceptions;

public class InsufficientFundsException extends Exception {
    private int suma;

    public InsufficientFundsException(int suma) {
        this.suma = suma;
    }

    public int getSuma() {
        return suma;
    }
}
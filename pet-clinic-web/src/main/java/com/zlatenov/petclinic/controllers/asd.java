package com.zlatenov.petclinic.controllers;

import java.math.BigDecimal;

/**
 * @author Angel Zlatenov
 */

public class asd {
    public static void main(String[] args) {
        int numberOfMonths = 8*12;
        BigDecimal remainingSum = new BigDecimal(100000);
        for (int i = 0; i < numberOfMonths; i++) {
            if (remainingSum.compareTo(BigDecimal.valueOf(50000)) > 0) {
                remainingSum = (remainingSum.multiply(new BigDecimal("1.012"))).subtract(new BigDecimal(1100));
            }
            else{
                remainingSum = (remainingSum.multiply(new BigDecimal("1.01"))).subtract(new BigDecimal(1100));
            }
        }
        System.out.println(remainingSum);
    }
}

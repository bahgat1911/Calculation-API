package com.example.demo2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Table;


@Entity
@Table(name = "calculation")
public class CalculationEntity {

    @Id

    @Column(name = "number1")
    private double number1;

    @Column(name = "number2")
    private double number2;

    @Column(name = "operation")
    private String operation;

    @Column(name = "result")
    private double result;

    public CalculationEntity() {
    }

    public CalculationEntity(double number1, double number2, String operation, double result) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
        this.result = result;
    }


    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    // Other methods...
}


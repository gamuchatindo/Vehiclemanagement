package com.vehiclemanagement.vehiclemanagement.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vehicle")

public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String registrationNo;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private String country;
    @Column
    private LocalDate yearOfManufacture;
    @Column
    private String consumption;

    public Vehicle() {

    }

    public Vehicle(String registrationNo, String make, String model, String country, LocalDate yearOfManufacture, String consumption){
        this.registrationNo=registrationNo;
        this.make=make;
        this.model=model;
        this.country=country;
        this.yearOfManufacture=yearOfManufacture;
        this.consumption=consumption;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(LocalDate yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNo='" + registrationNo + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", country='" + country + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", consumption='" + consumption + '\'' +
                '}';
    }
}

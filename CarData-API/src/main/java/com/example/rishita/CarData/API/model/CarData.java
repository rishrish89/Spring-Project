package com.example.rishita.CarData.API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private Integer manufacturedYear;
    private String company;
    private String bodyType;
    private Float price;
    private String fuelType;
    private Integer seatingCapacity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(Integer manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBodyType() {
        return bodyType;
    }



    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }






}

//
//"model" : "Safari",
//        "manufacturedYear":2023,
//        "company": "Tata",
//        "bodyType": "sedan",
//        "price": 9000000.0,
//        "fuelType":"petrol",
//        "seatingCapacity":7
//
//
//
//        "model" : "city",
//        "manufacturedYear":2023,
//        "company": "Suzuki",
//        "bodyType": "Fronz",
//        "price": 8000000.0,
//        "fuelType":"petrol",
//        "seatingCapacity":5
//
//
//        "model" : "city",
//        "manufacturedYear":2024,
//        "company": "Honda",
//        "bodyType": "sedan",
//        "price": 2000000.0,
//        "fuelType":"petrol",
//        "seatingCapacity":5
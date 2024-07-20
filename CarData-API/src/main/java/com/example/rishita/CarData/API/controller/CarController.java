package com.example.rishita.CarData.API.controller;

import com.example.rishita.CarData.API.model.CarData;
import com.example.rishita.CarData.API.service.CarService;
import com.example.rishita.CarData.API.model.PriceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("CarData")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("add")
    public Object postCarData(@RequestBody CarData cardata){
        return carService.postCarData(cardata);
    }

    @GetMapping("list")
    public Object getAllCarData(){
        return carService.getAllCarData();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Integer id){
        return carService.deleteById(id);
    }


    @PatchMapping("update/{id}")
    public ResponseEntity<Object> updateCarData(@PathVariable("id") Integer id,@RequestBody PriceUpdate priceUpdate){
        return carService.updateCarData(id,priceUpdate);
    }

    @GetMapping("bodyType")
    public Object getSimilarBodyType(@RequestParam String bodyType){
        return carService.getSimilarBodyType(bodyType);
    }
    @GetMapping("seatingCapacityGreaterThan/{value}")
    public Object getSeatingCapacityGreaterThan(@PathVariable Integer value){
        return carService.getSeatingCapacityGreaterThan(value);
    }
    @GetMapping("sortByYear")
    public ResponseEntity<Object> getSortedByYear(){
        return carService.getSortedByYear();
    }
}


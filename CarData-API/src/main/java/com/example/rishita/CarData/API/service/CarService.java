package com.example.rishita.CarData.API.service;

import com.example.rishita.CarData.API.model.PriceUpdate;
import com.example.rishita.CarData.API.model.CarData;
import com.example.rishita.CarData.API.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;


    public Object postCarData(CarData cardata) {
        try{
            carRepo.save(cardata);
            return ResponseEntity.status(HttpStatus.CREATED).body(201);
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }

    public Object getAllCarData() {
        try{
            List<CarData> all= carRepo.findAll();
            if(all.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Available");
            }
            else{
                return ResponseEntity.ok(all);
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }

    public ResponseEntity<Object> deleteById(Integer id) {
        try{
            Optional<CarData> k = carRepo.findById(id);
            if(k.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not Found");
            }
            else{
                carRepo.deleteById(id);
                return ResponseEntity.status(HttpStatus.OK).body(200);
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }

    }

    public ResponseEntity<Object> updateCarData(Integer id, PriceUpdate priceUpdate) {
        try{
            Optional<CarData> temp = carRepo.findById(id);
            if(temp.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(404);
            }
            else {
                CarData k = temp.get();
                k.setPrice(priceUpdate.getPrice());
                CarData save = carRepo.save(k);
                return ResponseEntity.ok(save);
            }



        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }
    }

    public Object getSimilarBodyType(String bodyType) {
        try{
            List<CarData> simi = carRepo.findByBodyType(bodyType);
            if(simi.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
            }
            else{
                return ResponseEntity.ok(simi);
            }

        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }


    }

    public Object getSeatingCapacityGreaterThan(Integer value) {
        try{
            List<CarData> num = carRepo.findBySeatingCapacityGreaterThan(value);
            if(num.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
            }
            else{
                return ResponseEntity.ok(num);
            }



        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }

    }

    public ResponseEntity<Object> getSortedByYear() {
        try{
            List<CarData> sorted = carRepo.findBySortedYear();
            if(sorted.isEmpty()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
            }
            else{
                return ResponseEntity.ok(sorted);
            }
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(400);
        }



    }
}

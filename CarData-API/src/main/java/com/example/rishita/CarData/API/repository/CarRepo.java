package com.example.rishita.CarData.API.repository;

import com.example.rishita.CarData.API.model.CarData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<CarData, Integer> {


    List<CarData> findByBodyType(String bodyType);
//    @Query("from CarData where seatingCapacity > 5")
    List<CarData> findBySeatingCapacityGreaterThan(Integer value);
    @Query("from CarData Order by manufacturedYear asc ")
    List<CarData> findBySortedYear();
}

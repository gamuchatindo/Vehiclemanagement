package com.vehiclemanagement.vehiclemanagement.controller;

import com.vehiclemanagement.vehiclemanagement.model.Vehicle;
import com.vehiclemanagement.vehiclemanagement.repositories.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="vehicle")
public class VehicleController {
    @Autowired
    private VehicleRepo vehicleRepo;

    @GetMapping("/vehicle")
    public ResponseEntity<List<Vehicle>> getAllVehicles(){
        List<Vehicle> vehicles=vehicleRepo.findAll();
        return ResponseEntity.ok(vehicles);
    }
    @GetMapping("/vehicle/{registrationNo}")
    public ResponseEntity<Vehicle> getOneVehicle(@PathVariable ("registrationNo") String registrationNo){
        Optional<Vehicle> vehicle =vehicleRepo.findById(registrationNo);
            Vehicle vehicle1 =vehicle.get();
            return ResponseEntity.ok(vehicle1);

    }
    @PostMapping("/vehicle")
    public ResponseEntity<Vehicle> addVehicles(@RequestBody Vehicle vehicle){
        Vehicle vehicle1=vehicleRepo.save(vehicle);
        return new ResponseEntity<>(vehicle1, HttpStatus.CREATED);
    }
    @PutMapping("/vehicle/{registrationNo}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable ("registrationNo") String registrationNo, @RequestBody Vehicle vehicle){
        Vehicle vehicle1 =vehicleRepo.save(vehicle);
        return new ResponseEntity<>(vehicle1, HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/vehicle/{registrationNo}")
    private ResponseEntity<?> deleteVihicle(@PathVariable("registrationNo") String registrationNo){
        vehicleRepo.deleteById(registrationNo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

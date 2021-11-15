package com.vehiclemanagement.vehiclemanagement.repositories;

import com.vehiclemanagement.vehiclemanagement.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
}

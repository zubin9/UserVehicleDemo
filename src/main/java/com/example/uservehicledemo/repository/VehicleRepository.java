package com.example.uservehicledemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.uservehicledemo.model.Vehicle;

@Repository
@Transactional
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Modifying
	@Query("update Vehicle v set v.user.id = :userId where v.id in (:vehicleIds)")
	public void addVehiclesToUsers(@Param("vehicleIds") List<Long> vehicleIds, @Param("userId") Long userId);
	
	@Modifying
	@Query("update Vehicle v set v.user.id = :userId where v.id = :vehicleId")
	public void updateVehicleOwnership(@Param("userId") Long newUserId, @Param("vehicleId") Long vehicleId);
	
	@Query("select v.user.id from Vehicle v where v.id = :vehicleId")
	public Long getCurrentOwnerId(@Param("vehicleId") Long vehicleId);
} 

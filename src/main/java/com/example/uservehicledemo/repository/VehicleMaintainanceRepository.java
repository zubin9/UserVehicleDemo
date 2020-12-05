package com.example.uservehicledemo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.uservehicledemo.model.VehicleMaintainance;

@Repository
@Transactional
public interface VehicleMaintainanceRepository extends JpaRepository<VehicleMaintainance, Long> {

	@Query("from VehicleMaintainance vm where vm.vehicle.id = :vehicleId and vm.maintainanceDate = :maintainanceDate")
	public List<VehicleMaintainance> findMaintainanceRecord(@Param("vehicleId") Long vehicleId, @Param("maintainanceDate") String maintainanceDate);
} 

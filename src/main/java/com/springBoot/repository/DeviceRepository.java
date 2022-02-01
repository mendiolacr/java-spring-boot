package com.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long>{

}

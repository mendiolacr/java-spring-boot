package com.springBoot.service;

import java.util.Optional;

import com.springBoot.entity.Device;

public interface DeviceService {

	public Iterable<Device> findAll();
	
	public Optional<Device> findById(Long id);
	
	public Device save(Device device);
	
	public void deleteById(Long id);
	
}

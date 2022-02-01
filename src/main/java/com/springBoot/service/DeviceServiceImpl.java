package com.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.entity.Device;
import com.springBoot.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Device> findAll() {
		// TODO Auto-generated method stub
		return deviceRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Device> findById(Long id) {
		// TODO Auto-generated method stub
		return deviceRepository.findById(id);
	}

	@Override
	@Transactional
	public Device save(Device device) {
		// TODO Auto-generated method stub
		return deviceRepository.save(device) ;
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	     deviceRepository.deleteById(id) ;
	}

}

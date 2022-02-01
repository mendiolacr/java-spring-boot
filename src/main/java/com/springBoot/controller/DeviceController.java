package com.springBoot.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entity.Device;
import com.springBoot.entity.Gateway;
import com.springBoot.service.DeviceService;
import com.springBoot.service.GatewayService;

@RestController
@RequestMapping("api/devices")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private GatewayService gatewayService;
	
	//Create new device
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Device device){
		
		Optional<Gateway> oGateway = gatewayService.findById(device.getGatewayid());
		
		if (!oGateway.isPresent()) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The gateway isn't valid");
		}
		
		if (oGateway.get().getDevices().size() == 10) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The gateway only allows 10 devices and is full now");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(deviceService.save(device));
	}
	
	//Read device
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long deviceId){
		Optional<Device> oDevice = deviceService.findById(deviceId);
		
		if (!oDevice.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	    
		return ResponseEntity.ok(oDevice);
	}
	
	//Delete device
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id") Long deviceId){
		if (!deviceService.findById(deviceId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		deviceService.deleteById(deviceId);
		return ResponseEntity.ok().build();	
	}
	
	//Get all device
	@GetMapping
	public List<Device> readAll(){
		
		List<Device> devices =StreamSupport
				.stream(deviceService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return devices;
	}
}

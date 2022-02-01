package com.springBoot.controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.validator.routines.InetAddressValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entity.Gateway;
import com.springBoot.service.GatewayService;

@RestController
@RequestMapping("api/gateways")
public class GatewayController {

	@Autowired
	private GatewayService gatewayService;
	
	//Create new gateway
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Gateway gateway){
        // Get an `InetAddressValidator`
        InetAddressValidator validator = InetAddressValidator.getInstance();
 
        // Validate an IPv4 address
        if (!validator.isValidInet4Address(gateway.getIpv4())) {
        	return ResponseEntity.status(HttpStatus.FORBIDDEN).body("The IP address " + gateway.getIpv4() + " isn't valid");
        }
	    
		return ResponseEntity.status(HttpStatus.CREATED).body(gatewayService.save(gateway));
	}
	
	//Read gateway
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long gatewayid){
		Optional<Gateway> oGateway = gatewayService.findById(gatewayid);
		
		if (!oGateway.isPresent()) {
			return ResponseEntity.notFound().build();
		}
	    return ResponseEntity.ok(oGateway);
	}
	
	//Get all gateway
	@GetMapping
	public List<Gateway> readAll(){
		
		List<Gateway> gateways =StreamSupport
				.stream(gatewayService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return gateways;
	}
}

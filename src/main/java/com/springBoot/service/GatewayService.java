package com.springBoot.service;

import java.util.Optional;

import com.springBoot.entity.Gateway;

public interface GatewayService {

	public Iterable<Gateway> findAll();
	
	public Optional<Gateway> findById(Long id);
	
	public Gateway save(Gateway gateway);
}

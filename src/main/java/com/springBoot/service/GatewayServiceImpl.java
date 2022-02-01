package com.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.entity.Gateway;
import com.springBoot.repository.GatewayRepository;

@Service
public class GatewayServiceImpl implements GatewayService{

	@Autowired
	private GatewayRepository gatewayRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Gateway> findAll() {
		// TODO Auto-generated method stub
		return gatewayRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Gateway> findById(Long id) {
		// TODO Auto-generated method stub
		return gatewayRepository.findById(id);
	}

	@Override
	@Transactional
	public Gateway save(Gateway gateway) {
		// TODO Auto-generated method stub
		return gatewayRepository.save(gateway) ;
	}

}

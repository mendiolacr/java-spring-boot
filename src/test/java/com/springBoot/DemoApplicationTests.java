package com.springBoot;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBoot.entity.Device;
import com.springBoot.entity.Gateway;
import com.springBoot.service.DeviceService;
import com.springBoot.service.GatewayService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private GatewayService gatewayService;
	
	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	public void testCreateGateway () {
		Gateway gateway = new Gateway();
		gateway.setSerialNumber("79049XXXA4S");
		gateway.setName("iPhone XR");
		gateway.setIpv4("192.0.10.3");
		gatewayService.save(gateway);
		assertThat(gatewayService.findById(gateway.getGatewayid()));
	}
	
	@Test
	@Order(1)
	public void testCreateDevice () throws ParseException {
		Device device = new Device();
		device.setUid(32114);
		device.setVendor("VendorName");
	    String sDate1="01/01/2022";  
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
		device.setDate_created(date1);
		deviceService.save(device);
		assertThat(gatewayService.findById(device.getGatewayid()));
	}
}

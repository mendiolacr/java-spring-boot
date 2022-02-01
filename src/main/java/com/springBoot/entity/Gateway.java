package com.springBoot.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "gateways")
public class Gateway{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gatewayid;

	@Column(length = 50,nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String serialNumber;
	
	private String ipv4;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gatewayid")
    private List<Device> devices;
	
	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Long getGatewayid() {
		return gatewayid;
	}

	public void setGatewayid(Long gatewayid) {
		this.gatewayid = gatewayid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	
}

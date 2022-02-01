package com.springBoot.entity;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "devices")
public class Device {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deviceid;
    
	@Column(nullable = false,unique = true)
	private Integer uid;

	@Column(length = 50)
	private String vendor;
	
	private Date date_created;
	
	private Boolean status;
	
	private Long gatewayid;
    

	public Long getGatewayid() {
		return gatewayid;
	}


	public void setGatewayid(Long gatewayid) {
		this.gatewayid = gatewayid;
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public Date getDate_created() {
		return date_created;
	}


	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}


	public Boolean getStatus() {
		return status;
	}


	public Long getDeviceid() {
		return deviceid;
	}


	public void setDeviceid(Long deviceid) {
		this.deviceid = deviceid;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}

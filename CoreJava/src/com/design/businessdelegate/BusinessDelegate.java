package com.design.businessdelegate;

public class BusinessDelegate {
	private BusinessLookUp businessLookUp = new BusinessLookUp();
	private BusinessService businessService;
	private String serviceType;
	
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	public void doTask() {
		businessService = businessLookUp.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}

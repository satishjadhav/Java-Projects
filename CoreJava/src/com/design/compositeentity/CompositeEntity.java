package com.design.compositeentity;

public class CompositeEntity {
	
	CoarseGrainedObject coarseGrainedObject = new CoarseGrainedObject();
	
	public void setData(String data1,String data2) {
		coarseGrainedObject.setData(data1, data2);
	}
	
	public String[] getData() {
		return coarseGrainedObject.getData();
	}
}

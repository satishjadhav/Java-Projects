package com.design.prototype;

public class Shape implements Cloneable
{
	private String id;
	protected String type;
	
	public String getType()
	{
		return type;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	public Object clone()
	{
		Object clone = null;
		try
		{
			clone = super.clone();
		}catch(CloneNotSupportedException cnsex)
		{
			cnsex.printStackTrace();
		}
		return clone;
	}
	
}

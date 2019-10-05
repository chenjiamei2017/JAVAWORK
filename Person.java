package com.demo;

@Entity("Person")

public class Person {
	@ID
	//@Column(nullable=false)
	private Integer id;
	//@Column(nullable=false,length=16)
	private String name;
	public Integer getID()
	{
		return id;
	}
	public void setID(Integer id)
	{
		this.id=id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	
	
	
	

}

package com.xincl.UDP;
@SuppressWarnings("serial")
public class Employee implements java.io.Serializable{   //加上"通行证"serializable才可以进行对象的序列化
	private transient String name;   //该数据不需要序列话，存在透明，敏感数据可以不显示
	private double salary;
	
	public Employee() {
		super();
	}

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
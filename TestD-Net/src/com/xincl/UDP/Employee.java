package com.xincl.UDP;
@SuppressWarnings("serial")
public class Employee implements java.io.Serializable{   //����"ͨ��֤"serializable�ſ��Խ��ж�������л�
	private transient String name;   //�����ݲ���Ҫ���л�������͸�����������ݿ��Բ���ʾ
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
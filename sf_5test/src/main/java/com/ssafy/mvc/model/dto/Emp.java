package com.ssafy.mvc.model.dto;

public class Emp {
	
	private int num;
	private String name;
	private int salary;
	
	public Emp() {};
	
	public Emp(int num, String name, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.salary = salary;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [num=").append(num).append(", name=").append(name).append(", salary=").append(salary)
				.append("]");
		return builder.toString();
	}
	
	

}

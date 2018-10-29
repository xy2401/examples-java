package com.xy2401.example.demo.lambda;

public class Employee {

	private String name;//姓名
	private double salary;//工资
	private int level;//等级 
	private double 工龄;
	
	public Employee(String name, double salary, int level, double 工龄) {
		super();
		this.name = name;
		this.salary = salary;
		this.level = level;
		this.工龄 = 工龄;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public double get工龄() {
		return 工龄;
	}
	public void set工龄(double 工龄) {
		this.工龄 = 工龄;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", level=" + level + ", 工龄=" + 工龄 + "]";
	}
	
	
	
	
	

}

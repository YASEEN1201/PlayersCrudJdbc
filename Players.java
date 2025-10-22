package com.codegnan.Players;

public class Players {
	private int id;
	private String name;
	private int runs;
	private String country;
	private double salary;
	public Players() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Players(int id, String name, int runs, String country, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.runs = runs;
		this.country = country;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Players [id=" + id + ", name=" + name + ", runs=" + runs + ", country=" + country + ", salary=" + salary
				+ "]";
	}

}

package com.example.demo;

import org.springframework.data.annotation.Id;

public class MyDataMongo {
	@Id
	private String id;
	private String name;
	private int first;
	private int second;
	private int third;
	private String email;
	private int principal;
	private double  interest;
	private double  years;
	private double  payment;
	private double  total;
	private double  totalinterest;
	private String textarea;

public MyDataMongo(String name, int first, int second, int third, String email, int principal, double interest, double years, double payment, double total, double totalinterest, String textarea) {
	super();
	this.name = name;
	this.first = first;
	this.second = second;
	this.third = third;
	this.email = email;
	this.principal = principal;
	this.interest = interest;
	this.years = years;
	this.payment = payment;
	this.total = total;
	this.totalinterest = totalinterest;
	this.textarea =textarea;
}
public String getId() {
	return id;
}
public String getName() {
	return name;
}
public int getFirst() {
	return first;
}
public int getSecond() {
	return second;
}
public int getThird() {
	return third;
}
public String getEmail() {
	return email;
}
public int getPrincipal() {
	return principal;
}
public double getInterest() {
	return interest;
}
public double getYears() {
	return years;
}
public double getPayment() {
	return payment;
}
public double getTotal() {
	return total;
}
public double getTotalinterest() {
	return totalinterest;
}
public String getTextarea() {
	return textarea;
}
}
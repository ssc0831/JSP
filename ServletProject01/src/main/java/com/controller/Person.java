package com.controller;

public class Person {
private String name;
private String id;
private String pwd;
private String phone;
private String address;

//생성자 혹은 getter setter 이용

public Person(String name, String id, String pwd, String phone, String address) {
	super();
	this.name = name;
	this.id = id;
	this.pwd = pwd;
	this.phone = phone;
	this.address = address;
}

//getter, setter
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}

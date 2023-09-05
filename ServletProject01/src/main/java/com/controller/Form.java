package com.controller;

public class Form {
private String name;
private int age;
private String gender;
private String[] hobby;
private String job;

//생성자
public Form() {
	
}

public Form(String name, int age, String gender, String[] hobby, String job) {
	this.name = name;
	this.age = age;
	this.gender = gender;
	this.hobby = hobby;
	this.job = job;
}

//getter, setter
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String[] getHobby() {
	return hobby;
}

public void setHobby(String[] hobby) {
	this.hobby = hobby;
}

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}


}

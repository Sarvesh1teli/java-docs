package com.clone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestImmutable {
	public static void main(String[] args) throws ParseException {
		Date d1 = new SimpleDateFormat("dd/MM/yyy").parse("05/10/2011");
		Employee e = new Employee("sarvesh",101,d1);
		
		
		System.out.println("-------Immutable objects--------");
		System.out.println(e.getEmpId()+"--"+e.getName()+"--"+e.getDoj());
		
		System.out.println("-------Changing Date object----");
		d1.setDate(30);
		System.out.println(e.getEmpId()+"--"+e.getName()+"--"+e.getDoj());
		
	}
}
final class Employee {
	private final String name;
    private final int empId;
    private  final Date doj;
    
	
	public Employee(String name, int empId, Date doj) {
		super();
		this.name = name;
		this.empId = empId;
		this.doj = (Date) doj.clone();
	}
	public String getName() {
		return name;
	}
	public int getEmpId() {
		return empId;
	}
	public Date getDoj() {
		return doj;
		//return new Date(this.doj.getTime());
	}
}
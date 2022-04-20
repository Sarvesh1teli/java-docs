package com.clone;

public class TestDeepClone {
	public static void main(String[] args) {
		EngineeringCourse c1 = new EngineeringCourse("Physics","Maths","Chemistry");
		EngineeringStudent s1 = new EngineeringStudent(100,"Sarvesh",c1);
		EngineeringStudent s2 = null;
		try {
			 s2 = (EngineeringStudent) s1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println("==============Original Object=============");
		System.out.println(s1.getName()+"-"+s1.getSid()+"-"+s1.getCourse().getSub1());
		System.out.println("======Cloned object================");
		System.out.println(s2.getName()+"-"+s2.getSid()+"-"+s2.getCourse().getSub1());
		
		System.out.println("=====Changing cloned object========");
		s2.getCourse().setSub1("Biology");
		System.out.println(s2.getName()+"-"+s2.getSid()+"-"+s2.getCourse().getSub1());
		
		System.out.println("==============after changing ref Original Object=============");
		System.out.println(s1.getName()+"-"+s1.getSid()+"-"+s1.getCourse().getSub1());
	}
}
class EngineeringStudent implements Cloneable {
	private int sid;
	private String name;
	private EngineeringCourse course;

	public EngineeringStudent(int sid, String name, EngineeringCourse course) {
		super();
		this.sid = sid;
		this.name = name;
		this.course = course;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EngineeringCourse getCourse() {
		return course;
	}

	public void setCourse(EngineeringCourse course) {
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		EngineeringStudent st = (EngineeringStudent) super.clone();
		st.course = (EngineeringCourse) course.clone();
		//st.setCourse((EngineeringCourse) st.getCourse().clone());
		return st;
	}
}

class EngineeringCourse implements Cloneable{
	private String sub1;
	private String sub2;
	private String sub3;

	public EngineeringCourse(String sub1, String sub2, String sub3) {
		super();
		this.sub1 = sub1;
		this.sub2 = sub2;
		this.sub3 = sub3;
	}

	public String getSub1() {
		return sub1;
	}

	public void setSub1(String sub1) {
		this.sub1 = sub1;
	}

	public String getSub2() {
		return sub2;
	}

	public void setSub2(String sub2) {
		this.sub2 = sub2;
	}

	public String getSub3() {
		return sub3;
	}

	public void setSub3(String sub3) {
		this.sub3 = sub3;
	}
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
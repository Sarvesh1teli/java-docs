package com.clone;

public class TestShallowClone {
	public static void main(String[] args) {
		Course c1 = new Course("Physics","Maths","Chemistry");
		Student s1 = new Student(100,"Sarvesh",c1);
		Student s2 = null;
		try {
			 s2 = (Student) s1.clone();
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

class Student implements Cloneable {
	private int sid;
	private String name;
	private Course course;

	public Student(int sid, String name, Course course) {
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Course {
	private String sub1;
	private String sub2;
	private String sub3;

	public Course(String sub1, String sub2, String sub3) {
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
}

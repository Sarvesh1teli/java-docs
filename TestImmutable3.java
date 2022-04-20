package com.clone;

import java.util.ArrayList;
import java.util.List;

public class TestImmutable3 {
	private static final int sizeInMeg = 200;

	public static void main(String args[]) {
		User1 share1 = new User1("Duke", 10); // 1
		User1 share2 = new User1("Duke2", 10); // 1
		List<User1> list = new ArrayList<>();
		list.add(share1);
		list.add(share2);
		DiskDriveInfo1 dd = new DiskDriveInfo1(sizeInMeg, "myDrive", list); // 2

		List<User1> share = dd.share();
		 System.out.println("Users with shared access are " +
                 ((User1)(share.get(0))).userName() + ", " +
                 ((User1)(share.get(1))).userName());

		share1.setUserName("Fred"); // 3
		System.out.println("User with shared access is " + share.get(0).userName()+","+share.get(1).userName());
	}
}

final class DiskDriveInfo1 {
	private final int driveSize;
	private final String volumeLabel;
	private final List<User1> driveShare;

	DiskDriveInfo1(int size, String volLabel, List<User1> share) {
		driveSize = size;
		volumeLabel = volLabel;
		driveShare = share;
	}

	public int size() {
		return driveSize;
	}

	public String label() {
		return volumeLabel;
	}

	public List<User1> share() {
		return cloneList(driveShare);
	}
	
	public List<User1> cloneList(List<User1> sourceList){
		List<User1> targetList = new ArrayList<>();
		for (int i=0; i<sourceList.size(); i++)                //For each element
			targetList.add((User1) sourceList.get(i).clone());
		
		return targetList;
		
	}
}

class User1 implements Cloneable {
	private String userName;	
	private String userID;
	private int userNode;

	User1(String name, int node) {
		userName = name;
		userNode = node;
	}

	public void setUserName(String name) {
		userName = name;
	}

	public void setUserID(String userid) {
		userID = userid;
	}

	public void setUserNode(int node) {
		userNode = node;
	}

	public String userName() {
		return userName;
	}
	
	protected Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
